package ua.logos.dao;

import ua.logos.entity.AuthorEntity;
import ua.logos.entity.UserEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void saveUser(UserEntity user){
        em.persist(user);
        System.out.println("User with id: " + user.getId() + " is created");
    }

    public UserEntity findUserById(Long id){
        UserEntity userEntity = em.createQuery("select u from UserEntity u where u.id = :uId and u.isDeleted = :uDel", UserEntity.class)
                .setParameter("uId", id)
                .setParameter("uDel" , false).getSingleResult();
        return userEntity;
    }

    public List<UserEntity> findAllUsers(){
        List<UserEntity> users = em.createQuery("select u from UserEntity u where u.isDeleted = :uisDel", UserEntity.class)
                .setParameter("uisDel", false).getResultList() ;
        return users;
    }

    public void deleteUserById(Long id){
        em.createQuery("UPDATE UserEntity u set u.isDeleted = :uDel where u.id = :uid")
                .setParameter("uDel" , true).setParameter("uid", id).executeUpdate();
        System.out.println("User with id " + id + " is deleted");
    }

    public UserEntity updateBook(UserEntity userEntity){
        em.merge(userEntity);
        System.out.println("entity is update");
        return userEntity;
    }
}
