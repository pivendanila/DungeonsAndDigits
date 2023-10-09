package Creatures;

import Exceptions.WrongValueException;

public class Player extends Creature{

    private int revive_counter;

    public Player(String name, int attack, int defence, int min_damage, int max_damage, int health)
            throws WrongValueException {
        super(name, attack, defence, min_damage, max_damage, health);
        this.revive_counter = 0;
    }
    @Override
    protected void healthIsOver(){
        if(this.revive_counter<4) {
            this.current_health = (int) (this.health_value * 0.3);
            this.revive_counter += 1;
        }
        else{
            alive = false;
        }
    }

    @Override
    public String toString() {
        return String.format("Player %s had %d point of attack, %d points of defence," +
                        " %d point of health and attack in range (%d, %d).",
                getName(), getAttack(), getDefence(), getHealth(), getDamage()[0], getDamage()[1]);
    }
}
