/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Account;
import entities.Person;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tatsuya
 */
@Local
public interface PersonFacadeLocal {

    void create(Person person);

    void edit(Person person);

    void remove(Person person);

    Person find(Object id);

    List<Person> findAll();

    List<Person> findRange(int[] range);

    int count();

    public abstract int getMaxIDPerson();

    public abstract Person getPersonFromAccount(Account account);

    public abstract Person getPersonFromString(String username, String password);
        
}
