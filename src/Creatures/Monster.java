package Creatures;

import Exceptions.WrongValueException;

/**
 * Extended Creature class implementing specific functions for monster.
 * @autor Piven Danila.
 */
public class Monster extends Creature{
    public Monster(String name, int attack, int defence, int min_damage, int max_damage, int health)
            throws WrongValueException {
        super(name, attack, defence, min_damage, max_damage, health);
    }

    @Override
    protected void healthIsOver(){
        alive = false;
    }

    @Override
    public String toString() {
        return String.format("Monster %s had %d point of attack, %d points of defence," +
                        " %d point of health and attack in range (%d, %d).",
                getName(), getAttack(), getDefence(), getHealth(), getDamage()[0], getDamage()[1]);
    }
}
