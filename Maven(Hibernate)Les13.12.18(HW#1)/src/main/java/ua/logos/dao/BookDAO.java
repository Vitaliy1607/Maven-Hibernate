package ua.logos.dao;

import ua.logos.entity.BookEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDAO {

    private EntityManager em;

    public BookDAO(EntityManager em) {
        this.em = em;
    }

    public void saveBook(BookEntity book){
        em.persist(book);
        System.out.println("Book with id: " + book.getId() + " is created");
    }

    public BookEntity findBookById(Long id){
        BookEntity bookEntity = em.createQuery("select b from BookEntity b where b.id = :bId and b.isDeleted = :bDel", BookEntity.class)
                .setParameter("bId", id)
                .setParameter("bDel" , false).getSingleResult();
        return bookEntity;
    }

    public List<BookEntity> findAllBooks(){
        List<BookEntity> books = em.createQuery("select b from BookEntity b where b.isDeleted = :bisDel", BookEntity.class)
                .setParameter("bisDel", false).getResultList() ;
        return books;
    }

    public void deleteBookById(Long id){
        em.createQuery("UPDATE BookEntity b set b.isDeleted = :bDel where b.id = :bid")
                .setParameter("bDel" , true).setParameter("bid", id).executeUpdate();
        System.out.println("Teacher with id " + id + " is deleted");
    }

    public BookEntity updateBook(BookEntity bookEntity){
        em.merge(bookEntity);
        System.out.println("entity is update");
        return bookEntity;
    }
}
