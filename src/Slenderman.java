public class Slenderman extends Character{


    public Slenderman() {
        super(16,16);
    }

    public void movement(Player player){
        boolean success = false;
        if(player.getPages() >= 1){
            do {
                for (Tile tile : Tile.tiles) {
                    if (Math.random() <= 0.1) {
                        xPosition = tile.getxPosition();
                        yPosition = tile.getyPosition();
                        success = true;
                    }
                }
            }while(!success);
        }
    }
}
