import java.util.*;
import java.util.stream.Collectors;

public class Library {
    public interface Searchable{
        boolean matchesKeyWord(String keyWord);
    }
    static class Book implements Searchable{
        String isbn;
        String title;
        String author;
        int borrowCount;
        public Book(String isbn, String title, String author, int borrowCount){
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.borrowCount = borrowCount;
        }
        @Override
        public boolean matchesKeyWord(String keyWord) {
            return title.toLowerCase().contains(keyWord.toLowerCase()) ||
                    author.toLowerCase().contains(keyWord.toLowerCase());
        }
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Book b = (Book) obj;

            return isbn.equals(b.isbn);
        }
        @Override
        public String toString() {

            return title + " (" + borrowCount + ")";
        }
    }
    public static class LibraryCatalog{
        Set<Book> books = new HashSet<Book>();
        public void addBook(Book book){
            books.add(book);
        }
        public List<Book> getBooks(String keyword){
            return books.stream().filter(b -> b.matchesKeyWord(keyword)).sorted(Comparator.comparingInt((Book b) -> b.borrowCount).reversed())
                    .collect(Collectors.toList());
        }
        public Optional<Book> getMostBorrowedBook() {

            return books.stream()
                    .max(Comparator.comparingInt(b -> b.borrowCount));
        }
    }

    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        // Adding books
        library.addBook(new Book("978-0134685991",
                "Effective Java", "Joshua Bloch", 150));

        library.addBook(new Book("978-0134685991",
                "Effective Java 3rd Ed", "Joshua Bloch", 200));

        library.addBook(new Book("978-0596009205",
                "Head First Java", "Kathy Sierra", 320));

        // Search books
        System.out.println("Search Results: "
                + library.getBooks("java"));

        // Most borrowed book
        library.getMostBorrowedBook()
                .ifPresent(b -> System.out.println("Most Borrowed: " + b.title));
    }
}