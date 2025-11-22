package ece325.labs.lab3;

import java.util.ArrayList;

/**
 * Holds all unique songs. If a duplicate is added (same title + instruments-set),
 * we update its AverageRating rather than adding another entry.
 */
public class SongCollection {
    private final ArrayList<Song> songs;

    public SongCollection() {
        this.songs = new ArrayList<>();
    }

    /**
     * Add the song if it is not in the list yet; otherwise update the average rating
     * of the existing entry with the new rating from 'toAdd'.
     */
    public void addOrUpdate(Song toAdd) {
        if (toAdd == null) return;

        // lab hints say ArrayList is used internally.
        int idx = indexOf(toAdd);
        if (idx >= 0) {
            // update average on the existing entry
            Song existing = songs.get(idx);
            float newObs = toAdd.getRating().getAvgRating(); // new observation
            existing.getRating().addRating(newObs);
        } else {
            songs.add(toAdd);
        }
    }

    /**
     * Find index of a song equal to 'target' or -1 if not found.
     */
    private int indexOf(Song target) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
        }
    
    public int getNumberOfSongs() {
        return songs.size();
    }

    public ArrayList<Song> getSongs() {
        return new ArrayList<>(songs); // defensive copy
    }

    @Override
    public String toString() {
        String toRet = "[SongCollection: ";
        for (Song s : songs)
            toRet += "\n\t" + s + "; ";
        return toRet + "\n]";
    }
}
