package tiles;

public class BigTree extends Tile {

    private int sizeX;
    private int sizeY;

    public BigTree(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(2, xPosition, yPosition, true);
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

        int x = (int)Math.round(Math.random());
        int y = (int)Math.round(Math.random());

        new Page(this.xPosition+x, this.yPosition+y);
        hasPage = true;
    }
}