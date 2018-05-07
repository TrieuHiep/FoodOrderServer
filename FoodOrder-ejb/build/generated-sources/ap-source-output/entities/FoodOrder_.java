package entities;

import entities.Bill;
import entities.Meal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T22:06:15")
@StaticMetamodel(FoodOrder.class)
public class FoodOrder_ { 

    public static volatile SingularAttribute<FoodOrder, String> address;
    public static volatile SingularAttribute<FoodOrder, Meal> mealID;
    public static volatile ListAttribute<FoodOrder, Bill> billList;
    public static volatile SingularAttribute<FoodOrder, Integer> id;
    public static volatile SingularAttribute<FoodOrder, String> creattionDate;
    public static volatile SingularAttribute<FoodOrder, String> paymentType;
    public static volatile SingularAttribute<FoodOrder, String> status;

}