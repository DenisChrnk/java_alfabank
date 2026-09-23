package homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardGameTest {

    @Test
    public void createBoardGameWithValidDataTest(){
        BoardGame boardGame = new BoardGame("Monopoly", 12, 10);

        Assertions.assertEquals("Monopoly", boardGame.getName());
        Assertions.assertEquals(12, boardGame.getMinAge());
        Assertions.assertEquals(10, boardGame.getCoastGamePerDay());
    }

    @Test
    public void createBoardGameWhenNameIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BoardGame(null, 12, 10));
    }

    @Test
    public void createBoardGameWithEmptyName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BoardGame("", 12, 10));
    }

    @Test
    public void createBoardGameWithAgeLessZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BoardGame("Monopoly", -1, 10));
    }

    @Test
    public void createBoardGameWithRentPriceZeroAndLessZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BoardGame("Monopoly", 1, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BoardGame("Monopoly", 1, -1));
    }

    @Test
    public void canBeRentedByTest(){
        BoardGame boardGame = new BoardGame("UNO", 6, 10);

        Assertions.assertTrue(boardGame.canBeRentedBy(6));
        Assertions.assertTrue(boardGame.canBeRentedBy(7));
        Assertions.assertFalse(boardGame.canBeRentedBy(5));
    }
}
