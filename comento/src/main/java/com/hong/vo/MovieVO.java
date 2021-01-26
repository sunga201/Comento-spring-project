package com.hong.vo;

import org.springframework.stereotype.Repository;

@Repository
public class MovieVO {
	private Long movieId;
	
	private String movieName;
	
	private String director;
	
	private String type;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "[movieId : " + movieId +
			   ", movieName : " + movieName + 
			   ", director : " + director + 
			   ", type : " + type;
	}
}
