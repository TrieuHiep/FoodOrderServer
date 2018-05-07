/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Hamburger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tatsuya
 */
@Local
public interface HamburgerFacadeLocal {

    void create(Hamburger hamburger);

    void edit(Hamburger hamburger);

    void remove(Hamburger hamburger);

    Hamburger find(Object id);

    List<Hamburger> findAll();

    List<Hamburger> findRange(int[] range);

    int count();
    
}
