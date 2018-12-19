package ua.logos.dao;

import ua.logos.entity.AuthorEntity;
import ua.logos.entity.BookEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorDAO {

    private EntityManager em;

    public AuthorDAO(EntityManager em) {
        this.em = em;
    }

    public void saveAuthor(AuthorEntity author){
        em.persist(author);
        System.out.println("Book with id: " + author.getId() + " is created");
    }

    public AuthorEntity findAuthorsById(Long id){
        AuthorEntity authorEntity = em.createQuery("select a from AuthorEntity a where a.id = :bId and a.isDeleted = :bDel", AuthorEntity.class)
                .setParameter("bId", id)
                .setParameter("bDel" , false).getSingleResult();
        return authorEntity;
    }

    public List<AuthorEntity> findAllAuthors(){
        List<AuthorEntity> authors = em.createQuery("select a from AuthorEntity a where a.isDeleted = :aisDel", AuthorEntity.class)
                .setParameter("aisDel", false).getResultList() ;
        return authors;
    }

    public void deleteAuthorById(Long id){
        em.createQuery("UPDATE AuthorEntity a set a.isDeleted = :aDel where a.id = :aid")
                .setParameter("aDel" , true).setParameter("aid", id).executeUpdate();
        System.out.println("Author with id " + id + " is deleted");
    }

    public AuthorEntity updateAuthor(AuthorEntity authorEntity){
        em.merge(authorEntity);
        System.out.println("entity is update");
        return authorEntity;
    }
}
