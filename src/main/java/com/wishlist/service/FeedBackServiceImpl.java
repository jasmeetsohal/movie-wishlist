package com.wishlist.service;

import com.wishlist.dao.FeedBackDao;
import com.wishlist.dao.FeedBackDaoImpl;

public class FeedBackServiceImpl implements FeedBackService {
	FeedBackDao fDao;

	@Override
	public boolean sendFeedBack(String name, String email, String subject, String mes) {
		fDao = new FeedBackDaoImpl();

		return fDao.setFeedBack(name, email, subject, mes);
	}

}
