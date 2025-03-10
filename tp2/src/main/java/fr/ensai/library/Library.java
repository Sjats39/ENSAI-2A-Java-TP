package fr.ensai.library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
/**
 * Represents a library.
 */

public class Library{

    // Attributes
    private String name;
    private List<Item> items;
    private List<Loan> activeLoans;
    private List<Loan> completedLoans;

    
    /**
     * Constructs a new library object.
     */
    public Library(String name,
                   List<Item> items,
                   List<Loan> activeLoans,
                   List<Loan> completedLoans) {

        this.name = name;
        this.items = items;
        this.activeLoans = activeLoans;
        this.completedLoans = completedLoans;
    }

    /**
     * Adds a new book to the library.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Prints all books in the library.
     */
    public void displayItems() {
        if items.isEmpty(){
            System.out.println("The library is empty.");
        }
        else{
            for(Item item : items){
                System.out.println(item.toString());
            }
        }
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addItem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public Loan findActiveLoanForItem(Item item){
        // Look if the item is present in active loans
        // Run unit tests
        for(Loan loan : activeLoans){
            if(loan.item == item){
                return loan;
            }
        }
        return null;
    }

    

    public ArrayList<Book> getBooksByAuthor(Author author){
        List<Book>  res = List<Book>();
        for(Item item : items){
            if(item instanceof Book){ 
                if(item.author == author){
                    res.add(item);
                }
            }
        }
        return res;
    }


    public boolean loanItem(Item item, Student student){
        // Check if the item is available
        // Create a Loan and add it to activeLoans
        if(this.findActiveLoanForItem(item)== null){
            Loan loan = new Loan(student, item, LocalDate.now(), null);
            activeLoans.add(loan);
            return true;
        }
        return false;
    }

    

    public boolean renderItem(Item item){
        // Find the Loan if exists
        //Add a return date
        // Move an item from activeLoans to completedLoans
        
        int index = this.findActiveLoanForItem(item)
        
        if(index == null){
            return false;
        }

        Loan loan = activeLoans.remove(index)
        loan.returnDate = LocalDate.now();
        completedLoans.add(loan);
        
    }

    

    public void displayActiveLoans(){
        for(Loan loan :activeLoans){
            System.out.println(loan.toString())
        }


    }
}