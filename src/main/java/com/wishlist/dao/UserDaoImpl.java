package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.wishlist.db.DBConn;
import com.wishlist.db.DBException;
import com.wishlist.model.User;
import com.wishlist.util.GlobalConstants;

public class UserDaoImpl implements UserDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private String status;

	@Override
	public String checkUserByEmail(String email) {

		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM user WHERE uEmail='" + email + "'");
			rs = ps.executeQuery();
			if (rs.next()) {
				String dbEmail = rs.getString("uEmail");
				if (dbEmail.equals(email)) {
					this.status = "match-found";
				}
			} else {
				this.status = "not-found";
			}

		} catch (Exception e) {
			this.status = "null";
			System.out.println("*************************" + e);
		} finally {
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
		return status;
	}

	@Override
	public int userRegister(User user) {
		int id = 0;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("insert into user(uName,uEmail,uPassword) values(?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getuName());
			ps.setString(2, user.getuEmail());
			ps.setString(3, user.getuPassword());
			int i = ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (i != 0)
				if (rs.next()) {
					id = rs.getInt(1);
					user.setuId(id);
				}

		} catch (Exception e) {
			id = 0;
			e.printStackTrace();
		} finally {
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
		return id;
	}

	@Override
	public User userLogin(String email, String password) {

		User logUser = new User();
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM user WHERE uEmail='" + email + "'");
			rs = ps.executeQuery();
			if (rs.next()) {
				String dbEmail = rs.getString("uEmail");
				String dbPassword = rs.getString("uPassword");
				if (dbEmail.equals(email) && dbPassword.equals(password)) {
					int dbId = rs.getInt("uId");
					String dbName = rs.getString("uName");
					System.out.println("User Logged In");
					logUser.setuId(dbId);
					logUser.setuName(dbName);
					logUser.setuEmail(dbEmail);
					logUser.setuPassword(dbPassword);
				}
			} else {
				System.out.println("User Authentication Fails !!!");
			}

		} catch (Exception e) {
			System.out.println("*************************" + e + "############");
		} finally {
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
		return logUser;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM user WHERE uId = '" + id + "' ");
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setuEmail(rs.getString("uEmail"));
				user.setuName(rs.getString("uName"));
				user.setuId(rs.getInt("uId"));
			}

		} catch (Exception e) {
			System.out.println("Dao exception " + e);

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

		return user;
	}

	private static final Logger LOGGER = Logger.getLogger(User.class.getName());

	public static User selectUSER(String userId) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		User pojo = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(
					"select uId, uEmail, uName, emailVerificaitonHash, emailVerificationAttempt, status, date_time from user where uId = ?");
			ps.setString(1, userId);
			res = ps.executeQuery();
			if (res != null) {
				while (res.next()) {
					pojo = new User();
					pojo.setuId(res.getInt(1));
					pojo.setuEmail(res.getString(2));
					pojo.setuName(res.getString(3));
					pojo.setEMAIL_VERIFICATION_HASH(res.getString(4));
					pojo.setEMAIL_VERIFICATION_ATTEMPTS(res.getInt(5));
					pojo.setSTATUS(res.getString(6));
					pojo.setCREATED_TIME(res.getString(7));
				}
			}
			DBConn.close(conn, ps, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			DBConn.close(conn, ps, res);
			LOGGER.debug(e.getMessage());
			throw new DBException("Excepion while accessing database 1");
		}
		return pojo;
	}

	public static boolean verifyEmailHash(String user_id, String hash) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean verified = false;
		ResultSet res = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("select 1 from user where uid = ? and emailVerificationHash = ?");
			ps.setString(1, user_id);
			ps.setString(2, hash);
			res = ps.executeQuery();
			if (res != null) {
				while (res.next()) {
					verified = true;
				}
			}
			DBConn.close(conn, ps, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			DBConn.close(conn, ps, res);
			LOGGER.debug(e.getMessage());
			throw new DBException("Excepion while accessing database 2");
		}
		return verified;
	}

	public static boolean isEmailExists(String email) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean verified = false;
		ResultSet res = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("select 1 from user where uEmail = ?");
			ps.setString(1, email);
			res = ps.executeQuery();
			if (res != null) {
				while (res.next()) {
					verified = true;
				}
			}
			DBConn.close(conn, ps, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps, res);
			throw new DBException("Excepion while accessing database 3");
		}
		return verified;
	}

	public static String insertRow(User pojo) throws DBException {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		String id = null;
		ResultSet res = null;
		try {
			conn = DBConn.getConnection();
			conn.setAutoCommit(false);
			ps1 = conn.prepareStatement(
					"insert into user(uEmail,uName,emailVerificationHash,uPassword) values (?,?,?,?)");
			ps1.setString(1, pojo.getuEmail());
			ps1.setString(2, pojo.getuName());

			ps1.setString(3, pojo.getEMAIL_VERIFICATION_HASH());
			ps1.setString(4, pojo.getuPassword());
			ps1.executeUpdate();

			ps2 = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			res = ps2.executeQuery();

			if (res != null) {
				while (res.next()) {
					id = res.getString(1);
				}
			}

			conn.commit();
			DBConn.close(conn, ps1, ps2, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps1, ps2, res);
			throw new DBException("Excepion while accessing database 4");
		}
		return id;
	}

	public static void deleteRow(User pojo) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("delete from user where uId = ?");
			ps.setInt(1, pojo.getuId());
			ps.executeUpdate();
			ps.close();
			DBConn.close(conn, ps);
		} catch (SQLException | ClassNotFoundException e) {
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps);
			e.printStackTrace();
		}
	}

	public static void updateStaus(String user_id, String status) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("update user set status = ? where uId = ?");
			ps.setString(1, status);
			ps.setString(2, user_id);
			ps.executeUpdate();
			DBConn.close(conn, ps);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps);
			throw new DBException("Excepion while accessing database 5");
		}
	}

	public static void updateEmailVerificationHash(String user_id, String hash) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(
					"update user set emailVerificationHash = ?, emailVerificationAttempt = ? where uId = ?");
			ps.setString(1, hash);
			ps.setInt(2, 0);
			ps.setString(3, user_id);
			ps.executeUpdate();
			DBConn.close(conn, ps);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps);
			throw new DBException("Excepion while accessing database 6");
		}
	}

	public static int incrementVerificationAttempts(String user_id) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet res = null;
		int attempts = 0;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(
					"update user set emailVerificationAttempt = emailVerificationAttempt + 1 where uId = ?");
			ps.setString(1, user_id);
			ps.executeUpdate();

			ps2 = conn.prepareStatement("SELECT emailVerificationAttempt from user");
			res = ps2.executeQuery();

			if (res != null) {
				while (res.next()) {
					attempts = res.getInt(1);
				}
			}
			DBConn.close(conn, ps, ps2, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps, ps2, res);
			throw new DBException("Excepion while accessing database 7");
		}
		return attempts;
	}

	public static User verifyLogin(String inputEmail, String inputPassword) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		User pojo = null;
		ResultSet res = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(
					"select uId, uEmail, uName, status, dateTime from user where uEmail = ? and uPassword = ?");
			ps.setString(1, inputEmail);
			ps.setString(2, inputPassword);
			res = ps.executeQuery();
			if (res != null) {
				while (res.next()) {
					pojo = new User();
					pojo.setuId(res.getInt(1));
					pojo.setuEmail(res.getString(2));
					pojo.setuName(res.getString(3));

					pojo.setSTATUS(res.getString(4));
					pojo.setCREATED_TIME(res.getString(5));
				}
			}
			DBConn.close(conn, ps, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps, res);
			throw new DBException("Excepion while accessing database 8");
		}
		return pojo;
	}

	public static boolean verifyUserIdAndPassword(String userId, String inputCurrentPassword) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean verified = false;
		ResultSet res = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("select 1 from user where uId = ? and uPassword = ?");
			ps.setString(1, userId);
			ps.setString(2, inputCurrentPassword);
			res = ps.executeQuery();
			if (res != null) {
				while (res.next()) {
					verified = true;
				}
			}
			DBConn.close(conn, ps, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps, res);
			throw new DBException("Excepion while accessing database 9");
		}
		return verified;
	}

	public static void updatePassword(String userId, String inputPassword) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("update user set uPassword = ? where uId = ?");
			ps.setString(1, inputPassword);
			ps.setString(2, userId);
			ps.executeUpdate();
			DBConn.close(conn, ps);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps);
			throw new DBException("Excepion while accessing database 10");
		}
	}

	public static void updateEmailVerificationHashForResetPassword(String inputEmail, String hash) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(
					"update user set emailVerificationHash = ?, emailVerificationAttempt = ?, status = ? where uEmail = ?");
			ps.setString(1, hash);
			ps.setInt(2, 0);
			ps.setString(3, GlobalConstants.IN_RESET_PASSWORD);
			ps.setString(4, inputEmail);
			ps.executeUpdate();
			DBConn.close(conn, ps);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps);
			throw new DBException("Excepion while accessing database 11");
		}
	}

	public static User selectUSERbyEmail(String inputEmail) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		User pojo = null;
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(
					"select uId, uEmail, uName, emailVerificationHash, emailVerificationAttempt, status, dateTime from user where uEmail = ?");
			ps.setString(1, inputEmail);
			res = ps.executeQuery();
			if (res != null) {
				while (res.next()) {
					pojo = new User();
					pojo.setuId(res.getInt(1));
					pojo.setuEmail(res.getString(2));
					pojo.setuName(res.getString(3));
					pojo.setEMAIL_VERIFICATION_HASH(res.getString(4));
					pojo.setEMAIL_VERIFICATION_ATTEMPTS(res.getInt(5));
					pojo.setSTATUS(res.getString(6));
					pojo.setCREATED_TIME(res.getString(7));
				}
			}
			DBConn.close(conn, ps, res);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			LOGGER.debug(e.getMessage());
			DBConn.close(conn, ps, res);
			throw new DBException("Excepion while accessing database 12");
		}
		return pojo;
	}

	@Override
	public String getAddedMovie(int sesId, String movieId) {

		String imdbId = "";
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT imdbID FROM movie,wishlist where wishlist.uId = '" + sesId
					+ "' and movie.movieId='" + movieId + "'");
			rs = ps.executeQuery();
			while (rs.next()) {
				imdbId = rs.getString("imdbID");
			}

		} catch (Exception e) {
			System.out.println("*************************" + e + "############");
		} finally {
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
		return imdbId;
	}

}
