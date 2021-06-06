package com.evolent.contactmanager.service;

import com.evolent.contactmanager.entity.ContactDao;
import com.evolent.contactmanager.mapper.ContactsMapper;
import com.evolent.contactmanager.repository.ContactsRepository;
import com.evolent.types.Contact;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository contactsRepository;

    private final ContactsMapper contactsMapper;


    public ContactsServiceImpl(ContactsRepository contactsRepository, ContactsMapper contactsMapper) {
        this.contactsRepository = contactsRepository;
        this.contactsMapper = contactsMapper;
    }

    @Override
    public List<Contact> getContactList() {

        return contactsMapper.toContacts(contactsRepository.findAll());
    }

    @Override
    public Contact addContact(Contact contact) {

        ContactDao contactDao = contactsRepository.save(contactsMapper.toContactDao(contact));
        return contactsMapper.toContact(contactDao);
    }

    @Override
    public Contact modifyContact(Contact contact) {

        Optional optional = contactsRepository.findByContactId(contact.getContactId());
        if(optional.isPresent()){
                ContactDao modifiedContactDao = contactsRepository.save(contactsMapper.toContactDao(contact));
                return contactsMapper.toContact(modifiedContactDao);
        }

        return null;

    }

    @Override
    public void deleteContact(Contact contact) {
        contactsRepository.delete(contactsMapper.toContactDao(contact));
    }
}
