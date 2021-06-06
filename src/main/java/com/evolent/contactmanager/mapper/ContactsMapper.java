package com.evolent.contactmanager.mapper;


import com.evolent.contactmanager.entity.ContactDao;
import com.evolent.types.Contact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactsMapper {

    List<Contact> toContacts(List<ContactDao> contactDaos);

    Contact toContact(ContactDao contactDao);

    ContactDao toContactDao(Contact contact);
}
