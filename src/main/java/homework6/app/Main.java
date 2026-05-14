package homework6.app;

import homework6.model.ExpressParcel;
import homework6.model.FragileParcel;
import homework6.model.Parcel;
import homework6.service.ParcelService;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    static void main() {
        // Устанавливаем UTF-8 для стандартного вывода (System.out)
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        // Устанавливаем UTF-8 для вывода ошибок (System.err)
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8));

        Parcel parcel = new Parcel("Анна", "Москва", 123.3, "111");
        FragileParcel fragileParcel = new FragileParcel("Сергей", "Уфа", 234.4, "222", true);
        ExpressParcel expressParcel = new ExpressParcel("Боб", "Ялта", 345.5, "333", 12);
        Parcel parcelWithoutConstructor = new Parcel();

        Parcel [] parcels = {parcel, fragileParcel, expressParcel, parcelWithoutConstructor};

        ParcelService parcelService = new ParcelService();
        parcelService.printParcelsReport(parcels);
    }
}
