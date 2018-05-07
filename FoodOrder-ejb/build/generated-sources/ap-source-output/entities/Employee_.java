package entities;

import entities.Bill;
import entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T22:06:15")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Person> person;
    public static volatile ListAttribute<Employee, Bill> billList;
    public static volatile SingularAttribute<Employee, Integer> personID;
    public static volatile SingularAttribute<Employee, String> internalMail;

}