package com.wishlist.service;

import java.util.List;

import com.wishlist.model.Movie;
import com.wishlist.model.Review;
import com.wishlist.model.User;

public interface UserService {
	String checkByEmail(String email);

	User getUserById(int uId);

	int register(User user);

	User login(String email, String password);

	User update(User user);

	void delete(String email);

	List<Movie> myMovie(int userId, int offset);

	List<Movie> myLatestAddMovie(int userId, int limit);

	List<Review> allReview(String movieId);

	Movie aMovie(String movieId);

}