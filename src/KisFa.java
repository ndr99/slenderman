public class KisFa extends Tile{

    private int sizeX;
    private int sizeY;

    public KisFa(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(1, xPosition, yPosition);
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
