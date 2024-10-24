package me.mahendra.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import me.mahendra.spring_demo.entities.Customer;
import me.mahendra.spring_demo.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        validateCustomerData(customer);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        validateCustomerData(customer);
        return customerRepository.findById(id)
                   .map(existingCustomer -> {
                       existingCustomer.setName(customer.getName());
                       existingCustomer.setEmail(customer.getEmail());
                       existingCustomer.setPhone(customer.getPhone());
                       return customerRepository.save(existingCustomer);
                   })
                   .orElse(null); // Or throw an exception here.
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private void validateCustomerData(Customer customer) {
        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        if (customer.getEmail() == null || !customer.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (customer.getPhone() == null || !customer.getPhone().matches("^\\+?[0-9. ()-]{7,25}$")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public List<Customer> searchCustomers(String name, String email, String phone, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage = customerRepository.findByNameContainingOrEmailContainingOrPhoneContaining(name, email, phone, pageable);
        return customerPage.getContent();
    }
}
