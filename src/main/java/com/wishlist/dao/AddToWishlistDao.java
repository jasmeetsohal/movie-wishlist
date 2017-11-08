package com.wishlist.dao;

import com.wishlist.model.Movie;

public interface AddToWishlistDao {
	boolean addWishlistToDB(int uId, int movieId);

	boolean checkWishlist(int uId, int movieId);

	int checkMovie(String imdbId);

	int addMovieToDB(Movie movie);
}
