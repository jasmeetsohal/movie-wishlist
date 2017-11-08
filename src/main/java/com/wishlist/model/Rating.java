package com.wishlist.model;

public class Rating {

	private int uId;
	private int rating;
	private String comment;
	private String mId;

	public String getmId() {
		return mId;
	}

	public void setmId(String mid2) {
		this.mId = mid2;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getRating() {
		return rating;
	}

	public String getComment() {
		return comment;
	}

	public void setRating(int r) {
		this.rating = r;
	}

	public void setComment(String c) {
		this.comment = c;
	}

}
