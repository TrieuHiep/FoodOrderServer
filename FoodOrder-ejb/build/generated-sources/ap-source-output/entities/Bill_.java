package entities;

import entities.Employee;
import entities.FoodOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T22:06:15")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, FoodOrder> orderID;
    public static volatile SingularAttribute<Bill, String> description;
    public static volatile SingularAttribute<Bill, Employee> employeePersonID;
    public static volatile SingularAttribute<Bill, Integer> id;

}