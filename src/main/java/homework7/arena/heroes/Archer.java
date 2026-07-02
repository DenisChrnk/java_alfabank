package homework7.arena.heroes;

public class Archer extends Hero{
    private int arrowsCount;

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Лучник выпускает стрелу!");
    }
}
