package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.model.Customer;
import ru.gb.repository.CustomerRepository;

@Component
public class DatabaseFiller {

    @Autowired
    private CustomerRepository customerRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartApplication(){
        customerRepository.save(createCustomer("Bob"));
        customerRepository.save(createCustomer("Piter"));
        customerRepository.save(createCustomer("John"));
        customerRepository.save(createCustomer("Johnathan"));
        customerRepository.save(createCustomer("Polo"));

    }

    private Customer createCustomer(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        return customer;
    }

}
