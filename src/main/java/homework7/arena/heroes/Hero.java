package homework7.arena.heroes;

public class Hero {
    public String name;
    private int level = 1;
    private int health = 100;
    private final static int MAX_LEVEL = 100;

    static int heroesCreated;

    public Hero(String name) {
        this.name = name;
        heroesCreated++;
    }

    public void printInfo() {
        System.out.println("Имя героя - " + name);
        System.out.println("Уровень - " + level);
        System.out.println("Текущее здоровье - " + health);
    }

    public void takeDamage(int damage) {
        health = health - damage;
        if (health <= 0) {
            health = 0;
        }
    }

    public void levelUp() {
        health = health + 1;
        if (health > MAX_LEVEL) {
            health = MAX_LEVEL;
        }
    }

    public void attack() {
        System.out.println("Герой наносит обычгый удар");
    }

    public void attack(String target) {
        System.out.println("Герой нанаосит обычный удар. Цель: " + target);
    }

    public void attack(String target, int times) {
        System.out.println("Герой аттакует цель " + target + times + " раза");
    }

    public static void printHeroesCreated() {
        System.out.println("Всего создано героев: " + heroesCreated);
    }

    public final void rest() {
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }
}
