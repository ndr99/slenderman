import java.util.ArrayList;

public class Page {
    int xPosition, yPosition;
    private static ArrayList<Tile> tilesWithPages = new ArrayList<>();

    public static Tile getTilesWithPages(int x, int y){
        if(reachable(x,y)) {
            for (Tile tile : tilesWithPages) {
                switch (tile.getType()) {
                    case 0, 1:
                        return null;
                    default:
                        break;
                }
                if (tile.getxPosition() == x && tile.getyPosition() == y) {
                    return tile;
                }
            }
        }
        return null;
    }

    public static boolean reachable(int x, int y){

        return true;
    }


}
