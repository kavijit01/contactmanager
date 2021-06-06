package com.evolent.contactmanager.repository;

import com.evolent.contactmanager.entity.ContactDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactDao, String> {

    List<ContactDao> findAll();
}
