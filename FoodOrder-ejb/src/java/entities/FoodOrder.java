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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tatsuya
 */
@Entity
@Table(name = "FoodOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodOrder.findAll", query = "SELECT f FROM FoodOrder f")
    , @NamedQuery(name = "FoodOrder.findById", query = "SELECT f FROM FoodOrder f WHERE f.id = :id")
    , @NamedQuery(name = "FoodOrder.findByCreattionDate", query = "SELECT f FROM FoodOrder f WHERE f.creattionDate = :creattionDate")
    , @NamedQuery(name = "FoodOrder.findByPaymentType", query = "SELECT f FROM FoodOrder f WHERE f.paymentType = :paymentType")
    , @NamedQuery(name = "FoodOrder.findByStatus", query = "SELECT f FROM FoodOrder f WHERE f.status = :status")
    , @NamedQuery(name = "FoodOrder.findByAddress", query = "SELECT f FROM FoodOrder f WHERE f.address = :address")})
public class FoodOrder implements Serializable, CycleRecoverable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "CreattionDate")
    private String creattionDate;
    @Size(max = 255)
    @Column(name = "PaymentType")
    private String paymentType;
    @Size(max = 45)
    @Column(name = "Status")
    private String status;
    @Size(max = 1000)
    @Column(name = "Address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private List<Bill> billList;
    @JoinColumn(name = "MealID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Meal mealID;

    public FoodOrder() {
    }

    public FoodOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreattionDate() {
        return creattionDate;
    }

    public void setCreattionDate(String creattionDate) {
        this.creattionDate = creattionDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public Meal getMealID() {
        return mealID;
    }

    public void setMealID(Meal mealID) {
        this.mealID = mealID;
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
        if (!(object instanceof FoodOrder)) {
            return false;
        }
        FoodOrder other = (FoodOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "entities.FoodOrder[ id=" + id + " ]";

    @Override
    public String toString() {
        return "FoodOrder{" + "id=" + id + ", creattionDate=" + creattionDate + ", paymentType=" + paymentType + ", status=" + status + ", address=" + address + ", billList=" + billList + ", mealID=" + mealID + '}';
    }

//    }
    @Override
    public Object onCycleDetected(Context cntxt) {
        return null;
    }
    
}
