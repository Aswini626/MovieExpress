package com.infy.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovieDTO {
	private Integer movieId;
	private String movieName;
	private LocalDate dateReleased;
	private LocalDateTime movieRunningTime;
	public MovieDTO() {
		super();
	}
	
	public MovieDTO(String movieName, LocalDate dateReleased, LocalDateTime movieRunningTime) {
		super();
		this.movieName = movieName;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}

	public MovieDTO(Integer movieId, String movieName, LocalDate dateReleased, LocalDateTime movieRunningTime) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDate getDateReleased() {
		return dateReleased;
	}
	public void setDateReleased(LocalDate dateReleased) {
		this.dateReleased = dateReleased;
	}
	public LocalDateTime getMovieRunningTime() {
		return movieRunningTime;
	}
	public void setMovieRunningTime(LocalDateTime movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}
	
}
