/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Account;
import entities.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tatsuya
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> implements PersonFacadeLocal {

    @PersistenceContext(unitName = "FoodOrder-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    @Override
    public int getMaxIDPerson() {
        Query query1 = em.createQuery("SELECT MAX(b.id) FROM Person b");
        int bo_max = (Integer) query1.getSingleResult();
        return bo_max;
    }

    @Override
    public Person getPersonFromAccount(Account account) {
        System.out.println("username = " + account.getUsername());
        Query query1 = em.createQuery(
                "SELECT p FROM Person p WHERE p.accountUsername = :accountUsername")
                .setParameter(
                        "accountUsername", account);
        Person bo_max = (Person) query1.getSingleResult();
        return bo_max;
    }

    @Override
    public Person getPersonFromString(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        Query query1 = em.createQuery(
                "SELECT p FROM Person p WHERE p.accountUsername = :accountUsername")
                .setParameter(
                        "accountUsername", account);
        Person bo_max = (Person) query1.getSingleResult();
        return bo_max;
    }

}
