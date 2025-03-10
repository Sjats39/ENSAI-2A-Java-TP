package fr.ensai.library;

/**
 * Represents a book.
 */
public class Magazine extends Item{

    // Attributes
    private Integer issn;
    private Integer issueNumber;

    public Magazine(String title, int year, int pageCount, int issn, int issueNumber){
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber
    }
}
