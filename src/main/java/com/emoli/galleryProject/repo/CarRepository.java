package com.emoli.galleryProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.Car;

@Repository
public interface CarRepository  extends JpaRepository<Car, Long>{

	
	@Query(value = "select * from gallery.car",nativeQuery = true)
	List<Car> findAllCars();
	
	
	
}
