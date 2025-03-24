package com.emoli.galleryProject.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"com.emoli.galleryProject"})
@EntityScan(basePackages =  {"com.emoli.galleryProject"})
@EnableJpaRepositories(basePackages =  {"com.emoli.galleryProject"})
@SpringBootApplication
public class GalleryProjectApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(GalleryProjectApplicationStarter.class, args);
	}

}
