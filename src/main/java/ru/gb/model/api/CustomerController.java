package ru.gb.model.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Customer;
import ru.gb.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.getById(id);
    }

    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping
    public List<Customer> getCustomerByName(@RequestParam String name) {
      return customerRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/customer_id")
    public Long getCustomerId(@RequestParam String name) {
        return customerRepository.findIdByName(name);
    }
}
