package tiles;

public class House extends Tile {

    private int sizeX;
    private int sizeY;
    private int doorX;
    private int doorY;

    public House(int xPosition, int yPosition, int sizeX, int sizeY, int doorX, int doorY) {
        super(3, xPosition, yPosition, true);
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

    @Override
    public void addPage() {
        if(!canHavePage || hasPage) return;

        int x = (int)(Math.random()*(sizeX-2)+1);
        int y = (int)(Math.random()*(sizeY-2)+1);

        new Page(this.xPosition+x, this.yPosition+y);
        hasPage = true;
    }
}
