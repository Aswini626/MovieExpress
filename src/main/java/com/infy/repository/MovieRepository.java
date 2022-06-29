package com.infy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.entity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{
	@Query("from Movie m where m.movieTitle=?1")
	public Optional<Movie> findByMovieName(String name);

	@Query("from Movie m where m.movieTitle like CONCAT('%',?1,'%')")
	public List<Movie> findByMovieNameLike(String name);

	@Modifying
	@Query("update Movie m set m.dateReleased=?2 where m.movieTitle=?1")
	public Integer updateReleaseDateWithMovieName(String name, LocalDate date);

	@Modifying
	@Query("delete from Movie m where m.movieTitle=?1 ")
	public Integer deleteByMovieName(String name);


}
