/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Customer;
import entities.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tatsuya
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "FoodOrder-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public Customer findByPerson(Person person) {
        Query query1 = em.createQuery(
                "SELECT c FROM Customer c WHERE c.person = :person")
                .setParameter(
                        "person", person);
        Customer bo_max = (Customer) query1.getSingleResult();
        return bo_max;
    }

}
