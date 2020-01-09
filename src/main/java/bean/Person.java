 package bean;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Person {
     String firstName;
     String lastName;

     public Person() {}

     public Person(String firstName, String lastName) {
         this.firstName = firstName;
         this.lastName = lastName;
     }
     @Override
    public String toString() {
         return "firstName:" + firstName + ";lastName:" + lastName;
    }
     
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public static String getName(Person p) {
        return Optional.ofNullable(p).map(person -> p.firstName).orElse("UnKnown");
    }
    
    public Person lastName(String lastName) {
        setLastName(lastName);
        return this;
    }
    
    public Person firstName(String firstName) {
        setFirstName(firstName);
        return this;
    } 
    
    public static void main(String[] args) {
        Person person = new Person();
        person.firstName("kangpan").lastName("liting");
        System.out.println(getName(person));
    }
}
