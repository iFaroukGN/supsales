/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Fairuz
 */
public class PersistenceManager {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;

	/**
	 * MÃ©thode servant Ã  rÃ©cupÃ©rer l'entity manager factory. Elle assure le fait
	 * qu'il n'y aura qu'un seul EntityManagerFactory de crÃ©er pour toute
	 * l'application
	 * 
	 * @return
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("SupSalesPU");
		}
		return emf;
	}
        
        public static EntityManager getEntityManager() {
            em = PersistenceManager.getEntityManagerFactory().createEntityManager();
            return em;
        }

	/**
	 * MÃ©thode permetant de fermer l'EntityManagerFactory. Evidement il ne faut
	 * surtout pas l'appeller sauf au moment de quitter l'application.
	 */
	public static void closeEntityManagerFactory() {
		if (emf != null && emf.isOpen())
			emf.close();
	}
}
