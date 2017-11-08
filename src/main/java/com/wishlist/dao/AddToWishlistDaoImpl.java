package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wishlist.model.Movie;

public class AddToWishlistDaoImpl implements AddToWishlistDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean addWishlistToDB(int uId, int movieId) {
		boolean addToWishlist = false;
		int wishlistId = 0;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("insert into wishlist(uId,movieId) values(?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, uId);
			ps.setInt(2, movieId);
			int i = ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (i != 0) {
				if (rs.next()) {
					wishlistId = rs.getInt(1);
					addToWishlist = true;
				}
			} else
				addToWishlist = false;
		} catch (Exception e) {
			addToWishlist = false;
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
		return addToWishlist;
	}

	@Override
	public boolean checkWishlist(int uId, int movieId) {
		boolean validateWishlist = false;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM wishlist WHERE uId='" + uId + "' and movieId='" + movieId + "'");
			rs = ps.executeQuery();
			if (rs.next()) {
				validateWishlist = true;
			} else {
				validateWishlist = false;
			}
			con.close();

		} catch (Exception e) {
			validateWishlist = false;
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
		return validateWishlist;
	}

	@Override
	public int checkMovie(String imdbId) {
		int movieId = 0;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement("SELECT * FROM movie WHERE imdbID='" + imdbId + "'");
			rs = ps.executeQuery();
			if (rs.next()) {
				String dbImdbId = rs.getString("imdbID");
				if (dbImdbId.equals(imdbId)) {
					movieId = rs.getInt(1);
				}
			} else {
				movieId = 0;
			}
			con.close();

		} catch (Exception e) {
			movieId = 0;
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
		return movieId;
	}

	@Override
	public int addMovieToDB(Movie movie) {
		int movieId = 0;
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement(
					"insert into movie(title,year,rated,released,runtime,genre,director,writer,actors,plot,language,country,awards,poster,metascore,imdbRating,imdbVotes,imdbID,type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getYear());
			ps.setString(3, movie.getRated());
			ps.setString(4, movie.getReleased());
			ps.setString(5, movie.getRuntime());
			ps.setString(6, movie.getGenre());
			ps.setString(7, movie.getDirector());
			ps.setString(8, movie.getWriter());
			ps.setString(9, movie.getActors());
			ps.setString(10, movie.getPlot());
			ps.setString(11, movie.getLanguage());
			ps.setString(12, movie.getCountry());
			ps.setString(13, movie.getAwards());
			ps.setString(14, movie.getPoster());
			ps.setString(15, movie.getMetascore());
			ps.setString(16, movie.getImdbRating());
			ps.setString(17, movie.getImdbVotes());
			ps.setString(18, movie.getImdbID());
			ps.setString(19, movie.getType());
			int i = ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (i != 0) {
				if (rs.next()) {
					movieId = rs.getInt(1);
				}
			} else
				movieId = 0;
		} catch (Exception e) {
			movieId = 0;
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
		return movieId;
	}

}
