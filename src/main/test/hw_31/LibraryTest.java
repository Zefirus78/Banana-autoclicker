package hw_31;

import hw_31.utils.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private static SessionFactory sessionFactory;
    private static Library library;
    private Book tempBook1;
    private Book tempBook2;


    @BeforeAll
    public static void setup() {
        library = new Library();
        sessionFactory = Hibernate.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS books (id SERIAL PRIMARY KEY, title VARCHAR(150), author VARCHAR(100))").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @BeforeEach
    public void beforeEachTest() {
        tempBook1 = library.addBook(new Book("The Silent Echoes", "Eleanor Graves"));
        tempBook2 = library.addBook(new Book("Chronicles of the Starborn", "Zane Holloway"));
    }

    @AfterEach
    public void afterEachTest() {
        library.removeBook(tempBook1);
        library.removeBook(tempBook2);
    }

    @AfterAll
    public static void cleanDatabase() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Book").executeUpdate(); // Clear the table
            session.getTransaction().commit();
        }
        sessionFactory.close();
    }

    @Test
    @Order(1)
    public void testAddBook() {
        Book book = new Book("Sherlock Holmes", "Arthur Conan Doyle");
        library.addBook(book);

        List<Book> books = library.getBooks();
        assertTrue(books
                        .stream()
                        .anyMatch(b -> "Sherlock Holmes"
                        .equals(b.getTitle())), "Library should contain 'Sherlock Holmes'");
    }

    @Test
    @Order(2)
    public void testAddInvalidBook() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book(null, "Mark Twain"));
        });
        assertEquals("Book title and author are required", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book("Tom Sawyer", null));
        });
        assertEquals("Book title and author are required", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book(null, null));
        });
        assertEquals("Book title and author are required", exception.getMessage());
    }

    @Test
    @Order(3)
    public void testRemoveBook() {
        Long id = library.getBooks().get(0).getId();

        Book bookToRemove = new Book();
        bookToRemove.setId(id);

        boolean removed = library.removeBook(bookToRemove);
        assertTrue(removed, "Book should be removed");

        assertEquals(2, library.getBooks().size(), "Library should contain 2 books");
    }

    @Test
    @Order(3)
    public void testGetBooks() {
        List<Book> books = library.getBooks();
        assertEquals(2, books.size(), "Library should contain 2 books");
    }

    @Test
    @Order(4)
    public void testGetBookCount() {
        assertEquals(2, library.getBookCount(), "Library should have 2 books");
    }
}
