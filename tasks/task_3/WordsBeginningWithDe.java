package task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsBeginningWithDe {

    public static List<String> findWordsBeginningWithDe(String text) {
        if (text == null || text.isEmpty()) {
            return new ArrayList<>();
        }

        Pattern pattern = Pattern.compile("\\b[dD][eE]\\w*\\b");

        Matcher matcher = pattern.matcher(text);

        List<String> wordsFound = new ArrayList<>();
        while(matcher.find()) {
            wordsFound.add(matcher.group());
        }
        return wordsFound;
    }

    public static void main(String[] args) {
        String testForSearch = """
                When you first start to evaluate a cloud \
                migration, the decisions to be made, stakeholders who need to be \
                involved, it can sometimes feel overwhelming – and with good reason. A \
                move to the cloud can take time, resources, and manpower, and while \
                companies are nearly universally glad they made those investments, \
                that doesn't cancel out the fact that they take strategic planning and \
                up-front work.
                What do you need to plan for? Who needs to be involved (and \
                when)? What roles and responsibilities need to be divided up? The \
                answers vary a bit depending on your company size, the scope of your \
                migration, and whether you have the budget (or need) for a migration \
                partner
                Below are the typical roles and responsibilities we see from \
                successful migrations – and some tips to prepare your team for \
                success. Because without the right team in place, missed deadlines, \
                duplicative work, and post-migration workflow issues become much \
                greater risks.""";

        List<String> words = findWordsBeginningWithDe(testForSearch);
        System.out.println("Words found beginning with 'de':");

        for (String word : words) {
            System.out.println(word);
        }
    }
}