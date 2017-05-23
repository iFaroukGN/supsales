/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fairuz
 */

@Entity(name="Product")
@XmlRootElement
public class Product implements Serializable {
    
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_description")
    private String produtDescription;
    
    @Column(name = "product_price")
    private Double productPrice;
   
    @Column(name = "product_picture")
    private String productPicture;
    
    @Column(name = "published_date")
    @Temporal(TemporalType.DATE)
    private Date publishedDate;
    
    @OneToOne
    @JoinColumn (name = "product_category",nullable = true)
    private Category productCategory;
   
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "published_by_user")
    private Users publishedByUser;

    public Product() {
    }

    public Product(Long Id, String productName, String produtDescription, Double productPrice, String productPicture, Date publishedDate, Category productCategory, Category category, Users publishedByUser) {
        this.Id = Id;
        this.productName = productName;
        this.produtDescription = produtDescription;
        this.productPrice = productPrice;
        this.productPicture = productPicture;
        this.publishedDate = publishedDate;
        this.productCategory = productCategory;
        this.category = category;
        this.publishedByUser = publishedByUser;
    }

    
    
    public Product(String productName, String produtDescription, Double productPrice, String productPicture, Date publishedDate, Category productCategory, Category category, Users publishedByUser) {
        this.productName = productName;
        this.produtDescription = produtDescription;
        this.productPrice = productPrice;
        this.productPicture = productPicture;
        this.publishedDate = publishedDate;
        this.productCategory = productCategory;
        this.category = category;
        this.publishedByUser = publishedByUser;
    }

    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProdutDescription() {
        return produtDescription;
    }

    public void setProdutDescription(String produtDescription) {
        this.produtDescription = produtDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Users getPublishedByUser() {
        return publishedByUser;
    }

    public void setPublishedByUser(Users publishedByUser) {
        this.publishedByUser = publishedByUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", produtDescription=" + produtDescription + ", productPrice=" + productPrice + ", productPicture=" + productPicture + ", publishedDate=" + publishedDate + ", productCategory=" + productCategory.getCategoryName() + ", category=" + category.getCategoryName() + ", publishedByUser=" + publishedByUser.getUserName() + '}';
    }
}
