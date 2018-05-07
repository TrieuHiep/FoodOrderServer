/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Account;
import entities.Customer;
import entities.Food;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 *
 * @author tatsuya
 */
@Stateful
public class MealBean implements MealBeanLocal {

//    private List<Food> foodList;
    private Map<Account, List<Food>> foodMap;

    @PostConstruct
    public void init() {
//        this.foodList = new ArrayList<>();
        this.foodMap = new HashMap<>();
    }

    @Override
    public List<Food> getMealList(Account account) {
        System.out.println("getting foodlist for account "
                + account.getUsername());
        return this.foodMap.get(account);
    }

    @Override
    public void addProduct(Account account, Food food) {

        List<Food> foodList = this.foodMap.getOrDefault(account, new ArrayList<>());
        for (Food h : foodList) {
            if (h.getId().equals(food.getId())) {
                h.setQuantity(h.getQuantity() + 1);
                return;
            }
        }
        food.setQuantity(1);
        foodList.add(food);
        System.out.println("Cart Status: ");
        for (Food foodItem : foodList) {
            System.out.println(foodItem.getProductName()
                    + " - " + foodItem.getQuantity());
        }
        foodMap.put(account, foodList);
    }

    @Override
    public void removeProduct(Account account, int index) {
        this.foodMap.get(account).remove(index);
    }

    @Override
    public void removeProductList(Account account) {
        this.foodMap.replace(account, new ArrayList<>());
    }

}
