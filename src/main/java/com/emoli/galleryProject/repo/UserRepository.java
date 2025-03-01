package com.emoli.galleryProject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emoli.galleryProject.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

}
