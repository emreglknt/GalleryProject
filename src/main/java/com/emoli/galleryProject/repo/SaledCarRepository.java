package com.emoli.galleryProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.SaledCar;

@Repository
public interface SaledCarRepository  extends JpaRepository<SaledCar, Long>{

}
