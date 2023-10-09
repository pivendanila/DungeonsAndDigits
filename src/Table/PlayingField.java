package Table;

import Creatures.Monster;
import Creatures.Player;

/**
 * Static class using for conducting battles of Creatures.
 * @autor Piven Danila.
 */
public class PlayingField {
    static Player brave_player;
    static Monster[] dungeon;

    /**
     * Setter for dungeon field.
     * @param monsters is the array of monsters that fills the dungeon.
     */
    static public void fillTheDungeon(Monster[] monsters){
        dungeon = monsters;
        System.out.println(String.format("There is(are) %d ugly monster(s) in the Dungeon!", dungeon.length));
        for(int i=0; i< dungeon.length;i++){
            System.out.println(dungeon[i]);
        }
    }

    /**
     * Setter for player field.
     * @param player is player that you choose for battle.
     */
    static public void setPlayer(Player player){
        brave_player = player;
        System.out.println();
        System.out.println("What's the brave player?");
        System.out.println(brave_player);
    }

    /**
     * Main function that conduct the battle.
     */
    static public void  startBattle(){
        System.out.println();
        System.out.println("Battle started!");
        System.out.println();
        for (int i=0; i< dungeon.length; i++) {
            while (true) {
                System.out.println(brave_player.attack(dungeon[i]));
                if (!dungeon[i].isAlive()) {
                    System.out.println(String.format("Monster %s is finally dead...", dungeon[i].getName()));
                    break;
                }
                System.out.println(dungeon[i].attack(brave_player));
                if (!brave_player.isAlive()) {
                    System.out.println(String.format("Player %s is finally dead...", brave_player.getName()));
                    break;
                }
            }
            System.out.println();
            if (!brave_player.isAlive()) {
                System.out.println("Game is over!");
                break;
            }
            else {
                if(dungeon.length == i+1) System.out.println(String.format("Player %s wins!!!", brave_player.getName()));
                else {
                    System.out.println(String.format("He had %d point of health.", brave_player.getHealth()));
                    System.out.println("Brave palyer found a new Monster!");
                }
            }
        }
    }
}
