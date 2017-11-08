package com.wishlist.service;

import java.util.List;

import com.wishlist.dao.MyMovieDaoImpl;
import com.wishlist.dao.UserDao;
import com.wishlist.dao.UserDaoImpl;
import com.wishlist.dao.UserReviewDaoImpl;
import com.wishlist.model.Movie;
import com.wishlist.model.Review;
import com.wishlist.model.User;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDaoImpl();

	@Override
	public String checkByEmail(String email) {
		dao = new UserDaoImpl();
		String msg = dao.checkUserByEmail(email);
		return msg;
	}

	@Override
	public int register(User user) {
		dao = new UserDaoImpl();
		int userId = dao.userRegister(user);
		return userId;
	}

	@Override
	public User login(String email, String password) {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.userLogin(email, password);
		return user;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public void delete(String email) {

	}

	@Override
	public List<Movie> myMovie(int userId, int offsetValue) {
		MyMovieDaoImpl userMovieDao = new MyMovieDaoImpl();
		List<Movie> userMovieList = userMovieDao.MyWishMovie(userId, offsetValue);
		System.out.println(userId);
		return userMovieList;
	}

	@Override
	public List<Review> allReview(String movieId) {
		UserReviewDaoImpl userReviewDao = new UserReviewDaoImpl();
		List<Review> userReview = userReviewDao.UserReview(movieId);
		System.out.println("service" + userReview);
		return userReview;
	}

	@Override
	public Movie aMovie(String movieId) {
		UserReviewDaoImpl userReviewDao = new UserReviewDaoImpl();
		Movie singleMovie = userReviewDao.displayMovie(movieId);
		return singleMovie;
	}

	@Override
	public List<Movie> myLatestAddMovie(int userId, int limit) {
		MyMovieDaoImpl userMovieDao = new MyMovieDaoImpl();
		List<Movie> userMovieList = userMovieDao.MyShortWishMovie(userId, limit);

		return userMovieList;
	}

	@Override
	public User getUserById(int uId) {
		User user = new User();
		user = dao.getUserById(uId);
		return user;
	}

}
