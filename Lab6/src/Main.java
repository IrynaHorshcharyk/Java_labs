import java.io.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Library library = LibraryManager.fillLibrarywithBooks();

        LibrarySerialize.serialize(library);

        Subscription subscription1 = new Subscription("Daffern", "Sada", "sdaffern0@ebay.co.uk", new Reader());
        Subscription subscription2 = new Subscription("Goding", "Sophi", "sgoding1@dailymotion.com", new Reader());
        Subscription subscription3 = new Subscription("Ricciardo", "Madison", "mricciardo2@businesswire.com", new Reader());

        library.addSubscription(subscription1);
        library.addSubscription(subscription2);
        library.addSubscription(subscription3);


        System.out.println("\n1) Sort books in ascending order\n");

        List<Book> sorted = LibraryManager.booksSorting(library);
        sorted.forEach(System.out::println);

        Admin.registerTake(library, 1, library.allBooks.get(0), subscription1, LocalDate.of(2021, 10, 11), LocalDate.of(2021, 11, 1));
        Admin.registerTake(library, 2, library.allBooks.get(0), subscription1, LocalDate.of(2021, 10, 12), LocalDate.of(2021, 11, 3));
        Admin.registerTake(library, 3, library.allBooks.get(0), subscription1, LocalDate.of(2021, 10, 13), LocalDate.of(2021, 11, 4));
        Admin.registerTake(library, 4, library.allBooks.get(0), subscription2, LocalDate.of(2021, 10, 14), LocalDate.of(2021, 11, 5));
        Admin.registerTake(library, 5, library.allBooks.get(0), subscription2, LocalDate.of(2021, 10, 15), LocalDate.of(2021, 11, 6));
        Admin.registerTake(library, 6, library.allBooks.get(0), subscription2, LocalDate.of(2021, 10, 16), LocalDate.of(2021, 11, 10));
        Admin.registerTake(library, 7, library.allBooks.get(0), subscription3, LocalDate.of(2021, 10, 17), LocalDate.of(2021, 11, 15));

        System.out.println("\n2) Emails readers whose took more than 2 books\n");

        LibraryManager.printPopularReaders(library);

        System.out.println("\n3) Count books with initial author which readers took\n");

        LibraryManager.booksTakenInitialAuthor(library, "Harper Lee");

        System.out.println("\n4) Max books count which took one reader\n");

        LibraryManager.maxBooksTaken(library);

        System.out.println("\n5) Notifications for every type readers\n");

        LibraryManager.notificationsMailing(library);

        System.out.println("\n6) Notification debtors for returning taken books\n");

        Admin.registerReturn(library, subscription1, subscription1.reader.takenBooks.get(0), LocalDate.of(2021, 11, 3));
        Admin.registerReturn(library, subscription2, subscription2.reader.takenBooks.get(0), LocalDate.of(2021, 11, 7));

        LibraryManager.debtorsInforming();
    }
}
