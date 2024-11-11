package com.meshal.taskrestapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    public Contact getContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}
