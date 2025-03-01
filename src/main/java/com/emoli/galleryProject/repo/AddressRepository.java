package com.emoli.galleryProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
