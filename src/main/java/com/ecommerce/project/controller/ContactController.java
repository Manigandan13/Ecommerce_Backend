package com.ecommerce.project.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.project.payload.ContactDTO;
import com.ecommerce.project.service.ContactService;

@RestController
@RequestMapping("/api/public/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<String> sendContact(@Valid @RequestBody ContactDTO contactDTO) {
        contactService.saveContact(contactDTO);
        return ResponseEntity.ok("Message sent successfully");
    }
}
