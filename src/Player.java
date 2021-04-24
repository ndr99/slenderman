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
            System.out.println("Nem mehetsz ki a pályáról!");
            return false;
        } else if(moveToX >= 0 && moveToY >= 0){
            if(world.getMap()[moveToX][moveToY] < 3) {
                return true;
            }
            System.out.println("Akadály! Oda nem léphetsz!");
            return false;
        }
        System.out.println("Nem mehetsz ki a pályáról!");
        return false;
    }

    public void movement(char button, World world, Enemy slenderman){
        int x = 0;
        int y = 0;
        switch (button) {
            case 's': y++;
                break;
            case 'w': y--;
                break;
            case 'd': x++;
                break;
            case 'a': x--;
                break;
            case 'q' : break;
            default: System.out.println("Hibás input, irányítás wasd-vel működik!");
        }
            if(isMoveValid(xPosition + x, yPosition + y, world)) {
                xPosition += x;
                yPosition += y;
                pageFound(Page.pageMap);
                if(xPosition == slenderman.getxPosition() && yPosition == slenderman.getyPosition()){
                    slenderman.setGameOver(true);
                }
            }
    }

    public void pageFound(int[][] pageMap){
        for (int y = 0; y < World.BOARD_SIZE; y++) {
            for (int x = 0; x < World.BOARD_SIZE; x++) {
                if(pageMap[x][y] == 1) {
                    if ((xPosition + 1 == x && yPosition == y) ||
                            (xPosition - 1 == x && yPosition == y) ||
                            (xPosition == x && yPosition + 1 == y) ||
                            (xPosition == x && yPosition - 1 == y)){
                        pageMap[x][y] = 0;
                        pages++;
                    }
                }
            }
        }
    }
}
