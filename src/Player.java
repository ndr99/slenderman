import java.util.ArrayList;

public class  Player {

    int pages;
    int xPosition, yPosition;

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


    public void movement(char button){
        if(button == 's' && yPosition < 14){
            yPosition++;
        } else if(button == 'w' && yPosition > 0){
            yPosition--;
        } else if(button == 'd' && xPosition < 14 ){
            yPosition++;
        } else if(button == 'a' && xPosition > 0){
            yPosition--;
        }
    }

    public void pageFound(){
        this.pages++;
    }


}
