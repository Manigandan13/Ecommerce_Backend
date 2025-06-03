package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

