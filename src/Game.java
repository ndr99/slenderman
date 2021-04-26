import characters.Enemy;
import characters.Player;
import map.World;
import tiles.*;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player = new Player(0,0,0);
        Enemy slender = new Enemy();
        Tile st1 = new SmallTree(1,1,1,1);
        Tile st2 = new SmallTree(5,2,1,1);
        Tile st3 = new SmallTree(5,10,1,1);
        Tile bt1 = new BigTree(3,0,2,2);
        Tile bt2 = new BigTree(0,8,2,2);
        Tile bt3 = new BigTree(13,11,2,2);
        Tile bt4 = new BigTree(6,13,2,2);
        Tile house = new House(8,1,6,7, 3, 0);
        Tile car = new Car(5,6, 2, 3);
        Tile truck = new Truck(9,9, 3, 5);
        Tile rock = new Rock(1,11,3,3);
        Tile barrel = new Barrel(0,4,4, 2);
        

        
        Page.generatePages();
        World world = new World();
        Scanner sc = new Scanner(System.in);
        char c;
        do{
            world.draw(player, slender, Page.pageMap);
            c = sc.next().charAt(0);
            player.movement(c, world, slender);
            slender.movement(player);
            if(slender.isGameOver(player)){
                System.out.println("Elkapott!");
                break;
            }
            if(player.getPages()== 8) {
                world.draw(player, slender, Page.pageMap);
                System.out.println("Nyertél!");
                break;
            }
        } while(c != 'q');
        sc.close();
    }
}
