package com.wishlist.service;

import com.wishlist.dao.RatingDaoImp;
import com.wishlist.model.Rating;

public class RatingServiceImpl implements RatingService {

	RatingDaoImp dao;

	@Override
	public boolean validateIt(Rating rating) {
		dao = new RatingDaoImp();
		boolean res = dao.validateRating(rating.getuId(), rating.getmId());
		if (res == true) {
			dao.rating(rating);
			System.out.println("Rating successfully");
		}

		else {
			dao.updateRating(rating.getComment(), rating.getRating(), rating.getuId(), rating.getmId());
			System.out.println("Rating updated successfully ");
		}

		return res;
	}

}
