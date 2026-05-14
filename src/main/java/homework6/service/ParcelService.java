package homework6.service;

import homework6.model.Parcel;

public class ParcelService {

    public void printParcelsReport(Parcel [] parcels){
        for (Parcel parcel: parcels){
            parcel.printInfo();
            System.out.println(parcel.calculateDeliveryPrice());
            System.out.println("");
        }
    }
}
