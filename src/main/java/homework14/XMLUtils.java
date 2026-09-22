package homework14;

public class XMLUtils {

    public static String createEmptyElement(String tagName) {
        if (tagName.isEmpty() || tagName.equals("")) {
            return "<invalid/";
        }
        return "<" + tagName + ">" + "</" + tagName + ">";
    }
}
