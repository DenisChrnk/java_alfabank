package homework15;

public class BoardGame {
    private String name;
    private int minAge;
    private int coastGamePerDay;
    private boolean isBooked;

    public BoardGame(String name, int minAge, int coastGamePerDay) {
        if(name.isEmpty() || name == null){
            throw new IllegalArgumentException("Название игры не может быть пустым или null");
        }
        if(minAge < 0){
            throw new IllegalArgumentException("Возраст не может быть меньше 0");
        }
        if(coastGamePerDay <= 0){
            throw new IllegalArgumentException("Стоимость аренды не может быть меньше 0");
        }
        this.name = name;
        this.minAge = minAge;
        this.coastGamePerDay = coastGamePerDay;
        this.isBooked = false;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getCoastGamePerDay() {
        return coastGamePerDay;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean canBeRentedBy(int age){
        return age >= minAge;
    }
}
