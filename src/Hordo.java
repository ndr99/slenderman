public class Hordo extends Tile{

    private int sizeX;
    private int sizeY;

    public Hordo(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(7, xPosition, yPosition);
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
