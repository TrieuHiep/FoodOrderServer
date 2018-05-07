package entities;

import entities.Account;
import entities.Customer;
import entities.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-03T22:06:15")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Account> accountUsername;
    public static volatile SingularAttribute<Person, String> fullName;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, Employee> employee;
    public static volatile SingularAttribute<Person, Integer> age;
    public static volatile SingularAttribute<Person, Customer> customer;

}