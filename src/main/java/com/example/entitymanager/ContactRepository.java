package com.example.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {

//    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Contact contact){
        entityManager.persist(contact);
    }

    public List<Contact> findAll(){
        String retrive ="SELECT c FROM Contact c";
        TypedQuery<Contact> query = entityManager.createQuery(retrive, Contact.class);
        return query.getResultList();
    }

    public Contact findById(Integer contactID){
        return entityManager.find(Contact.class,contactID);
    }

    @Transactional
    public Contact update(Contact contact){
        return entityManager.merge(contact);
    }

    @Transactional
    public void delete(Integer id){
        Contact contact = entityManager.find(Contact.class,id);
        entityManager.remove(contact);
    }
}
