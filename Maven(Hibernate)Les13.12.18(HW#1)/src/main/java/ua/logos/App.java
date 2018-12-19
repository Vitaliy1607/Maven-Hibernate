package ua.logos;

import ua.logos.dao.AuthorDAO;
import ua.logos.dao.BookDAO;
import ua.logos.entity.AddressEntity;
import ua.logos.entity.AuthorEntity;
import ua.logos.entity.BookEntity;
import ua.logos.entity.TakenBook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();

        BookDAO bookDAO = new BookDAO(em);
        AuthorDAO authorDAO = new AuthorDAO(em);

        em.getTransaction().begin();

        BookEntity bookEntity = BookEntity.builder().bookName("Pisnya")
                .pubDate("2010-12-08").isbn("23geg23").build();
      // bookDAO.saveBook(bookEntity);


       // bookEntity = bookDAO.findBookById(1L);
     //   System.out.println(bookEntity);

        bookDAO.findAllBooks().forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }
}
