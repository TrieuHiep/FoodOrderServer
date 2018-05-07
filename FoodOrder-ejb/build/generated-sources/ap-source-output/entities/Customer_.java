package entities;

import entities.Meal;
import entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T22:06:15")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile ListAttribute<Customer, Meal> mealList;
    public static volatile SingularAttribute<Customer, Person> person;
    public static volatile SingularAttribute<Customer, Integer> personID;
    public static volatile SingularAttribute<Customer, String> email;

}