package ece325.labs.lab4;

/** 
 * Finish this class.
 */
public class AverageRating {
	// not allowed to change anything after this (until the next marker which says you can add code again)
	private float avgRating;
	private int votes;
	
	public AverageRating(float rating, int votes) {
		this.avgRating = rating;
		this.votes = votes;
	}
		
	public float getAvgRating() {
		return avgRating;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public String toString() {
		return "[AverageRating: " + avgRating + ", votes: " + votes + "]";
	}

	// You are allowed to make changes or add code after this line

	// compare two ratings: higher average first, then by votes
	public int compareTo(AverageRating other) {
		if (other == null) {
			return 1;
		}
		int cmp = Float.compare(this.avgRating, other.avgRating);
		if (cmp == 0) {
			cmp = Integer.compare(this.votes, other.votes);
		}
		return cmp;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AverageRating)) {
			return false;
		}
		AverageRating other = (AverageRating) obj;
		return Float.compare(this.avgRating, other.avgRating) == 0 && this.votes == other.votes;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + Float.hashCode(avgRating); // standard formula used in Java for computing hash codes
		result = 31 * result + votes;
		return result;
	}
}
