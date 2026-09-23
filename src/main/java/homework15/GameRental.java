package homework15;

import java.util.ArrayList;
import java.util.List;

public class GameRental {
    List<BoardGame> catalog = new ArrayList<>();

    public void addGame(BoardGame game) {
        if (game == null) {
            throw new IllegalArgumentException("Игра не может быть null");
        }
        if (findGame(game.getName()) != null) {
            throw new IllegalArgumentException("Игра с этим названием найдена");
        }
        catalog.add(game);
    }

    public BoardGame findGame(String title) {
        for (BoardGame game : catalog) {
            if (game.getName().equalsIgnoreCase(title)) {
                return game;
            }
        }
        return null;
    }

    public boolean rentGame(String name, int customerAge) {
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Игры с таим названием не существует");
        }
        if (game.isBooked() || !game.canBeRentedBy(customerAge)) {
            return false;
        }
        game.setBooked(true);
        return true;
    }

    public boolean returnGame(String name) {
        BoardGame game = findGame(name);
        if (game == null || !game.isBooked()) {
            return false;
        }
        game.setBooked(false);
        return true;
    }

    public int calculateCost(String name, int days) {
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Игры с таим названием не существует");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Количество дней не может быть 0 и меньше 0");
        }
        return game.getCoastGamePerDay() * days;
    }

    public void reset() {
        for (BoardGame game : catalog) {
            game.setBooked(false);
        }
    }
}
