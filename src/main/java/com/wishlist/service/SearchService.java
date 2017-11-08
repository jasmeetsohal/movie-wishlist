package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Movie;

public interface SearchService {

	List<Movie> byTitle(String title) throws Exception;

	Movie byId(String id) throws Exception;

	List<Movie> sortedMovieList(List<Movie> movieList);

	List<Movie> getTotalMovies(String title, String totalResults) throws Exception;

	int getTotalPages(String url);

	String getTotalResults();

	String getAddedMovieList(int sesId, String movieId);
}
