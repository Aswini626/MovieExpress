package com.infy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.dto.DirectorDTO;
import com.infy.dto.MovieDTO;
import com.infy.service.DirectorService;
import com.infy.service.DirectorServiceImpl;
import com.infy.service.MovieService;
import com.infy.service.MovieServiceImpl;

@SpringBootApplication
public class ExpressMovieApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext)
		SpringApplication.run(ExpressMovieApplication.class, args);
		
		MovieService movieService = (MovieServiceImpl) context.getBean("movieService");
		DirectorService directorService = (DirectorServiceImpl) context.getBean("directorService");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		
		List<DirectorDTO> directorDTOs = Arrays
				.asList(new DirectorDTO());

		movieService.addMovieAndDirector(new MovieDTO("Radha", LocalDate.now(), LocalDateTime.now()), directorDTOs);

		// 2. Get movie matches based on the input
		movieService.getMovie("radh");

		// 3. Get director details through Movie name
		movieService.getDirectorDetailsThroughMovieName("RRR");

		// 4. Get all movies
		movieService.getAllMovies();

		// 5. update the release date
		movieService.updateReleaseDate("RRR", LocalDate.parse("2022-06-30", formatter));

		// 6. Delete Movie based on title
		movieService.deleteMovie("Radha");

		// 7. update director details
		directorService.updateDirectorDetails("Rajamouli", "ss", "Vishakapatnam", 1234567089);

//		 8. Get movies through director name
		directorService.getMoviesThroughDirectorName("Rajamouli", "ss");

		context.close();
	}

}
