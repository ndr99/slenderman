public class  Player extends Character{

    private int pages;

    public Player(int pages, int xPosition, int yPosition) {
        super(xPosition, yPosition);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public boolean isMoveValid(int moveToX, int moveToY, World world){
        if(moveToX >= 15 || moveToY >= 15) {
            System.err.println("Nem mehetsz ki a pályáról!");
            return false;
        } else if(moveToX >= 0 && moveToY >= 0){
            switch(world.getMap()[moveToX][moveToY]){
                case 0, 1, 2 :
                    return true;
                default:
                    System.err.println("Akadály! Oda nem léphetsz!");
                    return false;
            }
        }
        System.err.println("Nem mehetsz ki a pályáról!");
        return false;
    }

    public void movement(char button, World world){
        int x = 0;
        int y = 0;
        switch (button) {
            case 's' -> y++;
            case 'w' -> y--;
            case 'd' -> x++;
            case 'a' -> x--;
            default -> System.err.println("Hibás input, irányítás wasd-vel működik!");
        }
            if(isMoveValid(xPosition + x, yPosition + y, world)) {
                xPosition += x;
                yPosition += y;
                pageFound();
            }
    }

    public void pageFound(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Tile tile = Tile.getTile(j, i);
                if(tile != null && tile.hasPage) {
                    if ((xPosition + 1 == tile.getxPosition() && yPosition == tile.yPosition) ||
                            (xPosition - 1 == tile.getxPosition() && yPosition == tile.yPosition) ||
                            (xPosition == tile.getxPosition() && yPosition + 1 == tile.yPosition) ||
                            (xPosition == tile.getxPosition() && yPosition - 1 == tile.yPosition)){
                        tile.hasPage = false;
                        pages++;
                    }
                }
            }
        }
    }
}
