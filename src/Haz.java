public class Haz extends Tile{

    private int sizeX;
    private int sizeY;
    private int doorX;
    private int doorY;

    public Haz(int xPosition, int yPosition, int sizeX, int sizeY, int doorX, int doorY) {
        super(3, xPosition, yPosition);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.doorX = doorX;
        this.doorY = doorY;
        Tile.addTile(this);
    }

    public int getDoorX() {
        return doorX;
    }

    public int getDoorY() {
        return doorY;
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
