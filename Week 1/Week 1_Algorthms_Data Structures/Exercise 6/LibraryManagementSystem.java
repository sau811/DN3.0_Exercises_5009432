import java.util.Arrays;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {

    
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Book[] books = {
            new Book(1, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Moby Dick", "Herman Melville"),
            new Book(5, "Pride and Prejudice", "Jane Austen")
        };

        
        Arrays.sort(books, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));

        System.out.println("Library Management System");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        Book foundBook;
        long startTime, endTime;

        switch (option) {
            case 1:
                startTime = System.nanoTime();
                foundBook = linearSearch(books, title);
                endTime = System.nanoTime();
                if (foundBook != null) {
                    System.out.println("Book found: " + foundBook);
                } else {
                    System.out.println("Book not found.");
                }
                System.out.println("Linear Search Time (ns): " + (endTime - startTime));
                break;

            case 2:
                startTime = System.nanoTime();
                foundBook = binarySearch(books, title);
                endTime = System.nanoTime();
                if (foundBook != null) {
                    System.out.println("Book found: " + foundBook);
                } else {
                    System.out.println("Book not found.");
                }
                System.out.println("Binary Search Time (ns): " + (endTime - startTime));
                break;

            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
