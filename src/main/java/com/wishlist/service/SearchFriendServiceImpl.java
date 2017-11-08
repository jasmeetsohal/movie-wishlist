package com.wishlist.service;

import java.util.List;

import com.wishlist.dao.SearchFriendDao;
import com.wishlist.dao.SearchFriendDaoImpl;
import com.wishlist.model.User;

public class SearchFriendServiceImpl implements SearchFriendService {
	SearchFriendDao sDao;

	@Override
	public List<User> searchFriendByName(String name) {
		sDao = new SearchFriendDaoImpl();
		List<User> users = sDao.getUsers(name);
		return users;

	}

}
