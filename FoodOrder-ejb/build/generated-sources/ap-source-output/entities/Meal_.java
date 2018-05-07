package entities;

import entities.Customer;
import entities.Food;
import entities.FoodOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T22:06:15")
@StaticMetamodel(Meal.class)
public class Meal_ { 

    public static volatile SingularAttribute<Meal, Customer> customerPersonID;
    public static volatile ListAttribute<Meal, FoodOrder> foodOrderList;
    public static volatile SingularAttribute<Meal, Integer> quantity;
    public static volatile SingularAttribute<Meal, Food> foodID;
    public static volatile SingularAttribute<Meal, Integer> id;

}