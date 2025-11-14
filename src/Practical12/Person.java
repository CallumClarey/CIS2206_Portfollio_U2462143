package Practical12;

import java.util.Objects;

/**
 * Implements a domain class representing a person
 *
 * @author Ilias Tachmazidis
 * @version September 2025
 */
public class Person implements Comparable<Person> {
    String name;
    String surname;
    Integer age;

    /**
     * This constructor initialises the fields of the class
     *
     * @param name The first name of the person
     * @param surname The last name of the person
     * @param age The age of the person
     */
    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    /**
     * This method creates a String representation of
     * the object in a human friendly fashion.
     *
     * @return A String representation of the person
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                "}";
    }

    /**
     * This is a method implementation for
     * the Comparable interface
     *
     * @param p A person to compare to
     * @return Total ordering as a result age
     */
    @Override
    public int compareTo(Person p) {
        return this.age.compareTo(p.age); // ascending order
        //return -this.age.compareTo(p.age); // descending order
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
