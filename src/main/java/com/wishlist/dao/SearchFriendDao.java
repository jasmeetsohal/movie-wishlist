package com.wishlist.dao;

import java.util.List;

import com.wishlist.model.User;

public interface SearchFriendDao {
	public List<User> getUsers(String userName);

}
