package Creatures;

import Exceptions.WrongValueException;

public class Player extends Creature{
    public Player(String name, int attack, int defence, int health) throws WrongValueException {
        setName(name);
        setAttack(attack);
        setDefence(defence);
        setHealth(health);
    }

    @Override
    public String toString() {
        return String.format("Player %s had %d point of attack, %d points of defence, %d point of health",
                getName(), getAttack(), getDefence(), getHealth());
    }
}
