package task_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEmailExtractor_p3 {
    public static String getUserEmail(String inputString) {
        if (inputString == null) {
            return null;
        }

        Pattern pattern = Pattern.compile("\\((.*)\\)");

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            // matcher.group(0) is the entire matched string
            // return matcher.group(0);
            // matcher.group(1) is the content of the first capturing group, which is the UUID value.
            return matcher.group(1);
        }
        return null;
    }

    public static void main(String[] args) {
        String text = "test 2667843 (test_email@griddynamics.com) test 67483 some string";

        String email = getUserEmail(text);

        if (email != null) {
            System.out.println("found and returned the User Email: " + email);
        } else {
            System.out.println("Could not find the User Email.");
        }
    }
}