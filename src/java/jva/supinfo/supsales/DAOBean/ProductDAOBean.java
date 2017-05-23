/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.DAOBean;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jva.supinfo.supsales.entities.Product;

/**
 *
 * @author Fairuz
 */
public class ProductDAOBean extends BaseEntity<Product, Long>{

    public ProductDAOBean() {
        super(Product.class);
    }

}
