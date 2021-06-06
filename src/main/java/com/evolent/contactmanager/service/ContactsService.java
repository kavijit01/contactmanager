package com.evolent.contactmanager.service;

import com.evolent.types.Contact;

import java.util.List;

public interface ContactsService {

    List<Contact> getContactList();

    Contact addContact(Contact contact);

    Contact modifyContact(Contact contact);

    void deleteContact(Contact contact);
}
