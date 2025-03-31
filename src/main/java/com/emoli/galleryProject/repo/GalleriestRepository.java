package com.emoli.galleryProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.Car;
import com.emoli.galleryProject.model.Galleriest;

@Repository
public interface GalleriestRepository extends JpaRepository<Galleriest, Long> {


	
	
}
