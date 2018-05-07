/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.AccountFacadeLocal;
import bean.CustomerFacadeLocal;
import bean.PersonFacadeLocal;
import entities.Account;
import entities.Customer;
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
@WebService(serviceName = "customerws")
@Stateless()
public class customerws {

    @EJB
    private PersonFacadeLocal personFacade;

    @EJB
    private AccountFacadeLocal accountFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "addCustomer")
    public Boolean addCustomer(
            @WebParam(name = "person") Person person,
            @WebParam(name = "email") String email) {

        System.out.println(person.getFullName());
        System.out.println(person.getAge());
        System.out.println(person.getAccountUsername().getUsername());
        System.out.println(person.getAccountUsername().getPassword());
        System.out.println(email);
        this.accountFacade.create(person.getAccountUsername());
        System.out.println("cac");

        this.personFacade.create(person);
        System.out.println("cac again");

        int maxID = this.personFacade.getMaxIDPerson();
        System.out.println("Max ID = " + maxID);
        Customer customer = new Customer();
        customer.setPersonID(maxID);
        customer.setPerson(person);
        customer.setEmail(email);

        this.customerFacade.create(customer);
        System.out.println("done!");
        return true;
    }

    @WebMethod(operationName = "addFBCustomer")
    public Boolean addFBCustomer(
            @WebParam(name = "person") Person person,
            @WebParam(name = "email") String email,
            @WebParam(name = "type") String type) {

        switch (type) {
            case "FB": {
                Account exsitAccount = this.accountFacade.find(person.getAccountUsername().getUsername());
                if (exsitAccount != null) {
                    System.out.println("dont need to create fb account...");
                    break;
                } else {
                    System.out.println("creating new user with fb id...");
//                    createCustomer(person, email);
//                    System.out.println(person.getFullName());
//                    System.out.println(person.getAge());
//                    System.out.println(person.getAccountUsername().getUsername());
//                    System.out.println(email);

                    System.out.println(person.getFullName());
                    System.out.println(person.getAge());
                    System.out.println(person.getAccountUsername().getUsername());
                    System.out.println(person.getAccountUsername().getPassword());
                    System.out.println(email);
                    this.accountFacade.create(person.getAccountUsername());
                    System.out.println("cac");

                    this.personFacade.create(person);
                    System.out.println("cac again");

                    int maxID = this.personFacade.getMaxIDPerson();
                    System.out.println("Max ID = " + maxID);
                    Customer customer = new Customer();
                    customer.setPersonID(maxID);
                    customer.setPerson(person);
                    customer.setEmail(email);

                    this.customerFacade.create(customer);
                    System.out.println("done!");
                }
                break;
            }
            default: {
                System.out.println("creating normal customer....");
//                createCustomer(person, email);
            }
        }

        return true;
    }

    public void createCustomer(Person person, String email) {
        System.out.println(person.getFullName());
        System.out.println(person.getAge());
        System.out.println(person.getAccountUsername().getUsername());
        System.out.println(person.getAccountUsername().getPassword());
        System.out.println(email);
        this.accountFacade.create(person.getAccountUsername());
        System.out.println("cac");

        this.personFacade.create(person);
        System.out.println("cac again");

        int maxID = this.personFacade.getMaxIDPerson();
        System.out.println("Max ID = " + maxID);
        Customer customer = new Customer();
        customer.setPersonID(maxID);
        customer.setPerson(person);
        customer.setEmail(email);

        this.customerFacade.create(customer);
        System.out.println("done!");
    }

    @WebMethod(operationName = "testMethod")
    public Boolean testMethod() {
        int maxID = this.personFacade.getMaxIDPerson();
        System.out.println("Max ID = " + maxID);
        return true;
    }
}
