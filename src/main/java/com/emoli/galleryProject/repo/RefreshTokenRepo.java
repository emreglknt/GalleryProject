package com.emoli.galleryProject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emoli.galleryProject.model.RefreshToken;


@Repository
public interface RefreshTokenRepo extends JpaRepository<RefreshToken,Long>{

	Optional<RefreshToken> findByRefreshToken(String refreshToken);
	
}
