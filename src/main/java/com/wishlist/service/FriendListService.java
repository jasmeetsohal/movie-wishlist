package com.wishlist.service;

import java.util.List;

import com.wishlist.model.User;

public interface FriendListService {

	List<User> getFriendList(int sesId);

	List<User> getFollowers(int sesId);

}
