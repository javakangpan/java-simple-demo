 package Interface;

import bean.Person;

@FunctionalInterface
 public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
