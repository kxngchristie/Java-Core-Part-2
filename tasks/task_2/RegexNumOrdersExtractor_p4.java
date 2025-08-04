package task_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexNumOrdersExtractor_p4 {
    public static String getNumberOfOrders(String inputString) {
        if (inputString == null) {
            return null;
        }

        Pattern pattern = Pattern.compile("total number of orders successfully processed: \\[([0-9]+)]");

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
        String text = "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 " +
                "poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: " +
                "[Integration_test_Contract], total number of orders successfully processed: [2]";

        String numorders = getNumberOfOrders(text);

        if (numorders != null) {
            System.out.println("found and returned the Total Number of Orders: " + numorders);
        } else {
            System.out.println("Could not find the Total Number of Orders.");
        }
    }
}
