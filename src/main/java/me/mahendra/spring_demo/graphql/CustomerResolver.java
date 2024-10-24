package me.mahendra.spring_demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.mahendra.spring_demo.entities.Customer;
import me.mahendra.spring_demo.service.CustomerService;

import java.util.List;

@Component
public class CustomerResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CustomerService customerService;

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Customer getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }

    public List<Customer> searchCustomers(String name, String email, String phone, int page, int size) {
        return customerService.searchCustomers(name, email, phone, page, size);
    }

    public Customer createCustomer(String name, String email, String phone) {
        Customer customer = new Customer(name, email, phone);
        return customerService.createCustomer(customer);
    }

    public Customer updateCustomer(Long id, String name, String email, String phone) {
        Customer customer = new Customer(name, email, phone);
        customer.setId(id);
        return customerService.updateCustomer(id, customer);
    }

    public boolean deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
        return true;
    }
}
