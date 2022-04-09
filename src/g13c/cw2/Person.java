package g13c.cw2;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Person {
    private final static Set<Person> extent = new HashSet<>();
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath; // to calculate age, if author is dead
    private Address address; // relation to Address class
    private ArrayList<Book> books = new ArrayList<>(); // list of books assigned to the person
    private boolean author=false; // until person is assigned to the first book
    private Book borrowedBook; // Book object which is in possess. If null, nothing is borrowed
    private boolean borrowBookLimit=false;

    //---------- Methods ---------- //
    public Person(String name, String surname, LocalDate dateOfBirth, Address address){
        extent.add(this);
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
    }
    public Person(String name, String surname, LocalDate dateOfBirth, Address address, LocalDate dateOfDeath ){
        this(name, surname, dateOfBirth, address);

        setAddress(address);
        setDateOfDeath(dateOfDeath);
    }

    public void addBook(Book newBook){
        if (!books.contains(newBook)){ // if book is already assigned to person(author)
            books.add(newBook);
            newBook.addAuthor(this);
            author=true;
        }
    }

    public static Set<Person> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    //---------- Getters & Setters ---------- //
        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name.matches("[a-zA-Z]+")) { // only letters
                this.name = name;
            } else{
                System.out.println("Wprowadzone imię jest nieprawidłowe. Powinno składać się tylko z liter. Wprowadź ponownie: ");
                Scanner scan = new Scanner(System.in);
                this.name= scan.next();
            }


        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            if (surname.matches("[a-zA-Z]+")) { // only letters
                this.surname = name;
            } else{
                System.out.println("Wprowadzone nazwisko jest nieprawidłowe. Powinno składać się tylko z liter. Wprowadź ponownie: ");
                Scanner scan = new Scanner(System.in);
                this.surname= scan.next();
            }
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public int getAge()
        { if (dateOfDeath == null ){
            return Period.between(dateOfBirth,LocalDate.now()).getYears();
                    }  else return Period.between(dateOfBirth,dateOfDeath).getYears();}

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean isAuthor() {
        return author;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    @Override
    public String toString() {
        return   name +
                " " + surname +
                //", author:" + author +
                ", age: " + getAge() + System.lineSeparator();
    }

    public boolean isBorrowBookLimit() {
        return borrowBookLimit;
    }

    public void setBorrowBookLimit(boolean borrowBookLimit) {
        this.borrowBookLimit = borrowBookLimit;
    }
}
