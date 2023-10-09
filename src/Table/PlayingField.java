package Table;

import Creatures.Monster;
import Creatures.Player;

public class PlayingField {
    static Player brave_player;
    static Monster[] dungeon;
    static public void filTheDungeon(Monster[] monsters){
        dungeon = monsters;
        System.out.println(String.format("There is(are) %d ugly monster(s) in the Dungeon!", dungeon.length));
        for(int i=0; i< dungeon.length;i++){
            System.out.println(dungeon[i]);
        }
    }
    static public void setPlayer(Player player){
        brave_player = player;
        System.out.println();
        System.out.println("What's the brave player?");
        System.out.println(brave_player);
    }
    static public void  startBattle(){
        System.out.println();
        System.out.println("Battle started!");
        System.out.println();
        for (Monster monster : dungeon) {
            while (true) {
                System.out.println(brave_player.attack(monster));
                if (!monster.isAlive()) {
                    System.out.println(String.format("Monster %s is finally dead...", monster.getName()));
                    break;
                }
                System.out.println(monster.attack(brave_player));
                if (!brave_player.isAlive()) {
                    System.out.println(String.format("Player %s is finally dead...", brave_player.getName()));
                    break;
                }
            }
            System.out.println();
            if (!brave_player.isAlive()) {
                System.out.println("Game is over!");
                break;
            } else {
                if(dungeon.length == 1) System.out.println(String.format("Player %s wins!!!", brave_player.getName()));

                else {
                    System.out.println(String.format("He had %d point of health.", brave_player.getHealth()));
                    System.out.println("Brave palyer found a new Monster!");
                }
            }
        }
    }
}
