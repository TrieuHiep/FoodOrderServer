/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.sun.xml.bind.CycleRecoverable;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tatsuya
 */
@Entity
@Table(name = "Food")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f")
    , @NamedQuery(name = "Food.findById", query = "SELECT f FROM Food f WHERE f.id = :id")
    , @NamedQuery(name = "Food.findByProductName", query = "SELECT f FROM Food f WHERE f.productName = :productName")
    , @NamedQuery(name = "Food.findByPrice", query = "SELECT f FROM Food f WHERE f.price = :price")
    , @NamedQuery(name = "Food.findByQuantity", query = "SELECT f FROM Food f WHERE f.quantity = :quantity")
    , @NamedQuery(name = "Food.findByImageURL", query = "SELECT f FROM Food f WHERE f.imageURL = :imageURL")})
public class Food implements Serializable, CycleRecoverable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private long price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Size(max = 255)
    @Column(name = "ImageURL")
    private String imageURL;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "food")
    private Hamburger hamburger;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodID")
    private List<Meal> mealList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "food")
    private Chicken chicken;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "food")
    private Rice rice;

    public Food() {
    }

    public Food(Integer id) {
        this.id = id;
    }

    public Food(Integer id, long price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public void setHamburger(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @XmlTransient
    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    public Rice getRice() {
        return rice;
    }

    public void setRice(Rice rice) {
        this.rice = rice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Food[ id=" + id + " ]";
    }

    @Override
    public Object onCycleDetected(Context cntxt) {
        return null;
    }
    
}
