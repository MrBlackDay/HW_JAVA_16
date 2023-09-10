package hw_java_16;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок с именем " + playerName + " несуществует");
    }
}
