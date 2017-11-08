package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FeedBackDaoImpl implements FeedBackDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean setFeedBack(String name, String email, String subject, String mes) {
		boolean feedBack = false;
		int wishlistId = 0;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("insert into feedback(name,email,subject,message) values(?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, subject);
			ps.setString(4, mes);
			int i = ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (i != 0) {
				if (rs.next()) {
					wishlistId = rs.getInt(1);
					feedBack = true;
				}
			} else
				feedBack = false;
		} catch (Exception e) {
			feedBack = false;
			e.printStackTrace();
		} finally {
			if (con != null) {
				ConnectionDB.close(con);
			}
			if (ps != null) {
				ConnectionDB.close(ps);
			}
			if (rs != null) {
				ConnectionDB.close(rs);
			}
		}
		return feedBack;
	}

}
