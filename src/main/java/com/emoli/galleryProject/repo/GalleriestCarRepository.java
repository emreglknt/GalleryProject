package com.emoli.galleryProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.GalleriestCar;

@Repository
public interface GalleriestCarRepository  extends JpaRepository<GalleriestCar,Long >{

}
