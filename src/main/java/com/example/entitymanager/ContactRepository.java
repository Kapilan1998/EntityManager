package com.example.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {

    @Autowired
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
}
