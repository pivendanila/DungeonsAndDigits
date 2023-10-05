package Creatures;

import Exceptions.WrongValueException;

public abstract class Creature {
    private int attack;
    private int defence;
    private int health;
    public String name;

     protected void setName(String name){
         this.name = name;
     }

    protected void setAttack(int attack) throws WrongValueException {
         if(attack>=1 && attack <= 30){
             this.attack = attack;
         }
         else{
            throw new WrongValueException("Attack value must be between 1 and 30");
         }
    }

    protected void setDefence(int defence) throws WrongValueException {
        if(defence>=1 && defence <= 30){
            this.defence = defence;
        }
        else{
            throw new WrongValueException("Defence value must be between 1 and 30");
        }
    }

    protected void setHealth(int health) throws WrongValueException {
        if(health>=1){
            this.health = health;
        }
        else{
            throw new WrongValueException("Health value must be more than 1");
        }
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }
}
