import Creatures.Monster;
import Creatures.Player;
import Exceptions.WrongValueException;
import Table.PlayingField;

public class Main {
    public static void main(String[] args) throws WrongValueException {
        Player shrek = new Player("Shrek", 10, 6, 3, 6, 20);
        Monster monster1 = new Monster("Dragon", 4, 2, 3, 6, 10);
        Monster monster2 = new Monster("Huge Goose", 4, 2, 3, 6, 10);
        Monster monster3 = new Monster("Stupid Donkey", 4, 2, 3, 6, 10);
        Monster[] monsters = new Monster[] {monster1, monster2, monster3};
        PlayingField.fillTheDungeon(monsters);
        PlayingField.setPlayer(shrek);
        PlayingField.startBattle();
    }
}