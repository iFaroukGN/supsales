/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.DAOBean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jva.supinfo.supsales.entities.Product;
import jva.supinfo.supsales.entities.Users;
import jva.supinfo.supsales.utils.PersistenceManager;

/**
 *
 * @author Fairuz
 */
public class BaseEntity<T, PK extends Serializable> {

    private EntityManager entityManager;
    protected Class<T> entityClass;
    private EntityManagerFactory emf = null;

    public BaseEntity() {
    }

    protected BaseEntity(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T add(T t) {

        entityManager = PersistenceManager.getEntityManager();

        entityManager.getTransaction().begin();
        if (!entityManager.contains(t)) {
            // persist object - add to entity manager
            entityManager.persist(t);
            // flush em - save to DB
            entityManager.flush();
        }
        // commit transaction at all
        entityManager.getTransaction().commit();
        entityManager.refresh(t);
        return t;
    }

    public List<T> getAll() {
        entityManager = PersistenceManager.getEntityManager();
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o";
        Query query = this.entityManager.createQuery(jpql);
        return query.getResultList();
    }

    public List<T> getAll(String proprieteTri, boolean triASC) {
        entityManager = PersistenceManager.getEntityManager();
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o ORDER BY o." + proprieteTri + " " + (triASC ? "ASC" : "DESC");
        Query query = this.entityManager.createQuery(jpql);
        return query.getResultList();
    }

    public List<T> getByName(String productToSearch) {
        entityManager = PersistenceManager.getEntityManager();
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o WHERE o." + this.entityClass.getSimpleName().toLowerCase() + "Name LIKE :name";
        Query query = entityManager.createQuery(jpql).setParameter("name", "%" + productToSearch + "%");
        return query.getResultList();
    }
    
    public List<T> getByCategory(String category) {
        entityManager = PersistenceManager.getEntityManager();
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o WHERE o.productCategory LIKE :name";
        Query query = entityManager.createQuery(jpql).setParameter("name", "%" + category + "%");
        return query.getResultList();
    }
    
    public List<T> getByUserName(String name) {
        entityManager = PersistenceManager.getEntityManager();
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o WHERE o.userName LIKE :name";
        Query query = entityManager.createQuery(jpql).setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List<T> getById(PK id) {
        entityManager = PersistenceManager.getEntityManager();
        T entite = this.entityManager.find(this.entityClass, id);
        entityManager.refresh(entite);
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o WHERE o.Id = :id";
        Query query = entityManager.createQuery(jpql).setParameter("id", id);
        return query.getResultList();
    }

    public T update(T t) {
        entityManager = PersistenceManager.getEntityManager();
        entityManager.getTransaction().begin();
        this.entityManager.merge(t);
        entityManager.getTransaction().commit();
        return t;
    }

    public void delete(PK id) {
        entityManager = PersistenceManager.getEntityManager();
        T entite = this.entityManager.find(this.entityClass, id);
        entityManager.getTransaction().begin();
        this.entityManager.remove(entite);
        entityManager.getTransaction().commit();
    }

}
