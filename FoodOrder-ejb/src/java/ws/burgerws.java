/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.FoodFacadeLocal;
import bean.HamburgerFacadeLocal;
import entities.Food;
import entities.Hamburger;
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
@WebService(serviceName = "burgerws")
@Stateless()
public class burgerws {

    @EJB
    private FoodFacadeLocal foodFacade;

    @EJB
    private HamburgerFacadeLocal hamburgerFacade;

    @WebMethod(operationName = "getAllHamburger")
    public List<Hamburger> getAllHamburger() {
        return this.hamburgerFacade.findAll();
    }

//    @WebMethod(operationName = "createHamburgerObject")
//    public Boolean createHamburgerObject(@WebParam(name = "hamburger") Food hamburger) {
////        System.out.println(hamburger.getFoodID());
//        foodFacade.create(hamburger);
////        Hamburger h = new Hamburger();
//        Food food = this.foodFacade.find(hamburger);
////        h.setFoodID(food.getId());
////        this.hamburgerFacade.create(h);
//        return true;
//    }
//
//    @WebMethod(operationName = "testMethod")
//    public Boolean testMethod() {
//        Hamburger hamburger = new Hamburger();
//        hamburger.setFoodID(6);
////        hamburger.getFood().setId(6);
//        this.hamburgerFacade.create(hamburger);
//        return true;
//    }
}
