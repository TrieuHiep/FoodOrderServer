/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Food;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tatsuya
 */
@Stateless
public class FoodFacade extends AbstractFacade<Food> implements FoodFacadeLocal {

    @PersistenceContext(unitName = "FoodOrder-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FoodFacade() {
        super(Food.class);
    }

    @Override
    public List<Food> searchFoodByname(String query) {
        Query query1 = em.createQuery(
                "SELECT f FROM Food f WHERE f.productName LIKE :productName")
                .setParameter("productName", "%"+query+"%");
        return query1.getResultList();
    }
}
