package com.wishlist.dao;

import java.util.List;

import com.wishlist.model.User;

public interface FollowFriendDao {

	public boolean setFollowFriend(int id, int sesId);

	public boolean isFollow(int id, int sesId);

	public boolean unSetFollowFriend(int id, int sesId);

	public List<User> getFollowFriends(int sesId);

	public void postStatus(int uId, int frndId, String msg, String status);

	public List<User> getNotification(int sesId);

	public List<User> getFollower(int sesId);

}
