package characters;

public class Enemy extends Character {
    private int stepCount = 0;
    private int followCount = 0;
    private boolean gameOver = false;

    public Enemy() {
        super(15, 15);
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver(Player player) {
       return xPosition == player.xPosition && yPosition == player.yPosition;
    }

    public boolean isVisible(Player player) {
        return (Character.manhattanDistance(player.getxPosition(), xPosition, player.getyPosition(), yPosition)) <= 3;
    }

    public void movement(Player player) {

        if(player.getPages() == 0) return;

        if(player.getxPosition() == xPosition && player.getyPosition() == yPosition){
            gameIsOver(player);
            return;
        }

            if (stepCount % 5 == 0) {

                xPosition = (int)Math.round(Math.random()*14);
                yPosition = (int)Math.round(Math.random()*14);
                stepCount++;
                return;
            }

            switch (player.getPages()) {

                case 1:
                    int x;
                    int y;
                    do {

                         x = (int)Math.round(Math.random()*14);
                         y = (int)Math.round(Math.random()*14);
                        
                    } while ((Character.manhattanDistance(player.getxPosition(), x, player.getyPosition(), y) < 5));
                        
                        xPosition = x;
                        yPosition = y;
                        break;
                        
                    
                case 2:
                    calculateMove(0.33, player, 5);
                    break;
                case 3:
                   calculateMove(0.33, player, 5);
                    break;
                case 4:
                    calculateMove(0.5, player, 4);
                    break;
                case 5:
                    calculateMove(0.5, player, 4);
                    break;
                case 6:
                    calculateMove(0.66, player, 3);
                    break;
                case 7:
                    calculateMove(0.66, player, 3);
                    break;
            }

        stepCount++;
    }

    private void calculateMove(double chance, Player player, int distance){

        boolean success = false;
        int x;
        int y;

        if (Math.random() <= chance && follow(player)) {
            gameIsOver(player);
            return;
        }

        do{
            x = (int)Math.round(Math.random()*14);
            y = (int)Math.round(Math.random()*14);

            
            if ((Character.manhattanDistance(player.getxPosition(), x, player.getyPosition(), y) <= distance)) {
                xPosition = x;
                yPosition = y;
                success =  true;
            }
        }while(!success);
      
    }

    private boolean follow(Player player){
        if(Character.manhattanDistance(player.getxPosition(), xPosition, player.getyPosition(), yPosition) == 1){
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
