package com.ecommerce.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.model.Contact;
import com.ecommerce.project.payload.ContactDTO;
import com.ecommerce.project.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

   @Autowired
    private ContactRepository contactRepository;

    @Override
    public void saveContact(ContactDTO dto) {
        Contact contact = Contact.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .message(dto.getMessage())
                .build();

        contactRepository.save(contact);
    }
}

