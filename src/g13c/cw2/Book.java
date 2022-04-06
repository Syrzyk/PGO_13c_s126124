package g13c.cw2;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Book {
    private static AtomicLong ID = new AtomicLong();
    private String name;
    private Genre genre;
    private Lang language;
    private LocalDate publishDate;
    private ArrayList<Person> authors=new ArrayList<>();
    //private int age=getAge();
    private int borrowCount=0;
    private boolean isAvailable=true;


    public void addAuthor(Person newAuthor){
        authors.add(newAuthor);
        if(!authors.contains(newAuthor)) { //if author is already assigned to the book
            newAuthor.addBook(this);
        }
    }
    //BorrowBook(Person)
    //PlaceBack()
    public Book(String name){
        setName(name);
    }
    public static String createID(){
        return String.valueOf(ID.getAndIncrement());
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

}
