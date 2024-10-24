package me.mahendra.spring_demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.mahendra.spring_demo.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByNameContainingOrEmailContainingOrPhoneContaining(String name, String email, String phone, Pageable pageable);
}
