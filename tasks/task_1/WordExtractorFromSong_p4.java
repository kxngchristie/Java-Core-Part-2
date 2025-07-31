package task_1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordExtractorFromSong_p4 {
    public static void saveLyricsToFile(String lyrics, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Path parentDirectory = path.getParent();
            if (parentDirectory != null) {
                Files.createDirectories(parentDirectory);
            }
            Files.writeString(path, lyrics, StandardCharsets.UTF_8);
            System.out.println("Lyrics successfully saved to: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving lyrics to file: " + e.getMessage());
            e.printStackTrace();
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

        String relativeFilePath = Paths.get("output", "lyrics", "beatles_yellow_submarine_lyrics.txt").toString();
        saveLyricsToFile(beatlesYellowSubmarineLyrics, relativeFilePath);
    }
}