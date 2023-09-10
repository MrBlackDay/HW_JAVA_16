import hw_java_16.Game;
import hw_java_16.NotRegisteredException;
import hw_java_16.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {
    //Первый игрок побеждает
    @Test
    public void playerOneWin() {
        Player playerOne = new Player(3, "PlayerOne", 56);
        Player playerTwo = new Player(5, "PlayerTwo", 51);

        Game game = new Game();

        game.register(playerOne);
        game.register(playerTwo);

        int actual = game.round("PlayerOne", "PlayerTwo");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    //Второй игрок побеждает
    @Test
    public void playerTwoWin() {
        Player playerOne = new Player(3, "PlayerOne", 46);
        Player playerTwo = new Player(5, "PlayerTwo", 51);

        Game game = new Game();

        game.register(playerOne);
        game.register(playerTwo);

        int actual = game.round("PlayerOne", "PlayerTwo");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    //Ничья между двумя игроками
    @Test
    public void NoPlayerWin() {
        Player playerOne = new Player(3, "PlayerOne", 46);
        Player playerTwo = new Player(5, "PlayerTwo", 46);

        Game game = new Game();

        game.register(playerOne);
        game.register(playerTwo);

        int actual = game.round("PlayerOne", "PlayerTwo");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }


    //Первый игрок не добавлен
    @Test
    public void NotExceptionPlayerOne() {
        Player playerOne = new Player(3, "PlayerOne", 46);
        Player playerTwo = new Player(5, "PlayerTwo", 46);

        Game game = new Game();

        game.register(playerOne);
        game.register(playerTwo);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("PlayerSix", "PlayerTwo"));
    }

    //Второй игрок не добавлен
    @Test
    public void NotExceptionPlayerTwo() {
        Player playerOne = new Player(3, "PlayerOne", 46);
        Player playerTwo = new Player(5, "PlayerTwo", 46);

        Game game = new Game();

        game.register(playerOne);
        game.register(playerTwo);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("PlayerOne", "PlayerSix"));
    }

}
