/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Account;
import entities.Meal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tatsuya
 */
@Stateless
public class MealFacade extends AbstractFacade<Meal> implements MealFacadeLocal {

    @PersistenceContext(unitName = "FoodOrder-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MealFacade() {
        super(Meal.class);
    }

    @Override
    public List<Meal> getMealList(Account account) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
