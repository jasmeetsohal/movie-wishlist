package com.wishlist.service;

import com.wishlist.dao.AddToWishlistDaoImpl;
import com.wishlist.model.Movie;

public class AddToWishlistServiceImpl implements AddToWishlistService {

	@Override
	public boolean addToWishlist(int uId, Movie movie) {
		boolean isMovieAddedToWishlist = false;
		int movieId = 0;
		AddToWishlistDaoImpl addToWishlist = new AddToWishlistDaoImpl();
		movieId = addToWishlist.checkMovie(movie.getImdbID());
		if (movieId == 0) {
			movieId = addToWishlist.addMovieToDB(movie);
		}
		boolean validatingWishlist = addToWishlist.checkWishlist(uId, movieId);
		if (!validatingWishlist) {
			isMovieAddedToWishlist = addToWishlist.addWishlistToDB(uId, movieId);
		}
		return isMovieAddedToWishlist;
	}

}
