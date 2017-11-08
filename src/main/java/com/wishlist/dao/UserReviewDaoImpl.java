package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wishlist.model.Movie;
import com.wishlist.model.Review;

public class UserReviewDaoImpl {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Movie displayMovie(String movieId) {

		Movie movie = new Movie();
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM movie WHERE movieId = '" + movieId + "' ");
			rs = ps.executeQuery();
			if (rs.next()) {
				movie.setPoster(rs.getString("poster"));
				movie.setMovieId(rs.getInt("movieId"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			if (rs != null) {
				ConnectionDB.close(rs);
			}

			if (ps != null) {
				ConnectionDB.close(ps);
			}
			if (con != null) {
				ConnectionDB.close(con);
			}

		}
		return movie;
	}

	public List<Review> UserReview(String movieId) {

		List<Review> commentList = new ArrayList<>();

		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement(
					"select * from rating,user where rating.movieId='" + movieId + "' and rating.uId = user.uId");
			rs = ps.executeQuery();
			while (rs.next()) {
				Review review = new Review();

				review.setuName(rs.getString("uName"));

				review.setComment(rs.getString("comment"));
				review.setDateTime(rs.getString("DateTime"));
				review.setuId(rs.getInt("uId"));
				review.setMovieId(rs.getString("movieId"));
				review.setRatingId(rs.getInt("ratingId"));
				review.setScore(rs.getString("score"));

				commentList.add(review);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			if (rs != null) {
				ConnectionDB.close(rs);
			}

			if (ps != null) {
				ConnectionDB.close(ps);
			}
			if (con != null) {
				ConnectionDB.close(con);
			}

		}
		return commentList;

	}

}
