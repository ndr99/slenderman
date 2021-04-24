public class Enemy extends Character{
    private int stepCount = 0;
    private int followCount = 0;
    private boolean gameOver = false;
    boolean success = false;

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

        if(player.getPages() == 0) return;

        do {
            int x = (int)Math.round(Math.random()*14);
            int y = (int)Math.round(Math.random()*14);

            if (stepCount % 5 == 0) {
                xPosition = x;
                yPosition = y;
                success = true;
            }

            switch (player.getPages()) {
                case 1:
                    if ((manhattanDistance(player.getxPosition(), x, player.getyPosition(), y) >= 5)) {
                        xPosition = x;
                        yPosition = y;
                        success = true;
                    }
                case 2:
                case 3:
                    success = calculateMove(0.33, player, x, y, 5);
                case 4:
                case 5:
                    success = calculateMove(0.5, player, x, y, 4);
                case 6:
                case 7:
                    success = calculateMove(0.66, player, x, y, 3);
            }
        } while(!success);

        stepCount++;

    }

    private boolean calculateMove(double chance, Player player, int x, int y, int distance){
        if (Math.random() <= chance && follow(player)) {
            gameIsOver(player);
            return true;
        }
        if ((manhattanDistance(player.getxPosition(), x, player.getyPosition(), y) <= distance)) {
            xPosition = x;
            yPosition = y;
            return true;
        }
        return false;
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
