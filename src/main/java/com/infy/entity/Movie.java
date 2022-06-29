package com.infy.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="movie_name")
	private String movieName;
	@Column(name="date_released")
	private LocalDate dateReleased;
	@Column(name="movie_running_time")
	private LocalDateTime movieRunningTime;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "movieDirector", joinColumns = @JoinColumn(name = "movieId", referencedColumnName = "movieId"), inverseJoinColumns = @JoinColumn(name = "directorId", referencedColumnName = "directorId"))
	private List<Director> directors;
	public List<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	public Movie() {
		super();
	}
	public Movie(Integer movieId, String movieName, LocalDate dateReleased, LocalDateTime movieRunningTime) {
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
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", dateReleased=" + dateReleased
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}
	

}
