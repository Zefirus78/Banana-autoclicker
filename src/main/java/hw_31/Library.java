package hw_31;

import hw_31.utils.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public void addBook(Book book) throws HibernateException {
        if (book.getTitle() == null || book.getAuthor() == null) {
            throw new IllegalArgumentException("Book title and author are required");
        }

        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            String hql = "INSERT INTO Book (title, author) " +
                    "VALUES (:title, :author)";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("title", book.getTitle());
            query.setParameter("author", book.getAuthor());
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public boolean removeBook(Book book) throws HibernateException {
        if (book.getId() == null) {
            throw new IllegalArgumentException("Book id is required");
        }

        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            String hql = "DELETE FROM Book WHERE id = :id";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("id", book.getId());
            query.executeUpdate();

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public List<Book> getBooks() throws HibernateException {

        List<Book> books = new ArrayList<>();
        try (Session session = Hibernate.getSessionFactory().openSession()) {

            Transaction transaction;
            transaction = session.beginTransaction();
            books = session.createQuery("FROM Book", Book.class).list();

            transaction.commit();
            return books;
        } catch (Exception e) {
            return books;
        }
    }

    public int getBookCount() throws HibernateException {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            Long result = session.createQuery("SELECT COUNT(*) FROM Book", Long.class)
                    .uniqueResult();
            return result != null ? result.intValue() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
