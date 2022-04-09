package g13c.cw2;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Book {
    private final static Set<Book> extent = new HashSet<>();
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private final long ID = NEXT_ID.getAndIncrement();
    private String name;
    private Genre genre;
    private Lang language;
    private LocalDate publishDate;
    private final ArrayList<Person> authors = new ArrayList<>();
    //private int age = getAge();
    private int borrowCount = 0;
    private boolean isAvailable = true;
    private Person borrower;


    public Book(String name, Genre genre, Lang language, LocalDate publishDate){
        extent.add(this);
        setName(name);
        setGenre(genre);
        setLanguage(language);
        setPublishDate(publishDate);

    }
    public Book(String name, Genre genre, Lang language, LocalDate publishDate, Person author){
        this(name, genre, language, publishDate);
        this.addAuthor(author);
    }

    public void addAuthor(Person newAuthor){
        authors.add(newAuthor);
        if(!authors.contains(newAuthor)) { //if author is already assigned to the book
            newAuthor.addBook(this);
        }
    }
    public void borrowBook(Person person)
    {
        if (isAvailable && !person.hasBorrowBookLimit()){
            isAvailable = false;
            borrower = person;
            borrowCount++;
            borrower.setBorrowedBook(this);
            borrower.setBorrowBookLimit(true);
            System.out.println("Book " + name + " has been borrowed by " + borrower.getName() + " " + borrower.getSurname() + ".");
        } else
            if (person.hasBorrowBookLimit()){
                throw new RuntimeException(person.getName() + " " + person.getSurname() + " cannot borrow more books. Limit of borrowed books has been reached.");
                //System.out.println(person.getName() +" " + person.getSurname()+" cannot borrow more books. Limit of borrowed books has been reached.");
            } else
                throw new RuntimeException("Book "+ name + " is not available.");
                //System.out.println("Book "+ name + " is not available.");

    }

    public void placeBack()
    {
        if (!isAvailable) {
            System.out.println("Book " + name + " borrowed by " + borrower.getName() + "has been placed back correctly.");
            borrower.setBorrowedBook(null);
            borrower.setBorrowBookLimit(false);
            borrower = null;
            isAvailable = true;
        } else
            System.out.println("Book cannot be placed back. It is not borrowed by anybody.");
    }







    //PlaceBack()


    public Book(String name){
        setName(name);
    }

    public int getAge()
    {
        return Period.between(publishDate,LocalDate.now()).getYears();
    }

//----------------- Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Lang getLanguage() {
        return language;
    }

    public void setLanguage(Lang language) {
        this.language = language;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public long getID() {
        return ID;
    }

    public ArrayList<Person> getAuthors() {
        return authors;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
    }

    // Search by genre
    public static Set<Book> getExtent() {
        return Collections.unmodifiableSet(extent);
    }
    public static List<Book> findByGenre(Genre genreName)
    {
        return extent.stream().filter(v -> v.genre.equals(genreName)).collect(Collectors.toList());
    }

    @Override
    public String toString() {

        return "Book " +
                "ID: "+ ID +
                ", " + name +
                ", genre:" + genre +
                ", language: " + language +
                ", publishDate: " + publishDate +
                ", authors: " + authors;
                // +
                //", BookAge=" + getAge() +
                //System.lineSeparator();
    }
}
