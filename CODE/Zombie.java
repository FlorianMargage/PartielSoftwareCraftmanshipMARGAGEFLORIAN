package PartielSoftwareCraftmanshipMARGAGEFLORIAN.CODE;
import java.util.Random;

public class Zombie extends Survivant {
    public void RandomMove() {
        Random random = new Random();
        int move = random.nextInt(3);
        if (move == 0) {
            moveRight();
        } else if (move == 1) {
            moveLeft();
        } else if (move == 2) {
            moveUp();
        } else if (move == 3) {
            moveDown();
        }
    }
}
