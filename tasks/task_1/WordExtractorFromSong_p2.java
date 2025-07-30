package task_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordExtractorFromSong_p2 {
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
        String[] wordsArray = lowercasedLyrics.trim().split("\\s+");

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
            System.out.println("Error, No words to count.");
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
            System.out.println("Error, No words to sort by length.");
            return;
        }

        List<String> sortedWords = new ArrayList<>(words);

        sortedWords.sort(Comparator.comparingInt(String::length));

        // Checking If words have the same length, then sort them alphabetically.
        sortedWords.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        System.out.println("\n--- Words Sorted by Length (" + sortedWords.size() + " words): ---");
        System.out.println(sortedWords);
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

        System.out.println("--- Original Lyrics of the Song: ---\n" + beatlesYellowSubmarineLyrics);
        List<String> words = getWordsFromSongLyrics(beatlesYellowSubmarineLyrics);

        System.out.println("\n--- Word List (" + words.size() + " words): --- " + "\n" + words);

        TreeSet<String> uniqueWords = new TreeSet<>(words);
        System.out.println("\n--- Unique Words (" + uniqueWords.size() + " words): --- " + "\n" + uniqueWords);

        countAndPrintWordOccurrences(words);

        sortAndPrintWordsByLength(words);
    }
}