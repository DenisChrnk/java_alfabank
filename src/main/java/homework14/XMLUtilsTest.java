package homework14;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLUtilsTest {
    @Test
    public void positiveTest() {
        String result = XMLUtils.createEmptyElement("user");

        assertEquals("<user></user>", result, "Ожидали получить <user></user>, а получили " + result);
    }

    @Test
    public void negativeTest() {
        String result = XMLUtils.createEmptyElement("");

        assertEquals("<invalid/", result, "Ожидали получить \"<invalid/\", а получили " + result);
    }
}

