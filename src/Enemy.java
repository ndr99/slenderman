public class Enemy extends Character{
    private int stepCount = 0;
    private int followCount = 0;
    private boolean gameOver = false;
    public Enemy() {
        super(World.BOARD_SIZE,World.BOARD_SIZE);
    }

    public int getStepCount() {
        return stepCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver(Player player) {
       return xPosition == player.xPosition && yPosition == player.yPosition;
    }

    public boolean isVisible(Player player) {
        return (manhattanDistance(player.getxPosition(), xPosition, player.getyPosition(), yPosition)) <= 3;
    }

    public void movement(Player player) {
        for (int y = 0; y < World.BOARD_SIZE; y++) {
            for (int x = 0; x < World.BOARD_SIZE; x++) {
                if ((stepCount % 5 == 0) && player.getPages() != 0) {
                    if (Math.random() <= 0.1) {
                        xPosition = x;
                        yPosition = y;
                        return;
                    }
                }
                switch (player.getPages()) {
                    case 1:
                        if ((manhattanDistance(player.getxPosition(), x, player.getyPosition(), y) >= 5)) {
                            xPosition = x;
                            yPosition = y;
                        }
                        break;
                    case 2:
                    case 3:
                        calculateMove(0.33, player, x, y, 5);
                        break;
                    case 4:
                    case 5:
                        calculateMove(0.5, player, x, y, 4);
                        break;
                    case 6:
                    case 7:
                        calculateMove(0.66, player, x, y, 3);
                        break;
                }
            }
        }

        if(player.getPages() != 0){
            stepCount++;
        }
    }

    private void calculateMove(double chance, Player player, int x, int y, int distance){
        if (Math.random() <= chance && follow(player)) {
            gameIsOver(player);
            return;
        }
        if ((manhattanDistance(player.getxPosition(), x, player.getyPosition(), y) <= distance)) {
            xPosition = x;
            yPosition = y;
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
