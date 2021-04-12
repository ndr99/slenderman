import java.util.ArrayList;

public class Tile {

    private static ArrayList<Tile> tiles = new ArrayList<>();

    int type;
    int xPosition, yPosition;
    int sizeX;
    int sizeY;
    boolean barrier;

    public Tile() {
    }

    public Tile(int type, int xPosition, int yPosition, boolean barrier) {
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.barrier = barrier;
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

    public static Tile getTile(int x, int y){
        for (Tile tile:tiles) {
            if(tile.getxPosition() == x && tile.getyPosition() == y){
                return tile;
            }

        }
        return null;
    }

    public int getType() {
        return type;
    }

    public static void addTile(Tile tile){
        tiles.add(tile);
    }
}
