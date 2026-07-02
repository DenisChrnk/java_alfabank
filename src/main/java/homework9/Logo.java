package homework9;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logo {
    public static List<String> randomLastName = new ArrayList<>();

    public static void main() throws IOException {
        Faker faker = new Faker();

        randomLastName.add("Ivanov");
        randomLastName.add("Petrov");
        randomLastName.add("Smirnov");
        randomLastName.add("Shitov");

        String string1 = getRandomLastName();
        String string2 = "&";
        String string3 = faker.name().lastName();

        printLogo(string1);
        printLogo(string2);
        printLogo(string3);

        System.out.println();

        //Генерация данных для юр.лица
        String fullName = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String address = faker.address().fullAddress();

        System.out.println(fullName);
        System.out.println(phone);
        System.out.println(address);
    }

    private static String getRandomLastName() {
        Random random = new Random();
        int index = random.nextInt(randomLastName.size());
        return randomLastName.get(index);
    }

    private static void printLogo(String txt) throws IOException {
        String ascii = FigletFont.convertOneLine(txt);
        System.out.println(ascii);
    }
}
