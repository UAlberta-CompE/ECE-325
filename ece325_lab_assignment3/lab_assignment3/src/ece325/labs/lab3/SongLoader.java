package ece325.labs.lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Loads songs from a ratings file into a SongCollection.
 * File format (CSV-ish with semicolons):
 *   Title ; Instrument1,Instrument2,... ; rating
 *
 * Example rows (provided):
 *   Contribution;Guitar,Guitar,Drums;4.5
 *   Nobody's Coder;Mic,Drums,Mic;10
 */
public class SongLoader {
    /**
     * Load a SongCollection from a file. Uses readers to parse the file line by line,
     * create Song objects, and insert them into a SongCollection.
     */
    public static SongCollection loadSongs(String filename) {
        SongCollection collection = new SongCollection();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;

                // Expect exactly 3 parts: title ; instruments ; rating
                String[] parts = line.split(";");
                if (parts.length != 3) {
                    // could throw InvalidSongFormatException, but the lab says you may assume valid CSV
                    throw new RuntimeException("Invalid format at line " + lineNo + ": " + line);
                }

                String title = parts[0].trim();
                String instrumentsCsv = parts[1].trim();
                String ratingStr = parts[2].trim();

                ArrayList<String> instruments = parseInstrumentsList(instrumentsCsv);
                float rating = Float.parseFloat(ratingStr);

                // Build a 'single-observation' Song (AverageRating initialized with one rating)
                AverageRating avg = new AverageRating(rating);
                Song song = new Song(title, instruments, avg);

                // Insert or update average if duplicate key exists
                collection.addOrUpdate(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return collection;
    }

    /**
     * Parses a comma-separated list of instruments into an ArrayList<String>.
     * Can assume valid CSV lines so we keep this simple:
     * - Trim each token
     * - Keep duplicates (e.g., "Guitar,Guitar,Mic")
     */
    public static ArrayList<String> parseInstrumentsList(String instruments) {
        ArrayList<String> list = new ArrayList<>();
        if (instruments == null || instruments.trim().isEmpty()) return list;

        String[] tokens = instruments.split(",");
        for (String tok : tokens) {
            String inst = tok.trim();
            if (!inst.isEmpty()) {
                list.add(inst);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String file = "songratings.txt";
        System.out.println(SongLoader.loadSongs(file));
    }
}
