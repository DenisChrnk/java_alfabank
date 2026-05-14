package homework6.model;

public class ExpressParcel extends Parcel{

    private int deliveryHours;

    public ExpressParcel(String recipientName, String deliveryAddress, double parcelWeight, String trackNumber, int deliveryHours) {
        super(recipientName, deliveryAddress, parcelWeight, trackNumber);
        this.deliveryHours = deliveryHours;
    }

    @Override
    public double calculateDeliveryPrice() {
        if(deliveryHours < 24){
            return super.calculateDeliveryPrice() + 500;
        } else {
            return super.calculateDeliveryPrice();
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Delivery deadline: " + deliveryHours);
    }
}