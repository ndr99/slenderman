public class TeherAuto extends Tile{

    private int sizeX;
    private int sizeY;

    public TeherAuto(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(5, xPosition, yPosition, true);
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
