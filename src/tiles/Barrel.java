package tiles;

public class Barrel extends Tile {

    private int sizeX;
    private int sizeY;

    public Barrel(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(7, xPosition, yPosition, true);
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

    @Override
    public void addPage() {
        if(!canHavePage || hasPage) return;

        int x = (int)(Math.random()*sizeX);
        int y = (int)(Math.random()*sizeY);

        new Page(xPosition + x,yPosition + y);
        hasPage = true;
    }
}
