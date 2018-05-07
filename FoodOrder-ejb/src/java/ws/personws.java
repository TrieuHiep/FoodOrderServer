/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.PersonFacadeLocal;
import entities.Account;
import entities.Person;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author tatsuya
 */
@WebService(serviceName = "personws")
@Stateless()
public class personws {

    @EJB
    private PersonFacadeLocal personFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "addPerson")
    public Boolean addPerson(@WebParam(name = "person") Person person) {
        System.out.println(person.getAccountUsername().getUsername());
        System.out.println(person.getAccountUsername().getPassword());
//        System.out.println(customer.getPerson().getAge());
//        System.out.println(customer.getPerson().getFullName());
//        this.accountFacade.create(customer.getPerson().getAccountUsername());
//        System.out.println("cac");
//
//        this.personFacade.create(customer.getPerson());
//        System.out.println("cac again");
//
//        int maxID = this.personFacade.getMaxIDPerson();
//        System.out.println("Max ID = " + maxID);
//        customer.setPersonID(maxID);
//
//        this.customerFacade.create(customer);
        return true;
    }

    @WebMethod(operationName = "getPersonFromAccount")
    public Person getPersonFromAccount(@WebParam(name = "account") Account account) {
        return this.personFacade.getPersonFromAccount(account);
    }

    @WebMethod(operationName = "getPersonFromString")
    public Person getPersonFromString(@WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {
        return this.personFacade.getPersonFromString(username, password);
    }
}
