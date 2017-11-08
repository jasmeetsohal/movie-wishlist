package com.wishlist.dao;

import com.wishlist.model.Rating;

public interface RatingDao {
	
	public boolean rating(Rating rating);
	public boolean validateRating(int uid , String mid);
	public boolean updateRating(String c, int r,int uid,String mid);

}
