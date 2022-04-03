package g13c.cw2;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Book {
    private static AtomicLong ID = new AtomicLong();
    private String name;
    private Genre genre;
    private Lang language;
    private LocalDate publishDate;
    // Age
    // borrowCount:int
    // isAvailable:bool

    //BorrowBook(Person)
    //PlaceBack()

    public static String createID(){
        return String.valueOf(ID.getAndIncrement());
    }
}
