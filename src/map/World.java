package map;

import characters.Character;
import characters.Enemy;
import characters.Player;
import tiles.House;
import tiles.Tile;

public class World {
    public static final int BOARD_SIZE = 15;
    private int[][] map = new int[BOARD_SIZE][BOARD_SIZE];;

    public World() {

        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {

                Tile tile = Tile.getTile(x, y);
                if (tile != null) {
                    if (tile.getType() == 3) {
                        House tile2 = (House) tile;
                        for (int i = 0; i < tile.getSizeX(); i++) {
                            for (int j = 0; j < tile.getSizeY(); j++) {
                                if (i == tile2.getDoorX() && j == tile2.getDoorY()) {
                                    map[x + i][y + j] = 0;
                                } else if ((i > 0 && i < tile.getSizeX() - 1) && (j > 0 && j < tile.getSizeY() - 1)) {
                                    map[x + i][y + j] = 0;
                                } else {
                                    map[x + i][y + j] = tile.getType();
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < tile.getSizeX(); i++) {
                            for (int j = 0; j < tile.getSizeY(); j++) {
                                map[x + i][y + j] = tile.getType();
                            }
                        }
                    }
                }
            }
        }
    }

    public int[][] getMap() {
        return map;
    }

    public void draw(Player player, Enemy slenderman, int[][] pageMap) {

        int playerX = player.getxPosition();
        int playerY = player.getyPosition();
        int slenderX = slenderman.getxPosition();
        int slenderY = slenderman.getyPosition();
        //System.out.println("Slenderman pozíciója: " + slenderX + ", " + slenderY);
        //System.out.println("A játékos pozíciója: " + playerX + ", " + playerY);
        //System.out.println("Slender lepese: " + slenderman.getStepCount());
        //System.out.println("Manhattan-távolság Slenderman és közted: " + characters.Character.manhattanDistance(playerX, slenderX, playerY, slenderY));
        //System.out.println("Lépések száma, amióta követi: " + slenderman.getFollowCount());
        System.out.println("Pages: " + player.getPages() + "/8");
        System.out.println();

        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                    if(y == slenderY && x == slenderX && slenderman.isVisible(player)){
                        System.out.print("▒ ");
                    } else if(y == playerY && x == playerX) {
                        System.out.print("P ");
                    } else if(pageMap[x][y] == 1 && Character.manhattanDistance(playerX, x, playerY, y) < 3) {
                        System.out.print("X ");
                    } else {
                        System.out.print(((map[x][y] > 0) ? map[x][y] : " ") + " ");
                    }
            }
            System.out.println();
        }
    }
}
