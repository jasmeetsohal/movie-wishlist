package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wishlist.model.User;

public class SearchFriendDaoImpl implements SearchFriendDao {
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	@Override
	public List<User> getUsers(String userName) {
		User user;
		List<User> users = new ArrayList<>();
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM user WHERE uName LIKE '%" + userName + "%' ");
			rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setuName(rs.getString("uName"));
				user.setuEmail(rs.getString("uEmail"));
				user.setuId(rs.getInt("uId"));
				users.add(user);

			}
		}

		catch (Exception e) {

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

		return users;
	}

}
