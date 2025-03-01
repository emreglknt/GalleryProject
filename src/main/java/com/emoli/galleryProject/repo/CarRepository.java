package com.emoli.galleryProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.Car;

@Repository
public interface CarRepository  extends JpaRepository<Car, Long>{

}
