package task_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSubStringExtractor_p2 {
    public static String getOrderUUID(String inputString) {
        if (inputString == null) {
            return null;
        }

        Pattern pattern = Pattern.compile("orderUUID=(\\S+)");

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            // matcher.group(0) is the entire matched string.
            // return matcher.group(0);
            // matcher.group(1) is the content of the first capturing group, which is the UUID value.
            return matcher.group(1);
        }
        return null;
    }

    public static void main(String[] args) {
        String text = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient " +
                "- action=EDIOrderSent originalFilename=Integration_test_Contract " +
                "customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 " +
                "poNum=Test_TS5155079515 lineCount=3";

        String uuid = getOrderUUID(text);

        if (uuid != null) {
            System.out.println("found and returned the UUID: " + uuid);
        } else {
            System.out.println("Could not find the orderUUID.");
        }
    }
}