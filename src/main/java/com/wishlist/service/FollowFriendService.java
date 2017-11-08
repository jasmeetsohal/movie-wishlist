package com.wishlist.service;

import java.util.List;

import com.wishlist.model.User;

public interface FollowFriendService {

	boolean followFriend(int frndId, int sesId);

	boolean isAlreadyExist(int frndId, int sesId);

	boolean unfollowFriend(int frndId, int sesId);

	List<User> getNotification(int sesId);

}
