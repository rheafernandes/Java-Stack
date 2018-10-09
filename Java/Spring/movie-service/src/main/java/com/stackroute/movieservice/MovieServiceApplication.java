package com.stackroute.movieservice;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MovieServiceApplication implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		movieRepository.save(new Movie("VM","Venom",(float)4.5,"2018"));
		movieRepository.save(new Movie("DOJ","Dawn of Justice",(float)4.5,"2015"));
	}
	@Override
	public void run(String... args) throws Exception {
		movieRepository.save(new Movie("TLOR","The Lord of the rings",(float)4.8,"2015"));
		movieRepository.save(new Movie("HOB","The Hobbit",(float)4.5,"2015"));
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
}


