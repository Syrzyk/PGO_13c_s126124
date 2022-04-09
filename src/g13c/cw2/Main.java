package g13c.cw2;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        // Sample data of people (Name and surname validation)
        Person person1 = new Person("Panteleimon","Kulish",LocalDate.of(1819,8,7),new Address("Ukraine", "Kyiv", "Kopernyka St", 27,3), LocalDate.of(1897,2,14));
        Person person2 = new Person("Amanda","Seven",LocalDate.of(1988,3,9), new Address("Poland", "Warsaw", "Kopernika", 2,30));
        Person person3 = new Person("Marta","Seven",LocalDate.of(1990,5,4), new Address("USA", "New York", "Copernicus St", 50,1));

        // Sample data of books
        Book book1 = new Book( "Band of Brothers",Genre.Classic, Lang.English, LocalDate.of(1992,10,12), person1 );
        Book book2 = new Book( "Little Women",Genre.Fiction, Lang.English, LocalDate.of(1868,1,1), person1 );
        Book book3 = new Book( "Chorna Rada: The Black Council",Genre.Classic, Lang.Ukrainian, LocalDate.of(2013,9,29), person3 );

        // Publishing book by author
        person2.addBook(new Book("Dune", Genre.Adventure, Lang.Polish,LocalDate.of(2011,7,21)));
        person1.addBook(book3);

        // Adding author to the book
        book1.addAuthor(person1);

        // Borrow book
        book2.borrowBook(person1);
        //book3.borrowBook(person1); // (here added RuntimeException)
        //book2.borrowBook(person2); // (here added RuntimeException)
        System.out.println();
        System.out.println(book2.getBorrower());
        System.out.println(person1.getBorrowedBook());

        // Place back book
        book2.placeBack();
        book2.placeBack();
        book2.borrowBook(person2);
        System.out.println(book2.getBorrower());
        if (person1.hasBorrowBookLimit())
            System.out.println(person1 + " has a borrowed book:" + person1.getBorrowedBook());
        else
            System.out.println(person1 + " has no borrowed books");

        System.out.println();

        // Find by genre
        System.out.println(Book.findByGenre(Genre.Classic).toString());

    }
}