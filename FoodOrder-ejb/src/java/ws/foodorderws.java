/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.CustomerFacadeLocal;
import bean.FoodOrderFacadeLocal;
import bean.MealBeanLocal;
import bean.MealFacadeLocal;
import bean.PersonFacadeLocal;
import entities.Account;
import entities.Customer;
import entities.Food;
import entities.FoodOrder;
import entities.Meal;
import entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author tatsuya
 */
@WebService(serviceName = "foodorderws")
@Stateless()
public class foodorderws {

    @EJB
    private CustomerFacadeLocal customerFacade;

    @EJB
    private MealFacadeLocal mealFacade; //stateless

    @EJB
    private PersonFacadeLocal personFacade;

    @EJB
    private FoodOrderFacadeLocal foodOrderFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getAllOrder")
    public List<FoodOrder> getAllOrder() {
        return this.foodOrderFacade.findAll();
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "saveOrderTest")
    public Boolean saveOrderTest(@WebParam(name = "account") Account account) {

        Person person = this.personFacade
                .getPersonFromAccount(account);
        Customer customer = person.getCustomer();
        List<Meal> mealList = customer.getMealList();

        mealList.forEach(meal -> {
            FoodOrder order = new FoodOrder();
            order.setAddress("Ha Noi");
            order.setCreattionDate("2018-04-15");
            order.setPaymentType("Cash");
            order.setStatus("Sent");
            order.setMealID(meal);
            this.foodOrderFacade.create(order);
        });
        System.out.println("saved order to DB");
        return true;
    }

    @WebMethod(operationName = "getOrdersTest")
    public List<FoodOrder> getOrdersTest(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password
    ) {
        List<FoodOrder> result = new ArrayList<>();
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        Person person = this.personFacade
                .getPersonFromAccount(account);
        System.out.println(person);
        Customer customer = customerFacade.findByPerson(person);

        customer.getMealList().forEach(meal -> {
            System.out.println("a meal detected!");
            System.out.println("num of order = " + meal.getFoodOrderList().size());
            System.out.println("content: ");
            meal.getFoodOrderList().forEach(order -> {
                System.out.println(order.getId());
                System.out.println(order.getStatus());
                System.out.println(order.getMealID().getFoodID().getImageURL());
            });

            result.addAll(meal.getFoodOrderList());
        });

        result.forEach(order -> {
            System.out.println(order);
        });
        return result;
    }

    @WebMethod(operationName = "getOrders")
    public List<FoodOrder> getOrders(@WebParam(name = "account") Account account) {
        List<FoodOrder> result = new ArrayList<>();
        Account loggedAccount = new Account();
        loggedAccount.setUsername(account.getUsername());
        loggedAccount.setPassword(account.getPassword());
        
        Person person = this.personFacade
                .getPersonFromAccount(loggedAccount);
        System.out.println(person);
        Customer customer = customerFacade.findByPerson(person);

        customer.getMealList().forEach(meal -> {
            System.out.println("a meal detected!");
            System.out.println("num of order = " + meal.getFoodOrderList().size());
            System.out.println("content: ");
            meal.getFoodOrderList().forEach(order -> {
                System.out.println(order.getId());
                System.out.println(order.getStatus());
                System.out.println(order.getMealID().getFoodID().getImageURL());
            });

            result.addAll(meal.getFoodOrderList());
        });

        result.forEach(order -> {
            System.out.println(order);
        });
        return result;
    }
}
