package fr.ensai.library;

import java.util.Objects;

/**
 * Represents an Person.
 */
public class Person {

    // Attributes
    private String name;
    private int age;

    /**
     * Constructs a new Person object.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

   
    public String toString() {
        return "Person " + name;
    }

}
