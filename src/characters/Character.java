package characters;

public class Character {
    int xPosition, yPosition;

    public Character(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public static int manhattanDistance(int x1, int x2, int y1, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
