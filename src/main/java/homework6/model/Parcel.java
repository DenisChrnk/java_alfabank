package homework6.model;

public class Parcel {

    private String recipientName;
    private String deliveryAddress;
    protected double parcelWeight;
    String trackNumber;

    public Parcel(String recipientName, String deliveryAddress, double parcelWeight, String trackNumber) {
        this.recipientName = recipientName;
        this.deliveryAddress = deliveryAddress;
        this.parcelWeight = parcelWeight;
        this.trackNumber = trackNumber;
    }

    public Parcel() {
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(double parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public double calculateDeliveryPrice(){
        return 100 + parcelWeight * 30;
    }

    public void printInfo(){
        System.out.println("Имя получателя: " + recipientName);
        System.out.println("Адрес доставки: " + deliveryAddress);
        System.out.println("Вес посылки: " + parcelWeight);
        System.out.println("Трек-номер: " + trackNumber);
    }


}
