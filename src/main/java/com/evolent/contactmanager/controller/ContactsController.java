package com.evolent.contactmanager.controller;

import com.evolent.api.ContactsApi;
import com.evolent.contactmanager.service.ContactService;
import com.evolent.types.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ContactsController implements ContactsApi {

    private final ContactService contactService;

    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public ResponseEntity<Void> addContact(Contact body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteContact(String contactId, Contact body) {
        return null;
    }

    @Override
    public ResponseEntity <List<Contact>> getContactList(String securityContext) {
        return new ResponseEntity<>(contactService.getContactList(), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Void> modifyContact(Contact body) {
        return null;
    }
}
