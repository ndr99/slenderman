public class Rock extends Tile{

    private int sizeX;
    private int sizeY;

    public Rock(int xPosition, int yPosition, int sizeX, int sizeY) {
        super(6, xPosition, yPosition, true);
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

        if(x != 1 && y != 1) new Page(this.xPosition+x, this.yPosition+y);
        hasPage = true;
    }
}
