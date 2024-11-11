package com.meshal.taskrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AppController {

    private final ContactService contactService;

    @Autowired
    public AppController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/addContact")
    public String addContact(@RequestBody Contact contact) {
        if (contactService.getContactByEmail(contact.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Contact already exists");
        }
        contactService.addContact(contact);
        return "Contact added successfully!";
    }

    @GetMapping("/getContactDetails")
    public Contact getContactDetails(@RequestParam String name) {
        Contact contact = contactService.getContactByName(name);
        if (contact == null) {  // Throw a 404 if contact not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found");
        }
        return contact;
    }
}
