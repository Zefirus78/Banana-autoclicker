package hw_31;

import hw_31.utils.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private static SessionFactory sessionFactory;
    private static Library library;

    @BeforeAll
    public static void setup() throws HibernateException {
        library = new Library();
        sessionFactory = Hibernate.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS books (id SERIAL PRIMARY KEY, title VARCHAR(150), author VARCHAR(100))").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @BeforeEach
    public void beforeEachTest() throws HibernateException {
        library = new Library();
        library.addBook(new Book("The Silent Echoes", "Eleanor Graves"));
        library.addBook(new Book("The Last Oracle", "Cassian Vance"));
    }

    @AfterEach
    public void afterEachTest() throws HibernateException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("DELETE FROM books").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @AfterAll
    public static void cleanDatabase() throws HibernateException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("DROP TABLE books").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    @Test
    @Order(1)
    public void testAddBook() throws HibernateException {
        System.out.println("Current books in library: " + library.getBooks().size());
        Book book = new Book("Sherlock Holmes", "Arthur Conan Doyle");
        library.addBook(book);

        List<Book> books = library.getBooks();
        System.out.println("Current books in library: " + library.getBooks().size());
        assertTrue(books
                        .stream()
                        .anyMatch(b -> "Sherlock Holmes"
                        .equals(b.getTitle())), "Library should contain 'Sherlock Holmes'");
    }

    @Test
    @Order(2)
    public void testAddInvalidBook() throws HibernateException {
        System.out.println("Current books in library: " + library.getBooks().size());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                library.addBook(new Book(null, "Mark Twain")));
        assertEquals("Book title and author are required", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                library.addBook(new Book("Tom Sawyer", null)));
        assertEquals("Book title and author are required", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                library.addBook(new Book(null, null)));
        assertEquals("Book title and author are required", exception.getMessage());
    }

    @Test
    @Order(3)
    public void testRemoveBook() throws HibernateException {
        Book bookToRemove = library.getBooks().get(0);

        boolean removed = library.removeBook(bookToRemove);
        assertTrue(removed, "Book should be removed");

        System.out.println("Current books in library: " + library.getBooks().size());
        assertEquals(1, library.getBooks().size(), "Library should contain 1 book");
    }

    @Test
    @Order(4)
    void testRemoveBookWithInvalidId() throws HibernateException {
        Book invalidBook = new Book();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                library.removeBook(invalidBook));

        assertEquals("Book id is required", exception.getMessage());
    }

    @Test
    @Order(5)
    public void testGetBooks() throws HibernateException {
        List<Book> books = library.getBooks();
        System.out.println("Current books in library: " + library.getBooks().size());
        assertEquals(2, books.size(), "Library should contain 2 books");
    }

    @Test
    @Order(6)
    public void testGetBookCount() throws HibernateException {
        int books = library.getBookCount();
        System.out.println("Current books in library: " + library.getBooks().size());
        assertEquals(2, books, "Library should have 2 books");
    }

    @Test
    void testTimeout() throws HibernateException {
        assertTimeout(Duration.ofSeconds(2), () -> {
            List<Book> books = library.getBooks();
            assertNotNull(books);
            assertFalse(books.isEmpty());
        });
    }
}
