package homework15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameRentalTest {
    private GameRental rental;
    private BoardGame game;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        game = new BoardGame("UNO", 8, 300);
    }

    @Test
    void shouldAddGameAndFindIt() {
        rental.addGame(game);
        BoardGame found = rental.findGame("UNO");
        assertNotNull(found);
        assertEquals("UNO", found.getName());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullGame() {
        assertThrows(IllegalArgumentException.class, () -> rental.addGame(null));
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateGame() {
        rental.addGame(game);
        BoardGame duplicate = new BoardGame("UNO", 12, 400);
        assertThrows(IllegalArgumentException.class, () -> rental.addGame(duplicate));
    }

    @Test
    void shouldReturnNullWhenGameNotFound() {
        assertNull(rental.findGame("Pig"));
    }

    @Test
    void shouldRentGameSuccessfully() {
        rental.addGame(game);
        boolean result = rental.rentGame("UNO", 10);
        assertTrue(result);
        assertTrue(game.isBooked());
    }

    @Test
    void shouldFailRentWhenCustomerTooYoung() {
        rental.addGame(game); // minAge = 8
        boolean result = rental.rentGame("UNO", 6);
        assertFalse(result);
        assertFalse(game.isBooked());
    }

    @Test
    void shouldFailRentWhenAlreadyRented() {
        rental.addGame(game);
        rental.rentGame("UNO", 10);

        boolean secondRent = rental.rentGame("UNO", 12);
        assertFalse(secondRent);
    }

    @Test
    void shouldThrowExceptionWhenRentingNonExistentGame() {
        assertThrows(IllegalArgumentException.class, () -> rental.rentGame("Munchkin", 10));
    }

    @Test
    void shouldReturnGameSuccessfully() {
        rental.addGame(game);
        rental.rentGame("UNO", 10);

        boolean returned = rental.returnGame("UNO");
        assertTrue(returned);
        assertFalse(game.isBooked());
    }

    @Test
    void shouldFailReturnWhenNotRentedOrNotExists() {
        assertFalse(rental.returnGame("Munchkin")); // Не существует

        rental.addGame(game);
        assertFalse(rental.returnGame("UNO")); // Не была арендована
    }

    @Test
    void shouldCalculateCostCorrectly() {
        rental.addGame(game); // cost = 300
        int cost = rental.calculateCost("UNO", 4);
        assertEquals(1200, cost);
    }

    @Test
    void shouldThrowExceptionWhenCalculatingCostForInvalidParams() {
        rental.addGame(game);
        assertThrows(IllegalArgumentException.class, () -> rental.calculateCost("Munchkin", 3));
        assertThrows(IllegalArgumentException.class, () -> rental.calculateCost("UNO", 0));
        assertThrows(IllegalArgumentException.class, () -> rental.calculateCost("UNO", -2));
    }

    @Test
    void shouldResetAllGamesToAvailable() {
        rental.addGame(game);
        BoardGame game2 = new BoardGame("Monopoly", 6, 200);
        rental.addGame(game2);

        rental.rentGame("UNO", 10);
        rental.rentGame("Monopoly", 10);

        rental.reset();

        assertFalse(game.isBooked());
        assertFalse(game2.isBooked());
    }
}
