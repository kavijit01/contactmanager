package com.evolent.contactmanager.controller;

import com.evolent.api.ContactsApi;
import com.evolent.contactmanager.service.ContactsService;
import com.evolent.types.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ContactsController implements ContactsApi {

    private final ContactsService contactsService;

    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public ResponseEntity<Contact> addContact(Contact contact) {
        Contact added = contactsService.addContact(contact);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteContact(Contact contact) {
         contactsService.deleteContact(contact);
        return new ResponseEntity("Contact deleted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity <List<Contact>> getContactList(String securityContext) {
        return new ResponseEntity<>(contactsService.getContactList(), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Contact> modifyContact(Contact contact) {
        Contact modified = contactsService.modifyContact(contact);
        return new ResponseEntity(modified, HttpStatus.OK);
    }
}
