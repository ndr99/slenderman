public class Szikla extends Tile{

    private int sizeX;
    private int sizeY;

    public Szikla(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(6, xPosition, yPosition);
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
