package homework11;

public class CoffeeMachine {
    public void makeCoffee(int amountOfWater){
        if (amountOfWater <= 200){
            throw new NotEnoughWaterException("Недостаточно воды");
        } else {
            System.out.println("Кофе приготовлен");}
        }

        public void calculateCups(int amountOfWater, int cupCapacity){
        int numberOfCups = amountOfWater/cupCapacity;
            System.out.println("Можно приготовить " + numberOfCups + " чашек кофе");
        }

        public void printCoffeeName(String coffeeName){
        String upperCoffeeName = coffeeName.toUpperCase();
            System.out.println(upperCoffeeName);
        }
    }