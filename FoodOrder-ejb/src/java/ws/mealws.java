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
import entities.Hamburger;
import entities.Meal;
import entities.Person;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author tatsuya
 */
@WebService(serviceName = "mealws")
@Stateless()
public class mealws {
    
    @EJB
    private CustomerFacadeLocal customerFacade;
    
    @EJB
    private FoodOrderFacadeLocal foodOrderFacade;
    
    @EJB
    private PersonFacadeLocal personFacade;
    
    @EJB
    private MealFacadeLocal mealFacade;
    
    @EJB
    private MealBeanLocal mealBean; //stateful

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getAllMealList")
    public List<Food> getAllMealList(@WebParam(name = "account") Account account) {
        return this.mealBean.getMealList(account);
    }
    
    @WebMethod(operationName = "removeProduct")
    public Boolean removeProduct(@WebParam(name = "account") Account account,
            @WebParam(name = "index") Integer index) {
        this.mealBean.removeProduct(account, index);
        return true;
    }
    
    @WebMethod(operationName = "addProduct")
    public Boolean addProduct(@WebParam(name = "account") Account account,
            @WebParam(name = "food") Food food) {
        System.out.println(food);
        this.mealBean.addProduct(account, food);
        return true;
    }
    
    @WebMethod(operationName = "saveMealToDB")
    public Boolean saveMealToDB(@WebParam(name = "account") Account account,
            @WebParam(name = "address") String address,
            @WebParam(name = "paymentType") String paymentType
    ) {
        Person person = this.personFacade
                .getPersonFromAccount(account);
        
        System.out.println("dm get id =" + person.getId());
        System.out.println(person.getFullName());
        System.out.println();
        Customer customer = person.getCustomer();
        if (customer == null) {
            System.out.println("con cac tao ne");
        }
        System.out.println(customer.getPersonID());
        List<Food> foodList = this.mealBean.getMealList(account);
        foodList.forEach(food -> {
            System.out.println("a meal");
            Meal meal = new Meal();
            meal.setCustomerPersonID(customer);
            meal.setFoodID(food);
            meal.setQuantity(food.getQuantity());
            this.mealFacade.create(meal);
        });
        System.out.println("saved meal to DB");
        
        Customer c = this.customerFacade.findByPerson(person);
        List<Meal> mealList = c.getMealList();
        
        
        for(Meal meal : mealList){
            FoodOrder order = new FoodOrder();
            order.setAddress(address);
            order.setCreattionDate(getTimeNow());
            order.setPaymentType(paymentType);
            order.setStatus("Sent");
            order.setMealID(meal);
            System.out.println("-------Order Information---------");
            System.out.println(order.getCreattionDate());
            System.out.println(order.getPaymentType());
            System.out.println(order.getAddress());
            System.out.println(order.getMealID());
            System.out.println(order.getStatus());
            this.foodOrderFacade.create(order);
        }
        System.out.println("saved order to DB");
        
        this.mealBean.removeProductList(account);
        System.out.println("deleted list food from cart");
        return true;
    }
    
    private String getTimeNow() {
        DateFormat dFormatter = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String dateNow = dFormatter.format(calendar.getTime());
        if (calendar.get(Calendar.HOUR_OF_DAY) == 0 && calendar.get(Calendar.MINUTE) < 30) {
            calendar.add(Calendar.DAY_OF_YEAR, -1);
        }
        String date = dFormatter.format(calendar.getTime());
        return date;
    }
    
    @WebMethod(operationName = "updateQuantity")
    public Boolean updateQuantity(@WebParam(name = "account") Account account,
            @WebParam(name = "food") Food food) {
        List<Food> foodList = this.mealBean.getMealList(account);
        foodList.get(foodList.indexOf(food)).setQuantity(food.getQuantity());
        System.out.println("new quantity = " + food.getQuantity() + " with ID  = " + food.getId());
        return true;
    }
}
