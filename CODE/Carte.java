package PartielSoftwareCraftmanshipMARGAGEFLORIAN.CODE;
import java.util.Scanner;

public class Carte {
    private int[][] tableau;
    private boolean isGame;
    private Survivant player;
    private Zombie zombie;

    public Carte() {
        tableau = new int[10][10];
        isGame = true;
        player = new Survivant();
        zombie = new Zombie();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (isGame) {
            if (scanner.next().charAt(0) == 'z') {
                player.moveUp();
            } else if (scanner.next().charAt(0) == 'q') {
                player.moveLeft();
            } else if (scanner.next().charAt(0) == 's') {
                player.moveDown();
            } else if (scanner.next().charAt(0) == 'd') {
                player.moveRight();
            }
            zombie.RandomMove();
            if (player.getx() < 0 || player.getx() > 9 || player.gety() < 0 || player.gety() > 9) {
                isGame = false;
                System.out.println("Game Over");
            }

        }
    }

    public void movePlayer() {

    }
}