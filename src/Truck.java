public class Truck extends Tile{

    private int sizeX;
    private int sizeY;

    public Truck(int xPosition, int yPosition, int sizeX, int sizeY) {
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

    @Override
    public void addPage() {
        if(!canHavePage || hasPage) return;

        int x = (int)(Math.random()*sizeX);
        int y = (int)(Math.random()*sizeY);

        if(x == 1 && y > 0 && y < 4) return;
        new Page(this.xPosition+x, this.yPosition+y);
        hasPage = true;
    }
}
