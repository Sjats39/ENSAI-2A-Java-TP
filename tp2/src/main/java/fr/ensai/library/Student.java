package fr.ensai.library;

/**
 * Represents an Author.
 */
public class Student extends Person {

    // Attributes
    private String academicYear;
    private boolean isClassDelegate;

    /**
     * Constructs a new Author object.
     */
    public Student(String name, int age, String academicYear, boolean isClassDelegate) {
        super(name, age);
        this.academicYear = academicYear;
        this.isClassDelegate = isClassDelegate;
    }

    @Override
    public String toString() {
        return "Student " + this.name;
    }

}
