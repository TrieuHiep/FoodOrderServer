/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Account;
import entities.Meal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tatsuya
 */
@Local
public interface MealFacadeLocal {

    void create(Meal meal);

    void edit(Meal meal);

    void remove(Meal meal);

    Meal find(Object id);

    List<Meal> findAll();

    List<Meal> findRange(int[] range);

    int count();
    
    public abstract List<Meal> getMealList(Account account);
}
