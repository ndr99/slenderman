import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player = new Player(0,0,0);
        Tile kisfa1 = new KisFa(1,1,1,1);
        Tile kisfa2 = new KisFa(5,2,1,1);
        Tile kisfa3 = new KisFa(5,10,1,1);
        Tile nagyfa1 = new NagyFa(3,1,2,2);
        Tile nagyfa2 = new NagyFa(0,8,2,2);
        Tile nagyfa3 = new NagyFa(13,10,2,2);
        Tile haz = new Haz(8,2,6,7, 3, 0);
        Tile auto = new Auto(5,7, 2, 3);
        Tile teherauto = new TeherAuto(9,10, 3, 5);
        Tile szikla = new Szikla(0,12,3,3);
        Tile hordo = new Hordo(0,5,4, 2);


        World world = new World();
        Scanner sc = new Scanner(System.in);
        char c;
        do{
            world.draw();
            c = sc.next().charAt(0);
            player.movement(c);
        } while(c != 'q');
        sc.close();
    }
}
