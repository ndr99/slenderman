package tiles;


import map.World;

public class Page {
    static int count = 0;
    public static int[][] pageMap = new int[World.BOARD_SIZE][World.BOARD_SIZE];
    private int x;
    private int y;

    public Page(int x, int y) {
        this.x = x;
        this.y = y;
        pageMap[x][y] = 1;
        count++;
    }

    public static void generatePages() {
        do {
            for (Tile tile : Tile.getTileList()) {
                if (Math.random() <= 0.1) tile.addPage();
            }
        }while(count < 8);
    }

/*
    public static int getCount() { return count; }

    public static int[][] getPageMap(){ return pageMap; }
 */

}
