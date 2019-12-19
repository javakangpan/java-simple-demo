 package Application;

import Interface.PersonFactory;
import bean.Person;

public class PersonFactoryApplication {
     public static void main(String[] args) {
         
        PersonFactory<Person> personFactory = new PersonFactory<Person>() {
            @Override
            public Person create(String firstName, String lastName) {
                // TODO Auto-generated method stub
                return new Person(firstName,lastName);
            }
        }; 
        
        Person person1 = personFactory.create("kang", "pan");
        System.out.println(person1);
        PersonFactory<Person> personFactory1 = Person::new;
        Person person = personFactory1.create("Peter", "Parker");
        System.out.println(person);
    }
     //Person::new 来获取Person类构造函数的引用
     //Java编译器会自动根据PersonFactory.create方法的参数类型来选择合适的构造函数。
  
}
