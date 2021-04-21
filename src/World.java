public class World {
    private final int width = 15;
    private final int height = 15;
    private int[][] map;

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
        Tile.addPages();
    }

    public int[][] getMap() {
        return map;
    }

    public void draw(Player player, Slenderman slenderman) {

        int playerX = player.getxPosition();
        int playerY = player.getyPosition();
        int slenderX = slenderman.getxPosition();
        int slenderY = slenderman.getyPosition();
        System.out.println("Slenderman pozíciója: " + slenderX + ", " + slenderY);
        System.out.println("A játékos pozíciója: " + playerX + ", " + playerY);
        System.out.println("Megszerzett lapok: " + player.getPages() + "/8");
        System.out.println();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tile tile = Tile.getTile(x, y);
                    if(y == slenderY && x == slenderX){
                        System.out.print("▒ ");         //papirok kiiratasa
                    } else if(y == playerY && x == playerX) {
                        System.out.print("P ");
                    } else if(tile != null && tile.hasPage) {
                        System.out.print("X ");
                    } else {
                        System.out.print(((map[x][y] > 0) ? map[x][y] : " ") + " ");
                    }
            }
            System.out.println();
        }
    }
}
