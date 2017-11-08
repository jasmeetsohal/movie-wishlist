package com.wishlist.util;

import java.util.Comparator;

import com.wishlist.model.Movie;

public class MovieSortComparator implements Comparator<Object> {

	@Override
	public int compare(Object obj1, Object obj2) {
		return ((Movie) obj2).getYear().compareTo(((Movie) obj1).getYear());
	}
}
