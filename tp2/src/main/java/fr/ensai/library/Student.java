package fr.ensai.library;

import java.util.Objects;

/**
 * Represents an Author.
 */
public class Student extends Person{

    // Attributes
    private String academicYear;
    private boolean isClassDelegate;

    /**
     * Constructs a new Author object.
     */
    public Author(String name, int age, String nationality) {
        super(name, age);
        this.academicYear = academicYear;
        this.isClassDelegate = isClassDelegate;
    }

    @Override
    public String toString() {
        return "Student " + name;
    }

}
