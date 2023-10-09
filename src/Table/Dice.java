package Table;

/**
 * Simple class for playing dice.
 * @autor Piven Danila.
 */
public class Dice {
    /**
     * Function for rolling the dice with 6 sides.
     * @return number between 1 and 6.
     */
    static public int rollTheDice(){
        return (int) (Math.random() * 6) + 1;
    }
}
