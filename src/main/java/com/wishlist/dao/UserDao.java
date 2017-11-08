package com.wishlist.dao;

import com.wishlist.model.User;

public interface UserDao {
	String checkUserByEmail(String email);

	User getUserById(int id);

	int userRegister(User user);

	User userLogin(String email, String password);

	String getAddedMovie(int sesId, String movieId);
}