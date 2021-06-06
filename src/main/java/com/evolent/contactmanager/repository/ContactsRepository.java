package com.evolent.contactmanager.repository;

import com.evolent.contactmanager.entity.ContactDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactsRepository extends JpaRepository<ContactDao, String> {

    Optional<ContactDao> findByContactId(Integer contactId);
}
