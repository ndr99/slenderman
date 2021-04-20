import java.util.ArrayList;

public class Tile {

    private static ArrayList<Tile> tiles = new ArrayList<>();

    int type;
    int xPosition, yPosition;
    int sizeX;
    int sizeY;
    boolean hasPage = false;
    boolean canHavePage;


    public Tile() {
    }

    public Tile(int type, int xPosition, int yPosition, boolean canHavePage) {
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.canHavePage = canHavePage;

    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getType() {
        return type;
    }

    public static Tile getTile(int x, int y){
        for (Tile tile:tiles) {
            if(tile.getxPosition() == x && tile.getyPosition() == y){
                return tile;
            }

        }
        return null;
    }

    public void addPage(){
        if(canHavePage && !hasPage) {
            hasPage = true;
            Page.count++;
        }
    }
    
    public static void addPages(){
        do {
            for (Tile tile : tiles) {
                if (Math.random() <= 0.1) {
                    tile.addPage();
                }
            }
        } while(Page.getCount() < 8);
    }

    public static void addTile(Tile tile){
        tiles.add(tile);
    }
}
