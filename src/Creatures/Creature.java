package Creatures;

import Exceptions.WrongValueException;
import Table.Dice;

/**
 * Parent Creature class with all base functions of Players and Monsters.
 * @autor Piven Danila.
 */
public abstract class Creature {
    private int attack;
    private int defence;
    private int[] damage = new int[2];
    protected int health_value;
    protected int current_health;
    private String name;
    protected boolean alive = true;

    public Creature(String name, int attack, int defence, int min_damage, int max_damage, int health)
            throws WrongValueException {
        setName(name);
        setAttack(attack);
        setDefence(defence);
        setDamage(min_damage, max_damage);
        setHealth(health);
    }

    /**
     * Attack function for all Creatures.
     * @param enemy will take damage.
     * @return String that will be showed in concole.
     */
    public String attack(Creature enemy){
        int attack_modificator = this.getAttack() - enemy.getDefence() + 1;
        boolean attack_success = false;

        if(Dice.rollTheDice()>4){
            attack_success = true;
        }

        for(int i=0; i<attack_modificator-1; i++){
            if(Dice.rollTheDice()>4){
                attack_success = true;
                break;
            }
        }

        int range = this.damage[1] - this.damage[0];
        int current_damage = (int) (Math.random() * range + this.damage[0]);

        if(attack_success) enemy.takeDamage(current_damage);
        return String.format("%s dealt %d point of damage to %s", getName(), current_damage, enemy.getName());
    }

    /**
     * Function for damaging Creature.
     * @param current_damage is value of damage that Creature takes.
     */
    public void takeDamage(int current_damage){
        this.current_health=this.current_health-current_damage;
        if (this.current_health<1){
            this.healthIsOver();
        }
    }

    /**
     * Function for changing Creature alive field to false.
     */
    protected void healthIsOver(){
        alive = false;
    }

    /**
     * Getter for alive field.
     * @return Creatures' alive state.
     */
    public boolean isAlive() {
        return alive;
    }

    protected void setName(String name){this.name = name;}

    protected void setAttack(int attack) throws WrongValueException {
         if(attack>=1 && attack <= 30){this.attack = attack;}
         else{throw new WrongValueException("Attack value must be between 1 and 30");}
    }

    protected void setDefence(int defence) throws WrongValueException {
        if(defence>=1 && defence <= 30) {this.defence = defence;}
        else {throw new WrongValueException("Defence value must be between 1 and 30");}
    }

    protected void setDamage(int min_damage, int max_damage){this.damage = new int[]{min_damage, max_damage};}

    protected void setHealth(int health) throws WrongValueException {
        if(health>=1){
            this.health_value = health;
            this.current_health = health;
        }
        else {throw new WrongValueException("Health value must be more than 1");}
    }

    public String getName() {return this.name;}

    public int getAttack() {return this.attack;}

    public int getDefence() {return this.defence;}

    public int[] getDamage(){return this.damage;}

    public int getHealth() {return this.current_health;}
}
