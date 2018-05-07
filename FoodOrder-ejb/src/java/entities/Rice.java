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
@Table(name = "Rice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rice.findAll", query = "SELECT r FROM Rice r")
    , @NamedQuery(name = "Rice.findByFoodID", query = "SELECT r FROM Rice r WHERE r.foodID = :foodID")})
public class Rice implements Serializable, CycleRecoverable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FoodID")
    private Integer foodID;
    @JoinColumn(name = "FoodID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Food food;

    public Rice() {
    }

    public Rice(Integer foodID) {
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
        if (!(object instanceof Rice)) {
            return false;
        }
        Rice other = (Rice) object;
        if ((this.foodID == null && other.foodID != null) || (this.foodID != null && !this.foodID.equals(other.foodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Rice[ foodID=" + foodID + " ]";
    }

    @Override
    public Object onCycleDetected(Context cntxt) {
        return null;
    }
    
}
