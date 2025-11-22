package ece325.labs.lab4;

import java.util.Comparator;

public class SongComparator implements Comparator<Song> {

	@Override
	public int compare(Song s1, Song s2) {
		if (s1 == null && s2 == null) {
            return 0;
		}
		if (s1 == null) {
			return 1;
		}
		if (s2 == null) {
			return -1;
		}

		// primary: average rating (descending)
		int cmp = Float.compare(s2.getAverageRating().getAvgRating(), s1.getAverageRating().getAvgRating());
		if (cmp != 0) {
            return cmp;
        }

		// secondary: votes (descending)
		cmp = Integer.compare(s2.getAverageRating().getVotes(), s1.getAverageRating().getVotes());
		if (cmp != 0) {
            return cmp;
        }

		// tertiary: title (alphabetical)
		if (s1.getTitle() == null && s2.getTitle() == null) {
            return 0;
        }
		if (s1.getTitle() == null) {
            return 1;
        }
		if (s2.getTitle() == null) {
            return -1;
        }
		return s1.getTitle().compareToIgnoreCase(s2.getTitle());
	}
}
