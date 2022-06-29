package com.infy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.DirectorDTO;
import com.infy.dto.MovieDTO;
import com.infy.entity.Director;
import com.infy.entity.Movie;
import com.infy.repository.MovieRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addMovieAndDirector(MovieDTO movieDTO, List<DirectorDTO> directorDTOs) {

		try {
			System.out.println("------------Inserting movie and director--------------------");
			Optional<Movie> checkMoviesExistance = movieRepository.findByMovieName(movieDTO.getMovieName());
			boolean isMovieExist = (!checkMoviesExistance.isEmpty()) ? true : false;

			if (isMovieExist) {
				throw new Exception("Movie already exists");
			} else {
				// Insert into the database
				Movie movie = modelMapper.map(movieDTO, Movie.class);
				List<Director> directors = new ArrayList<>();
				for (DirectorDTO directorDTO : directorDTOs) {
					directors.add(modelMapper.map(directorDTO, Director.class));
				}

				movie.setDirectors(directors);
				movieRepository.saveAndFlush(movie);

				System.out.println("INSERTION successful");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void getMovie(String name) {
		try {
			System.out.println("-----------Getting movies matched with name");
			List<Movie> movies = movieRepository.findByMovieNameLike(name);
			System.out.println("Movie matches are: ");
			for (Movie movie : movies) {
				System.out.println(movie.getMovieName());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}



	@Override
	public void getAllMovies() {
		movieRepository.findAll().forEach(System.out::println);
		
	}

	@Override
	public void updateReleaseDate(String movieName, LocalDate updatedReleaseDate) {
		Optional<Movie> movie = movieRepository.findByMovieName(movieName);
		if (movie.isEmpty()) {
			System.out.println("The movie not present in the table");
		} else {
			Integer rowsAffected = movieRepository.updateReleaseDateWithMovieName(movieName, updatedReleaseDate);
			System.out.println("Number of rows affected: " + rowsAffected);
		}
		
	}

	@Override
	public void deleteMovie(String name) {
		Optional<Movie> movie = movieRepository.findByMovieName(name);
		if (movie.isEmpty()) {
			System.out.println("Movie not found");
		} else {
			Integer rowsAffected = movieRepository.deleteByMovieName(name);
			System.out.println("Number of rows affected: " + rowsAffected);
		}
		
	}

	@Override
	public void getDirectorDetailsThroughMovieName(String movieName) {
		Optional<Movie> movie = movieRepository.findByMovieName(movieName);
		if (movie.isEmpty()) {
			System.out.println("Movie is not present in the table");
		} else {
			movie.get().getDirectors().forEach(System.out::println);
		}
		
	}

}
