/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Rice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tatsuya
 */
@Stateless
public class RiceFacade extends AbstractFacade<Rice> implements RiceFacadeLocal {

    @PersistenceContext(unitName = "FoodOrder-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RiceFacade() {
        super(Rice.class);
    }
    
}
