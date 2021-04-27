package tiles;

public class SmallTree extends Tile {

    private int sizeX;
    private int sizeY;

    public SmallTree(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(1, xPosition, yPosition, false);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Tile.addTile(this);
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }
}
