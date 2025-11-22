package ece325.labs.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Represents one unique song (title + instruments-set), tracking its AverageRating.
 * Two Song objects are considered equal if and only if:
 *   - titles match exactly, and
 *   - the multiset of instruments matches regardless of order (e.g., [Guitar,Guitar,Mic]
 *     equals [Guitar,Mic,Guitar]).
 */
public class Song {
	// final so once the variable is assigned (inside the constructor), you can’t reassign it later
    private final String title;
    private final ArrayList<String> instruments;   // kept sorted internally
    private final AverageRating averageRating;

    /**
     * Constructs a Song. Instruments are copied and sorted so equals()/hashCode() are stable.
     */
    public Song(String title, ArrayList<String> instruments, AverageRating rating) {
        if (title == null || instruments == null || rating == null) {
            throw new IllegalArgumentException("Song fields cannot be null");
        }
        this.title = title;
        this.instruments = new ArrayList<>(instruments);
        Collections.sort(this.instruments); // order-insensitive so normalize by sort
        this.averageRating = rating;
    }

    /**
     * Overload for convenience: equality by Song.
     */
    public boolean equals(Song other) {
        if (other == null) return false;
        return this.title.equals(other.title) && this.instruments.equals(other.instruments);
    }

    /**
     * Required override for use in collections and lookups.
     * Must match equals(Song) behavior.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song other = (Song) o;
        return this.title.equals(other.title) && this.instruments.equals(other.instruments);
    }

    /**
     * Hash matches the normalized (sorted) instruments + title.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, instruments);
    }

    public ArrayList<String> getInstruments() {
        return new ArrayList<>(instruments); // defensive copy
    }

    public AverageRating getRating() {
        return averageRating;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "[Song: " + title + ", instruments: " + instruments + ", avg. rating: " + averageRating + "]";
    }
}
