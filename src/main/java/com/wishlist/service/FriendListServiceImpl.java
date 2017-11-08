package com.wishlist.service;

import java.util.ArrayList;
import java.util.List;

import com.wishlist.dao.FollowFriendDao;
import com.wishlist.dao.FollowFriendDaoImpl;
import com.wishlist.model.User;

public class FriendListServiceImpl implements FriendListService {
	FollowFriendDao fDao;

	@Override
	public List<User> getFriendList(int sesId) {
		List<User> users = new ArrayList<User>();
		fDao = new FollowFriendDaoImpl();
		users = fDao.getFollowFriends(sesId);
		return users;
	}

	@Override
	public List<User> getFollowers(int sesId) {
		List<User> users = new ArrayList<User>();
		fDao = new FollowFriendDaoImpl();
		users = fDao.getFollower(sesId);
		return users;
	}

}
