package homework6.model;

public class FragileParcel extends Parcel{

    private boolean requiresCarefulHandling;

    public FragileParcel(String recipientName, String deliveryAddress, double parcelWeight, String trackNumber, boolean requiresCarefulHandling) {
        super(recipientName, deliveryAddress, parcelWeight, trackNumber);
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    @Override
    public double calculateDeliveryPrice() {
        return super.calculateDeliveryPrice() + 200;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Handle with care: " + requiresCarefulHandling);
    }
}
