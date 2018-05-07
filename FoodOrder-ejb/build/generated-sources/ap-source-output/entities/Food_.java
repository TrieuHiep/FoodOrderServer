package entities;

import entities.Chicken;
import entities.Hamburger;
import entities.Meal;
import entities.Rice;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T22:06:15")
@StaticMetamodel(Food.class)
public class Food_ { 

    public static volatile ListAttribute<Food, Meal> mealList;
    public static volatile SingularAttribute<Food, Chicken> chicken;
    public static volatile SingularAttribute<Food, Integer> quantity;
    public static volatile SingularAttribute<Food, Long> price;
    public static volatile SingularAttribute<Food, String> imageURL;
    public static volatile SingularAttribute<Food, Integer> id;
    public static volatile SingularAttribute<Food, Rice> rice;
    public static volatile SingularAttribute<Food, String> productName;
    public static volatile SingularAttribute<Food, Hamburger> hamburger;

}