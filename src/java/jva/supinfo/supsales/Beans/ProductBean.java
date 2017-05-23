/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jva.supinfo.supsales.DAOBean.ProductDAOBean;
import jva.supinfo.supsales.entities.Product;

/**
 *
 * @author Fairuz
 */
public class ProductBean {

    private Product _Produit;
    private List<Product> _ListProduct;
    private ProductDAOBean _ProductDaoBean;

    public ProductBean() {
        this._Produit = new Product();
    }

    
    public Product getProduit() {
        return _Produit;
    }

    public void setProduit(Product produit) {
        this._Produit = produit;
    }

    public List<Product> getListProduct() {
        _ListProduct = new ArrayList<Product>();
        _ProductDaoBean = new ProductDAOBean();
        _ListProduct = _ProductDaoBean.getAll();
        return _ListProduct;
    }
    
    public List<Product> getProductByName(String productToSearch){
        _ListProduct = new ArrayList<Product>();
        _ProductDaoBean = new ProductDAOBean();
        _ListProduct = _ProductDaoBean.getByName(productToSearch);
        return _ListProduct;
    }
    
    public List<Product> getProductByCategory(String category){
        _ListProduct = new ArrayList<Product>();
        _ProductDaoBean = new ProductDAOBean();
        _ListProduct = _ProductDaoBean.getByCategory(category);
        return _ListProduct;
    }
    public List<Product> getListProductById(String id) {
        _ListProduct = new ArrayList<Product>();
        _ProductDaoBean = new ProductDAOBean();
        _ListProduct = _ProductDaoBean.getById(Long.parseLong(id));
        return _ListProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this._ListProduct = listProduct;
    }

    public ProductDAOBean getProductDaoBean() {
        return _ProductDaoBean;
    }

    public void setProductDaoBean(ProductDAOBean productDaoBean) {
        this._ProductDaoBean = productDaoBean;
    }

}
