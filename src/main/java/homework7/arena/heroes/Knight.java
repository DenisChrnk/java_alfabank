package homework7.arena.heroes;

public class Knight extends Hero {
    private int armor;

    public Knight(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Рыцарь бьет мечом!");
        ;
    }

//    @Override
//    public final void rest() {
//        System.out.println("Герой решил отдыхнуть и восстановить силы.");
//    }


    @Override
    public String toString() {
        return "Knight{" +
                "name=" + name +
                '}';
    }
}
