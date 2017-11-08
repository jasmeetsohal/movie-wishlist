package com.wishlist.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.wishlist.dao.UserDao;
import com.wishlist.dao.UserDaoImpl;
import com.wishlist.model.Movie;
import com.wishlist.util.MovieSortComparator;

public class SearchServiceImpl implements SearchService {

	String totalRes = "";

	private class SearchByTitle {
		String totalResults;
		String Response;
		List<Movie> Search;
	}

	@Override
	public List<Movie> byTitle(String title) throws Exception {
		String url = "http://www.omdbapi.com/?s=" + title.replace(" ", "%20");
		String json = readUrl(url);
		Gson gson = new Gson();
		SearchByTitle searchData = gson.fromJson(json, SearchByTitle.class);
		String totalResults = searchData.totalResults;
		totalRes = searchData.totalResults;

		int pages = getTotalPages(totalResults);
		System.out.println(getTotalResults());
		SearchServiceImpl searchService = new SearchServiceImpl();
		List<Movie> movieList = searchService.getTotalMovies(url, totalResults);
		movieList = searchService.sortedMovieList(movieList);
		return movieList;
	}

	@Override
	public Movie byId(String id) throws Exception {
		String json = readUrl("http://www.omdbapi.com/?i=" + id + "");
		Gson gson = new Gson();
		Movie movie = gson.fromJson(json, Movie.class);

		if (movie.getPoster().equals("N/A")) {
			movie.setPoster(
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYRwmxOXpyFg-cf2FggW_uOq1iaARHkkXX4D2gNSb0PhQKC6xHJQ");
		}
		return movie;
	}

	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	@Override
	public List<Movie> sortedMovieList(List<Movie> movieList) {
		Collections.sort(movieList, new MovieSortComparator());
		return movieList;
	}

	@Override
	public List<Movie> getTotalMovies(String url, String totalResults) throws Exception {
		int number = Integer.parseInt(totalResults);
		int n = 1;
		int loops = number / 10;
		if (number % 10 > 0) {
			loops += 1;
		}
		List<Movie> movieList = new ArrayList<>();
		while (n <= loops) {
			String movieUrl = url + "&page=" + n + "";
			String json = readUrl(movieUrl);
			Gson gson = new Gson();
			SearchByTitle searchData = gson.fromJson(json, SearchByTitle.class);
			for (Movie m : searchData.Search) {
				if (m.getPoster().equals("N/A")) {
					m.setPoster(
							"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYRwmxOXpyFg-cf2FggW_uOq1iaARHkkXX4D2gNSb0PhQKC6xHJQ");
				}
				if (m.getYear().length() > 4) {
					m.setYear(m.getYear().substring(0, 4));
				}
				movieList.add(m);
			}
			n++;
		}
		return movieList;
	}

	@Override
	public int getTotalPages(String totalRes) {

		int r = Integer.parseInt(totalRes);
		double res = Math.ceil((double) r / 10);
		return (int) res;
	}

	@Override
	public String getTotalResults() {

		return totalRes;
	}

	@Override
	public String getAddedMovieList(int sesId, String movieId) {
		UserDao uDao = new UserDaoImpl();
		return uDao.getAddedMovie(sesId, movieId);
	}

}