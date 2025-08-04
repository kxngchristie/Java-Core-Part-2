package task_1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordExtractorFromSong_p4 {
    public static class BeatlesException extends Exception {
        public BeatlesException(String message, Throwable cause) {
            super("Beatles: " + message, cause);
        }
    }

    public static void saveLyricsToFile(String lyrics, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Path parentDirectory = path.getParent();
            if (parentDirectory != null) {
                Files.createDirectories(parentDirectory);
            }
            Files.writeString(path, lyrics, StandardCharsets.UTF_8);
            System.out.println("Lyrics successfully saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving lyrics to file: " + e.getMessage());
        }
    }

    public static String readSongFromFile(String filePath) throws BeatlesException {
        Path path = Paths.get(filePath);
        try{
            String content = Files.readString(path, StandardCharsets.UTF_8);
            System.out.println("Song Successfully read from: " + filePath);
            System.out.println();
            return content;
        } catch (IOException e) {
            throw new BeatlesException("Failed to read song from file", e);
        }
    }

    public static List<String> getWordsFromSongLyrics(String lyrics) {
        if (lyrics == null || lyrics.isEmpty()) {
            System.out.println("Error, Cleaned Text: (empty string)");
            return new ArrayList<>();
        }

        // Replacing commas and newlines with a single space.
        String tempCleanedLyrics = lyrics.replaceAll("[^a-zA-Z0-9'-]+", " ");
        // Converting the Entire String to Lowercase.
        String lowercasedLyrics = tempCleanedLyrics.toLowerCase();
        // Trim leading/trailing whitespace before the final split.
        String finalCleanedText = lowercasedLyrics.trim();
        System.out.println("--- Cleaned Text: --- \n\"" + finalCleanedText + "\"");
        // Splitting the string by one or more whitespace characters, and also Using .trim() before splitting
        // handles any leading/trailing spaces that might result.
        String[] wordsArray = finalCleanedText.split("\\s+");

        List<String> wordList = new ArrayList<>();
        for (String word : wordsArray) {
            if (!word.isEmpty()) {
                wordList.add(word);
            }
        }
        return wordList;
    }

    public static void countAndPrintWordOccurrences(List<String> words) {
        if (words == null || words.isEmpty()) {
            System.out.println("\nError, No words to count.");
            return;
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n--- Word Counts: ---");
        Map<String, Integer> sortedWordCounts = new TreeMap<>(wordCounts);
        for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"" + ": " + entry.getValue());
        }
    }

    public static void sortAndPrintWordsByLength(List<String> words) {
        if (words == null || words.isEmpty()) {
            System.out.println("\nError, No words to sort by length.");
            return;
        }

        List<String> sortedWords = new ArrayList<>(words);

        sortedWords.sort(Comparator.comparingInt(String::length));

        // Checking If words have the same length, then sort them alphabetically.
        sortedWords.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        System.out.println("\n--- Words Sorted by Length (" + sortedWords.size() + " words): ---");
        System.out.println(sortedWords);
    }

    public static void removeSpecificWordsFromList(List<String> words, String... wordsToRemove) {
        if (words == null || words.isEmpty() || wordsToRemove == null || wordsToRemove.length == 0) {
            System.out.println("\ncannot remove words: input list is empty or words to remove not specified.");
            return;
        }

        // For efficient lookup during removal, put words to remove into a HashSet
        Set<String> wordsToRemoveSet = new HashSet<>(Arrays.asList(wordsToRemove));

        words.removeIf(wordsToRemoveSet::contains);
        System.out.println("\n--- Words \"yellow\" and \"submarine\" removed. ---");
    }

    public static void CheckSpecificString(String lyrics, String specificString) throws BeatlesException {
        if (lyrics == null || lyrics.isEmpty()) {
            throw new BeatlesException("Lyrics are empty or null, cannot check for a specific string.", null);
        }
        String lowercasedLyrics = lyrics.toLowerCase();
        if (lowercasedLyrics.contains(specificString.toLowerCase())) {
            System.out.println("\nSUCCESS: The specific string \"" + specificString + "\" is present in the lyrics.");
        } else {
            throw new BeatlesException("The specific string \"" + specificString + "\" was not found in the song text.", null);
        }
    }


    public static void main(String[] args) {
        String beatlesYellowSubmarineLyrics = """
                \
                    In the town where I was born
                    Lived a man who sailed to sea
                    And he told us of his life
                    In the land of submarines
                    So we sailed on to the sun
                    'Til we found a sea of green
                    And we lived beneath the waves
                    In our yellow submarine
                
                    We all live in a yellow submarine
                    Yellow submarine, yellow submarine
                    We all live in a yellow submarine
                    Yellow submarine, yellow submarine
                
                    And our friends are all aboard
                    Many more of them live next door
                    And the band begins to play
                
                    We all live in a yellow submarine
                    Yellow submarine, yellow submarine
                    We all live in a yellow submarine
                    Yellow submarine, yellow submarine
                
                    Full steam ahead, Mister Boatswain, full steam ahead
                    Full steam ahead it is, Sergeant
                    (Cut the cable, drop the cable)
                    Aye-aye, sir, aye-aye
                    Captain, captain
                
                    As we live a life of ease (a life of ease)
                    Every one of us (every one of us)
                    Has all we need (has all we need)
                    Sky of blue (sky of blue)
                    And sea of green (sea of green)
                    In our yellow (in our yellow)
                    Submarine (submarine, aha)
                
                    We all live in a yellow submarine
                    A yellow submarine, yellow submarine
                    We all live in a yellow submarine
                    A yellow submarine, yellow submarine
                    We all live in a yellow submarine
                    Yellow submarine, yellow submarine
                    We all live in a yellow submarine
                    Yellow submarine, yellow submarine
                """;

        String fileName = "output/lyrics/beatles_yellow_submarine_lyrics.txt";
        saveLyricsToFile(beatlesYellowSubmarineLyrics, fileName);

        System.out.println("\n--- Starting Word Processing from File ---");

        String songContent;
        try {
            songContent = readSongFromFile(fileName);
        } catch (BeatlesException e) {
            System.err.println("A Custom BeatlesException was caught:");
            System.err.println("Message: " + e.getMessage());
            System.err.println("Caused by: " + e.getCause());
            e.printStackTrace();
            return;
        }

        System.out.println("--- Original Lyrics of the Song (Read from file): ---\n" + songContent);
        List<String> words = getWordsFromSongLyrics(songContent);

        System.out.println("\n--- Word List (BEFORE Removal (" + words.size() + " words): --- " + "\n" + words);

        removeSpecificWordsFromList(words, "yellow", "submarine");

        System.out.println("\n--- Word List (AFTER Removal (" + words.size() + " words): --- " + "\n" + words);

        TreeSet<String> uniqueWords = new TreeSet<>(words);
        System.out.println("\n--- Unique Words (" + uniqueWords.size() + " words): --- " + "\n" + uniqueWords);

        countAndPrintWordOccurrences(words);

        sortAndPrintWordsByLength(words);

        // Case 1: The specific string is present
        try {
            CheckSpecificString(songContent, "In the town where I was born");
        } catch (BeatlesException e) {
            System.err.println("\n--- Caught UNEXPECTED BeatlesException ---");
            e.printStackTrace();
        }

        // Case 2: The specific string is not present
        try {
            CheckSpecificString(songContent, "Show must go on!");
        } catch (BeatlesException e) {
            System.err.println("\n--- Caught EXPECTED BeatlesException ---");
            e.printStackTrace();
        }
    }
}