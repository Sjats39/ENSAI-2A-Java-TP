package fr.ensai.library;
package java.time;

public class Loan {
    // Attributes
    private Student student;
    private Item item;
    private Date startDate;
    private Date returnDate;

    public Loan(Student student, Item item, Date startDate, Date returnDate) {
        this.student = student;
        this.item = item;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public Date setReturnDate(Date new_return_date) {
        this.returnDate = new_return_date;
    }

    public String toString() {
        return "Item" + item + "borrowed by" + student + ".";
    }

}