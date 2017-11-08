package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wishlist.model.Rating;

public class RatingDaoImp implements RatingDao {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	// Rating rate = new Rating();

	@Override
	public boolean rating(Rating rating) {

		boolean result = false;
		try {
			System.out.println(rating.getmId());
			System.out.println(rating.getuId());
			System.out.println(rating.getRating());
			System.out.println(rating.getComment());

			conn = ConnectionDB.getConnect();
			ps = conn.prepareStatement(
					"INSERT INTO rating(uId,score,comment,movieId,dateTime) VALUES (?,?,?,?,CURRENT_TIMESTAMP)");
			ps.setInt(1, rating.getuId());
			ps.setInt(2, rating.getRating());
			ps.setString(3, rating.getComment());
			ps.setInt(4, Integer.parseInt(rating.getmId()));

			ps.executeUpdate();
			System.out.println("Successful");
			result = true;

		} catch (Exception e) {
			System.out.println("Query Error" + e);

		}

		finally {
			if (rs != null) {
				ConnectionDB.close(rs);
			}

			if (ps != null) {
				ConnectionDB.close(ps);
			}
			if (conn != null) {
				ConnectionDB.close(conn);
			}

		}
		return result;
	}

	@Override
	public boolean updateRating(String c, int r, int uid, String mid) {
		boolean res = false;
		try {
			conn = ConnectionDB.getConnect();
			ps = conn.prepareStatement(
					"UPDATE  rating SET comment ='" + c + "' WHERE movieId ='" + mid + "'  AND uId = '" + uid + "' ");
			ps.executeUpdate();
			System.out.println("Rating updated");
			res = true;
		}

		catch (Exception e) {
			System.out.println("Error Update : " + e);
		}

		finally {
			if (rs != null) {
				ConnectionDB.close(rs);
			}

			if (ps != null) {
				ConnectionDB.close(ps);
			}
			if (conn != null) {
				ConnectionDB.close(conn);
			}

		}
		return res;
	}

	@Override
	public boolean validateRating(int uId, String mId) {

		conn = ConnectionDB.getConnect();
		boolean status = false;

		try {
			ps = conn.prepareStatement(
					"SELECT uId , movieId FROM rating WHERE uId = '" + uId + "' AND movieId = '" + mId + "' ");
			rs = ps.executeQuery();

			if (rs.next()) {
				status = false;
				System.out.println("Record already exist");
			}

			else {
				status = true;

			}
		}

		catch (Exception e) {
			System.out.println("Validate error " + e);
		}

		finally {
			if (rs != null) {
				ConnectionDB.close(rs);
			}

			if (ps != null) {
				ConnectionDB.close(ps);
			}
			if (conn != null) {
				ConnectionDB.close(conn);
			}

		}
		return status;
	}

}
