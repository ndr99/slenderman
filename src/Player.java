
public class  Player {

    private int pages;
    private int xPosition, yPosition;

    public Player(int pages, int xPosition, int yPosition) {
        this.pages = pages;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getPages() {
        return pages;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }


    public static boolean isMoveValid(int moveFromX, int moveFromY){
        if(moveFromX >= 15 || moveFromY >= 15) return false;
        return moveFromX >= 0 && moveFromY >= 0;
    }

    public void movement(char button){
        int x = 0;
        int y = 0;
        switch(button) {
            case 's':
                y++;
                break;
            case 'w':
                y--;
                break;
            case 'd':
                x++;
                break;
            case 'a':
                x--;
                break;
            default:
                break;
        }
            if(isMoveValid(xPosition, yPosition)){
                xPosition += x;
                yPosition += y;
            } else {
                System.err.println("Oda nem léphetsz!");
            }

    }

    public void pageFound(){
        this.pages++;
    }


}
