package task_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSubStringCheckerTF_p1 {
    // Case Sensitive Pattern to match "orderUUID"
    private static final Pattern ORDER_UUID_PATTERN = Pattern.compile("orderUUID");

    // Case Insensitive Pattern to match "orderUUID"
    // private static final Pattern ORDER_UUID_PATTERN = Pattern.compile("orderUUID", Pattern.CASE_INSENSITIVE);

    public static boolean containsOrderUUIDWithRegex(String inputString) {
        if (inputString == null) {
            return false;
        }
        Matcher matcher = ORDER_UUID_PATTERN.matcher(inputString);
        return matcher.find();
    }

    public static void main(String[] args) {
        String text = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient " +
                "- action=EDIOrderSent originalFilename=Integration_test_Contract " +
                "customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 " +
                "poNum=Test_TS5155079515 lineCount=3";

        System.out.println("Text Contains 'orderUUID': " + containsOrderUUIDWithRegex(text));
    }
}