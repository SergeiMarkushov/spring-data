package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);

    List<Customer> findByNameContainingIgnoreCase (String name);

    @Query(nativeQuery = true, value = "select id from customer where name = :name")
    Long findIdByName(String name);
}
