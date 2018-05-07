/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.sun.xml.bind.CycleRecoverable;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tatsuya
 */
@Entity
@Table(name = "Chicken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chicken.findAll", query = "SELECT c FROM Chicken c")
    , @NamedQuery(name = "Chicken.findByFoodID", query = "SELECT c FROM Chicken c WHERE c.foodID = :foodID")})
public class Chicken implements Serializable, CycleRecoverable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FoodID")
    private Integer foodID;
    @JoinColumn(name = "FoodID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Food food;

    public Chicken() {
    }

    public Chicken(Integer foodID) {
        this.foodID = foodID;
    }

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodID != null ? foodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chicken)) {
            return false;
        }
        Chicken other = (Chicken) object;
        if ((this.foodID == null && other.foodID != null) || (this.foodID != null && !this.foodID.equals(other.foodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Chicken[ foodID=" + foodID + " ]";
    }

    @Override
    public Object onCycleDetected(Context cntxt) {
        return null;
    }
    
}
