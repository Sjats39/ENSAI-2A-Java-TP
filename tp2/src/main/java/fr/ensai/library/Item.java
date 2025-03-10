package fr.ensai.library;

/**
 * Represents a item.
 */
public abstract class Item {

    // Attributes
    private String title;
    private int year;
    private int pageCount;

    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }

    public String toString() {
        return "Item " + title;
    }
}
