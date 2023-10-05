import Creatures.Player;
import Exceptions.WrongValueException;

public class Main {
    public static void main(String[] args) throws WrongValueException {
        Player John = new Player("John", 30, 10, 12);
        System.out.println(John);
    }
}