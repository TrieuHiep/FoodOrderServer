/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.FoodFacadeLocal;
import entities.Food;
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
@WebService(serviceName = "foodws")
@Stateless()
public class foodws {

    @EJB
    private FoodFacadeLocal foodFacade;

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "getAllFood")
    public List<Food> getAllFood() {
        return this.foodFacade.findAll();
    }

    @WebMethod(operationName = "createFoodObject")
    public Boolean createFoodObject(@WebParam(name = "food") Food food) {
        this.foodFacade.create(food);
        return true;
    }

    @WebMethod(operationName = "searchFoodByName")
    public List<Food> searchFoodByName(@WebParam(name = "query") String query) {
        return this.foodFacade.searchFoodByname(query);
    }
}
