package com.wishlist.service;

import java.util.ArrayList;
import java.util.List;

import com.wishlist.dao.FollowFriendDao;
import com.wishlist.dao.FollowFriendDaoImpl;
import com.wishlist.model.User;

public class FriendFollowServiceImpl implements FollowFriendService {
	FollowFriendDao fDao;

	@Override
	public boolean followFriend(int frndId, int sesId) {
		boolean result = false;
		fDao = new FollowFriendDaoImpl();
		result = fDao.setFollowFriend(frndId, sesId);
		return result;
	}

	@Override
	public boolean isAlreadyExist(int frndId, int sesId) {
		boolean isFollow = false;
		fDao = new FollowFriendDaoImpl();
		isFollow = fDao.isFollow(frndId, sesId);
		return isFollow;
	}

	@Override
	public boolean unfollowFriend(int frndId, int sesId) {
		boolean unFollow = false;
		fDao = new FollowFriendDaoImpl();
		unFollow = fDao.unSetFollowFriend(frndId, sesId);
		return unFollow;
	}

	@Override
	public List<User> getNotification(int sesId) {
		fDao = new FollowFriendDaoImpl();
		List<User> user = new ArrayList<User>();
		user = fDao.getNotification(sesId);
		return user;
	}

}
