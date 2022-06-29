package com.infy.service;

import java.time.LocalDate;
import java.util.List;

import com.infy.dto.DirectorDTO;
import com.infy.dto.MovieDTO;

public interface MovieService {
	public void addMovieAndDirector(MovieDTO movieDTO, List<DirectorDTO> directorDTOs);

	public void getMovie(String name);

	public void getDirectorDetailsThroughMovieName(String movieName);

	public void getAllMovies();

	public void updateReleaseDate(String movieName, LocalDate updatedReleaseDate);

	public void deleteMovie(String Name);

}
