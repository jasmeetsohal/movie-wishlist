package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wishlist.model.User;

public class FollowFriendDaoImpl implements FollowFriendDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean setFollowFriend(int id, int sesId) {
		boolean isFollow = false;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("INSERT INTO  friend(uId,followId) VALUES (?,?)");
			ps.setInt(1, sesId);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			// rs = ps.getGeneratedKeys();
			if (i != 0) {
				System.out.println("successfully followed");
				isFollow = true;
				postStatus(sesId, id, "f", "Followed");

			}

		} catch (Exception e) {

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
		return isFollow;
	}

	@Override
	public boolean isFollow(int id, int sesId) {
		boolean isFollow = false;

		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM friend WHERE uId = '" + sesId + "' AND followId = '" + id + "'");
			rs = ps.executeQuery();
			if (rs.next() != false) {
				isFollow = true;
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

		return isFollow;
	}

	@Override
	public boolean unSetFollowFriend(int id, int sesId) {
		boolean unFollow = false;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("DELETE FROM friend WHERE uId = '" + sesId + "' AND followId = '" + id + "' ");
			int i = ps.executeUpdate();

			if (i != 0) {
				System.out.println("successfully Unfollowed");
				unFollow = true;
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
		return unFollow;
	}

	@Override
	public List<User> getFollowFriends(int sesId) {
		List<User> users = new ArrayList<User>();

		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement(
					"SELECT * FROM friend , user WHERE friend.uId='" + sesId + "' AND friend.followId = user.uId ");
			rs = ps.executeQuery();
			while (rs.next()) {
				User usr = new User();
				usr.setuName(rs.getString("user.uName"));
				usr.setuId(rs.getInt("user.uId"));
				users.add(usr);
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

	@Override
	public void postStatus(int uId, int frndId, String msg, String status) {

		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("INSERT INTO notification(uId,friendId,message,status) VALUES (?,?,?,?)");
			ps.setInt(1, uId);
			ps.setInt(2, frndId);
			ps.setString(3, msg);
			ps.setString(4, status);

			int i = ps.executeUpdate();
			// rs = ps.getGeneratedKeys();
			if (i != 0) {
				System.out.println("successfully added status");

			}

		} catch (Exception e) {

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

	}

	@Override
	public List<User> getNotification(int sesId) {

		List<User> users = new ArrayList<User>();
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM notification , user WHERE notification.friendId = '" + sesId
					+ "' AND notification.uId = user.uId  order by notification.notifyId DESC limit 3");
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setuName(rs.getString("user.uName"));
				user.setuId(rs.getInt("user.uId"));
				users.add(user);
			}
		} catch (Exception e) {

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

	@Override
	public List<User> getFollower(int sesId) {
		List<User> users = new ArrayList<User>();
		try {

			con = ConnectionDB.getConnect();
			ps = con.prepareStatement(
					"SELECT * FROM friend , user WHERE friend.followId='" + sesId + "' AND friend.uId = user.uId ");
			rs = ps.executeQuery();
			while (rs.next()) {
				User usr = new User();
				usr.setuName(rs.getString("user.uName"));
				usr.setuId(rs.getInt("user.uId"));
				users.add(usr);
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

		return users;
	}

}
