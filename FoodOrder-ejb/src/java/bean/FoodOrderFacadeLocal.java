/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.FoodOrder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tatsuya
 */
@Local
public interface FoodOrderFacadeLocal {

    void create(FoodOrder foodOrder);

    void edit(FoodOrder foodOrder);

    void remove(FoodOrder foodOrder);

    FoodOrder find(Object id);

    List<FoodOrder> findAll();

    List<FoodOrder> findRange(int[] range);

    int count();
    
}
