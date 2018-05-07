/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Chicken;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tatsuya
 */
@Stateless
public class ChickenFacade extends AbstractFacade<Chicken> implements ChickenFacadeLocal {

    @PersistenceContext(unitName = "FoodOrder-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChickenFacade() {
        super(Chicken.class);
    }
    
}
