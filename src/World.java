public class World {
    private final int width = 15;
    private final int height = 15;
    private int[][] map;
    Player player = new Player(0,0,0);
    // map
    public World() {
        map = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tile tile = Tile.getTile(x, y);
                if (tile != null) {
                    if (tile.getType() == 3) {
                        Haz tile2 = (Haz) tile;
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






    public void draw() {
        System.out.println("pages: " + player.getPages());
        System.out.println();
        int playerX = player.getxPosition();
        int playerY = player.getyPosition();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if(i == playerY && j == playerX){
                    System.out.print("P ");
                } else {
                    System.out.print(((map[j][i] > 0) ? map[j][i] : " ") + " ");
                }
            }
            System.out.println();
        }
    }
}
