/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author Fairuz
 */
@Entity
@XmlRootElement
public class Category implements Serializable {
    
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;

    @Column(name = "category_name")
    private String categoryName;
    
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> productList;

    public Category() {
    }
    
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    
    public Category(String categoryName, List<Product> products, List<Product> productList) {
        this.categoryName = categoryName;
        this.productList = productList;
    }
    
    
    public Long getID() {
        return Id;
    }

    public void setID(Long ID) {
        this.Id = ID;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.categoryName, other.categoryName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public String toString() {
        return "Category{" + "Id=" + Id + ", categoryName=" + categoryName + ", productList=" + productList + '}';
    }
    
    
    
}
