package com.emoli.galleryProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
