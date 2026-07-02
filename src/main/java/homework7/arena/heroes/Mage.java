package homework7.arena.heroes;

public class Mage extends Hero{
    private int mana;

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Маг запускает огненный шар!");
    }
}
