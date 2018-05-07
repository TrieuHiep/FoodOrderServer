/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Chicken;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tatsuya
 */
@Local
public interface ChickenFacadeLocal {

    void create(Chicken chicken);

    void edit(Chicken chicken);

    void remove(Chicken chicken);

    Chicken find(Object id);

    List<Chicken> findAll();

    List<Chicken> findRange(int[] range);

    int count();
    
}
