package task_1;

import java.util.*;


public class WordExtractorFromSong_p1 {
        public static String[] getWordsFromSongLyrics(String lyrics) {
            if (lyrics == null || lyrics.isEmpty()) {
                System.out.println("Cleaned Text: (empty string)");
                return new String[0];
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

            List<String> validWords = new ArrayList<>();
            for (String word : wordsArray) {
                if (!word.isEmpty()) {
                    validWords.add(word);
                }
            }

            return validWords.toArray(new String[0]);
        }

        public static void countAndPrintWordOccurrences(String[] words) {
            if (words == null || words.length == 0) {
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
            String [] words = getWordsFromSongLyrics(beatlesYellowSubmarineLyrics);

            System.out.println("\n--- Word Array (" + words.length + " words): --- " + "\n" + Arrays.toString(words));
            countAndPrintWordOccurrences(words);
        }
}