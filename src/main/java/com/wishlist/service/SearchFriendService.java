package com.wishlist.service;

import java.util.List;

import com.wishlist.model.User;

public interface SearchFriendService {

	List<User> searchFriendByName(String name);

}
