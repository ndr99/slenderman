public class Slenderman extends Character{
    private int stepCount = 0;
    private int followCount = 0;
    private boolean gameOver = false;
    public Slenderman() {
        super(15,15);
    }

    public int getStepCount() {
        return stepCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public boolean isGameOver(Player player) {
        return xPosition == player.xPosition && yPosition == player.yPosition;
    }

    public boolean isVisible(Player player) {
        return (manhattanDistance(player.getxPosition(), xPosition, player.getyPosition(), yPosition)) <= 3;
    }

    public void movement(Player player) {

            if ((stepCount % 5 == 0) && player.getPages() != 0) {
                for (Tile tile : Tile.tiles) {
                    if (Math.random() <= 0.1) {
                        xPosition = tile.getxPosition();
                        yPosition = tile.getyPosition();
                        break;
                    }
                }
            } else if (player.getPages() == 1) {
                for (Tile tile : Tile.tiles) {
                    if ((manhattanDistance(player.getxPosition(), tile.getxPosition(), player.getyPosition(), tile.getyPosition()) >= 5)) {
                        xPosition = tile.getxPosition();
                        yPosition = tile.getyPosition();

                    }
                }
            } else if (player.getPages() > 1 && player.getPages() < 4) {
                for (Tile tile : Tile.tiles) {
                    if (Math.random() <= 0.33 && follow(player)) {
                        gameIsOver(player);
                    } else if ((manhattanDistance(player.getxPosition(), tile.getxPosition(), player.getyPosition(), tile.getyPosition()) <= 5)) {
                        xPosition = tile.getxPosition();
                        yPosition = tile.getyPosition();
                    }
                }
            } else if (player.getPages() >= 4 && player.getPages() < 6) {
                for (Tile tile : Tile.tiles) {
                    if (Math.random() <= 0.5 && follow(player)) {
                        gameIsOver(player);
                    } else if ((manhattanDistance(player.getxPosition(), tile.getxPosition(), player.getyPosition(), tile.getyPosition()) <= 4)) {
                        xPosition = tile.getxPosition();
                        yPosition = tile.getyPosition();
                    }
                }
            } else if (player.getPages() >= 6) {
                for (Tile tile : Tile.tiles) {
                    if (Math.random() <= 0.66 && follow(player)) {
                        gameIsOver(player);
                    } else if ((manhattanDistance(player.getxPosition(), tile.getxPosition(), player.getyPosition(), tile.getyPosition()) <= 3)) {
                        xPosition = tile.getxPosition();
                        yPosition = tile.getyPosition();
                    }
                }
            }

        if(player.getPages() != 0){
            stepCount++;
        }
    }

    private boolean follow(Player player){
        if(manhattanDistance(player.getxPosition(), xPosition, player.getyPosition(), yPosition) == 1){
            followCount++;
        } else {
            followCount = 0;
        }
        return followCount == 3;
    }

    private void gameIsOver(Player player){
        xPosition = player.xPosition;
        yPosition = player.yPosition;
        gameOver = true;

    }
}
