package com.evolent.contactmanager.service;

import com.evolent.contactmanager.mapper.ContactsMapper;
import com.evolent.contactmanager.repository.ContactRepository;
import com.evolent.types.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    private final ContactsMapper contactsMapper;


    public ContactServiceImpl(ContactRepository contactRepository, ContactsMapper contactsMapper) {
        this.contactRepository = contactRepository;
        this.contactsMapper = contactsMapper;
    }

    @Override
    public List<Contact> getContactList() {

        return contactsMapper.toContacts(contactRepository.findAll());
    }
}
