package Practical12;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This is an example of using lists
 *
 * @author Ilias Tachmazidis
 * @version September 2025
 */
public class LinkedListExample {

    public static void main(String[] args) {

        // Create a LinkedList
        List<Person> myLinkedList = new LinkedList();

        // Add elements to LinkedList
        myLinkedList.add(new Person("John", "John", 30));
        myLinkedList.add(new Person("Jane", "Jane", 25));
        myLinkedList.add(new Person("Jack", "Jack", 40));

        // Loop through the LinkedList
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println("LinkedList get " + i + ": " + myLinkedList.get(i));
        }

        // Search for specific surname
        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i).getSurname().equals("Jane")) {
                System.out.println("myLinkedList contains surname \"Jane\" at index " + i + ": " + myLinkedList.get(i));
            }
        }

        // Check if empty
        System.out.println("LinkedList isEmpty(): " + myLinkedList.isEmpty());

        // Remove specific surname
        for (int i = 0; i < myLinkedList.size(); i++) {
            if (myLinkedList.get(i).getSurname().equals("Jane")) {
                 myLinkedList.remove(i);
                 break;
            }
        }

        // Loop through the LinkedList
        for (Person person: myLinkedList) {
            System.out.println("LinkedList person: " + person);
        }

        // Remove specific object
        myLinkedList.remove(new Person("Jack", "Jack", 40));

        // Loop through the LinkedList
        for (Person person: myLinkedList) {
            System.out.println("LinkedList person: " + person);
        }

        // Remove element at last position
        myLinkedList.remove(myLinkedList.size()-1);

        // Check if empty
        System.out.println("LinkedList isEmpty(): " + myLinkedList.isEmpty());

        // Sorting a list
        myLinkedList = new LinkedList();
        myLinkedList.add(new Person("John", "John", 30));
        myLinkedList.add(new Person("John", "John", 20));
        myLinkedList.add(new Person("Jack", "John", 40));
        myLinkedList.add(new Person("Jane", "Jane", 25));

        System.out.println("\nBefore sorting:");
        for (Person person: myLinkedList) {
            System.out.println("LinkedList person: " + person);
        }

        Collections.sort(myLinkedList);

        System.out.println("\nAfter sorting:");
        for (Person person: myLinkedList) {
            System.out.println("LinkedList person: " + person);
        }
    }
}
