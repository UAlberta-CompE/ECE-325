package ece325.labs.lab3;

/**
 * Tracks an average incrementally: store running count and mean.
 */
public class AverageRating {
    private float avgRating;
    private int count;

    public AverageRating(float rating) {
        this.avgRating = rating;
        this.count = 1;
    }

    /**
     * Recomputes the average rating with a new observation r.
     */
    public void addRating(float r) {
        count += 1;
        avgRating = avgRating + (r - avgRating) / count;
    }

    public float getAvgRating() {
        return avgRating;
    }

    @Override
    public String toString() {
        return String.format("[AverageRating: %.3f]", avgRating);
    }
}
