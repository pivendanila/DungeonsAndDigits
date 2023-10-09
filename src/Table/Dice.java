package Table;

public class Dice {
    static public int rollTheDice(){
        return (int) (Math.random() * 6) + 1;
    }
}
