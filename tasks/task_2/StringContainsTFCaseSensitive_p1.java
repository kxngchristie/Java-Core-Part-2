package task_2;

public class StringContainsTFCaseSensitive_p1 {
    public static boolean containsOrderUUID(String inputString) {
        return inputString.contains("orderUUID");
    }

    public static void main(String[] args) {
        String text = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient " +
                "- action=EDIOrderSent originalFilename=Integration_test_Contract " +
                "customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 " +
                "poNum=Test_TS5155079515 lineCount=3";

        System.out.println("Text Contains 'orderUUID': " + containsOrderUUID(text));
    }
}