/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Account;
import entities.Food;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tatsuya
 */
@Local
public interface MealBeanLocal {

    public abstract List<Food> getMealList(Account account);

    public abstract void addProduct(Account account, Food food);

    public abstract void removeProduct(Account account, int index);

    public abstract void removeProductList(Account account);
}
