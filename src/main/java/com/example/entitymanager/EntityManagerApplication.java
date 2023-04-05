package com.example.entitymanager;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EntityManagerApplication implements CommandLineRunner {

    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(EntityManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("working sucessfully....");
//        createcontact();
            listcontact();
//        getContact();       //if contact id is not found, then return null
//        updateContact();
//        deleteContact();
    }

    private void getContact(){
        Integer id=3;
        Contact contact = contactRepository.findById(id);
        System.out.println(contact);
    }
    private void createcontact(){
        Contact contact = new Contact();
        contact.setName("Mahela");
        contact.setEmail("mahela75@gmail.com");
        contact.setAddress("negombo");

        contactRepository.save(contact);
    }

    private void listcontact(){
        List<Contact> listContact = contactRepository.findAll();
        listContact.forEach(System.out::println);
    }

    private void updateContact(){
        Integer id = 3;
        Contact contact= contactRepository.findById(id);
        contact.setAddress("colombo");
        contact.setName("Mendis");

        contactRepository.update(contact);
    }

    private void deleteContact(){
        Integer id=4;   // int id=4;
        contactRepository.delete(id);
    }
}
