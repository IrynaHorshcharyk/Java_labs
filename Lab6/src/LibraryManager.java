import java.io.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class LibraryManager {

    public static Library fillLibrarywithBooks() {
        Library library = new Library();

        library.addBook(new Book("Harper Lee", "To Kill a Mockingbird", 1960));
        library.addBook(new Book("Fitzgerald", "The Great Gatsby", 1925));
        library.addBook(new Book("Gabriel García Márquez", "One Hundred Years of Solitude", 1967));
        library.addBook(new Book("Truman Capote", "In Cold Blood", 1965));
        library.addBook(new Book("Jean Rhys", "Wide Sargasso Sea", 1966));
        library.addBook(new Book("Aldous Huxley", "Brave New World", 1932));
        library.addBook(new Book("Dodie Smith", "I Capture The Castle", 1948));
        library.addBook(new Book("Fyodor Dostoevsky", "Crime and Punishment", 1866));
        library.addBook(new Book("Donna Tartt", "The Secret History", 1992));
        library.addBook(new Book("Jack London", "The Call of the Wild", 1903));

        return library;
    }

    public static List<Book> booksSorting(Library library){
        List<Book> sorted = library.getAllBooks();
        sorted.sort(Comparator.comparingInt(a -> a.published));
        return sorted;
    }

    public static void printPopularReaders(Library library){
        library.getAllSubscriptions().stream()
                .filter(x -> x.reader.takenBooks.size() > 2)
                .map(x -> x.email)
                .forEach(System.out::println);
    }

    public static void booksTakenInitialAuthor(Library library, String author){
        System.out.println(library.getAllSubscriptions().stream()
                .filter(x -> x.reader.takenBooks.stream().map(y -> y.author).collect(Collectors.toList()).contains(author))
                .distinct()
                .count());
    }

    public static void maxBooksTaken(Library library){
        System.out.println(library.getAllSubscriptions().stream()
                .map(x -> x.reader.takenBooks.size())
                .max(Integer::compareTo)
                .get());
    }

    public static void notificationsMailing(Library library){
        library.getAllSubscriptions().stream()
                .filter(x -> x.reader.takenBooks.size() >= 2)
                .forEach(x -> x.reader.takenBooks.forEach(y -> System.out.println("Attention, " + x.name + "" + x.surname +
                        ", you should return book " + y.name + " no later than " + Admin.getLatestByBook(library, y).plannedReturn)));

        library.getAllSubscriptions().stream()
                .filter(x -> x.reader.takenBooks.size() < 2)
                .forEach(x -> System.out.println(x.name + " " + x.surname + " you can take one of this books" + library.getAllBooks()));
    }

    public static void debtorsInforming(){

        for (int i = 5; i < 15; i+=3) {
            LocalDate date = LocalDate.of(2021, 11, i);
            System.out.println(date);
            Admin.records.stream().filter(x -> date.isAfter(x.plannedReturn) && (x.actualReturn == null || date.isBefore(x.actualReturn)))
                    .forEach(x -> System.out.println("Attention, " + x.subscription.name + " " + x.subscription.surname + " book " + x.book.name
                            + " is running late for " + (date.getDayOfMonth() - x.plannedReturn.getDayOfMonth()) + " days"));
        }
    }
}
