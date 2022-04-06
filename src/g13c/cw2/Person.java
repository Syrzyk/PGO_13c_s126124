package g13c.cw2;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath; // to calculate age, if author is dead
    private Address address; // relation to Address class
    private ArrayList<Book> books = new ArrayList<>(); // list of books assigned to the person
    private boolean author=false; // until person is assigned to the first book
    private Book borrowedBook; // Book object which is in possess. If null, nothing is borrowed

    //---------- Methods ---------- //
    public Person(String name, String surname, LocalDate dateOfBirth){
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
    }
    public Person(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfDeath, Address address ){
        this(name, surname, dateOfBirth);
        setDateOfDeath(dateOfDeath);
        setAddress(address);
    }

    public void addBook(Book newBook){
        if (!books.contains(newBook)){ // if book is already assigned to person(author)
            books.add(newBook);
            newBook.addAuthor(this);
            author=true;
        }
    }

    //---------- Getters & Setters ---------- //
        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name.matches("[a-zA-Z]+")) { // only letters
                this.name = name;
            } else{
                System.out.println("Use only letters");
            }


        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
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
        {
            return Period.between(dateOfBirth,LocalDate.now()).getYears();
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void printBooksList(ArrayList list){
        list.forEach(name ->{
            System.out.println(list);
        });
    }

    public boolean isAuthor() {
        return author;
    }
}
