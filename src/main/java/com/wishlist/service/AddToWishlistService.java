package com.wishlist.service;

import com.wishlist.model.Movie;

public interface AddToWishlistService {
	boolean addToWishlist(int uId, Movie movie);
}
