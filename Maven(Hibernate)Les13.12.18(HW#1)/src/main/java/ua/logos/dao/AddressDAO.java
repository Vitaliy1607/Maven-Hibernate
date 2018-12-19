package ua.logos.dao;

import ua.logos.entity.AddressEntity;
import ua.logos.entity.AuthorEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class AddressDAO {
    private EntityManager em;

    public AddressDAO(EntityManager em) {
        this.em = em;
    }

    public void saveAddress(AddressEntity address){
        em.persist(address);
        System.out.println("Book with id: " + address.getId() + " is created");
    }

    public AddressEntity findAddressById(Long id){
        AddressEntity addressEntity = em.createQuery("select a from AddressEntity a where a.id = :bId and a.isDeleted = :bDel", AddressEntity.class)
                .setParameter("bId", id)
                .setParameter("bDel" , false).getSingleResult();
        return addressEntity;
    }

    public List<AddressEntity> findAllAddress(){
        List<AddressEntity> address = em.createQuery("select a from AddressEntity a where a.isDeleted = :bisDel", AddressEntity.class)
                .setParameter("bisDel", false).getResultList() ;
        return address;
    }

    public void deleteAddressById(Long id){
        em.createQuery("UPDATE AddressEntity a set a.isDeleted = :bDel where a.id = :bid")
                .setParameter("bDel" , true).setParameter("bid", id).executeUpdate();
        System.out.println("address with id " + id + " is deleted");
    }

    public AddressEntity updateAddress(AddressEntity addressEntity){
        em.merge(addressEntity);
        System.out.println("entity is update");
        return addressEntity;
    }
}
