package com.wishlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wishlist.model.Movie;
import com.wishlist.model.User;

public class MyMovieDaoImpl {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public List<Movie> MyWishMovie(int userId, int offsetValue) {
		User user = new User();

		user.getuId();
		List<Movie> movieList = new ArrayList<>();
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement(
					"select * from wishlist w inner join movie m on w.movieId = m.movieId where uId = '" + userId
							+ "' LIMIT 9 OFFSET " + offsetValue);
			rs = ps.executeQuery();
			while (rs.next()) {
				Movie mymovie = new Movie();
				mymovie.setMovieId(rs.getInt("movieId"));
				mymovie.setTitle(rs.getString("title"));
				mymovie.setYear(rs.getString("year"));

				if (rs.getString("poster").equals("N/A")) {
					mymovie.setPoster(
							"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYRwmxOXpyFg-cf2FggW_uOq1iaARHkkXX4D2gNSb0PhQKC6xHJQ");
				} else {
					mymovie.setPoster(rs.getString("poster"));
				}

				mymovie.setImdbID(rs.getString("imdbID"));
				mymovie.setRated(rs.getString("rated"));
				mymovie.setReleased(rs.getString("released"));
				mymovie.setRuntime(rs.getString("runtime"));
				mymovie.setGenre(rs.getString("genre"));
				mymovie.setDirector(rs.getString("director"));
				mymovie.setWriter(rs.getString("writer"));
				mymovie.setActors(rs.getString("actors"));
				mymovie.setPlot(rs.getString("plot"));
				mymovie.setLanguage(rs.getString("language"));
				mymovie.setCountry(rs.getString("country"));
				mymovie.setAwards(rs.getString("awards"));
				mymovie.setMetascore(rs.getString("metascore"));
				mymovie.setImdbRating(rs.getString("imdbRating"));
				mymovie.setImdbVotes(rs.getString("imdbVotes"));
				mymovie.setType(rs.getString("type"));
				movieList.add(mymovie);

			}
		} catch (Exception e) {
			System.out.println(e);
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

		return movieList;
	}

	public List<Movie> MyShortWishMovie(int userId, int limit) {
		User user = new User();

		user.getuId();
		List<Movie> movieList = new ArrayList<>();
		try {
			con = ConnectionDB.getConnect();
			ps = con.prepareStatement(
					"select * from wishlist w inner join movie m on w.movieId = m.movieId where uId = '" + userId
							+ "' ORDER BY m.movieId DESC LIMIT " + limit);
			rs = ps.executeQuery();
			while (rs.next()) {
				Movie mymovie = new Movie();
				mymovie.setMovieId(rs.getInt("movieId"));
				mymovie.setTitle(rs.getString("title"));
				mymovie.setYear(rs.getString("year"));

				if (rs.getString("poster").equals("N/A")) {
					mymovie.setPoster(
							"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYRwmxOXpyFg-cf2FggW_uOq1iaARHkkXX4D2gNSb0PhQKC6xHJQ");
				} else {
					mymovie.setPoster(rs.getString("poster"));
				}

				mymovie.setImdbID(rs.getString("imdbID"));
				mymovie.setRated(rs.getString("rated"));
				mymovie.setReleased(rs.getString("released"));
				mymovie.setRuntime(rs.getString("runtime"));
				mymovie.setGenre(rs.getString("genre"));
				mymovie.setDirector(rs.getString("director"));
				mymovie.setWriter(rs.getString("writer"));
				mymovie.setActors(rs.getString("actors"));
				mymovie.setPlot(rs.getString("plot"));
				mymovie.setLanguage(rs.getString("language"));
				mymovie.setCountry(rs.getString("country"));
				mymovie.setAwards(rs.getString("awards"));
				mymovie.setMetascore(rs.getString("metascore"));
				mymovie.setImdbRating(rs.getString("imdbRating"));
				mymovie.setImdbVotes(rs.getString("imdbVotes"));
				mymovie.setType(rs.getString("type"));
				movieList.add(mymovie);

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

		return movieList;
	}

}