package PartielSoftwareCraftmanshipMARGAGEFLORIAN.CODE;

import java.util.ArrayList

public class Survivant {
    private int x;
    private int y;
    Orientation orientation;
    int hpBar;
    ArrayList<Ressource> inventaire = new ArrayList<Ressource>();

    public Survivant() {
        this.x = 0;
        this.y = 0;
        this.orientation = Orientation.SUD;
        this.hpBar = 100;
    }

    public Survivant(int x, int y, Orientation orientation, int hpBar) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.hpBar = hpBar;
    }

    public void moveRight() {
        this.x++;
        this.orientation = Orientation.EST;
    }

    public void moveLeft() {
        this.x--;
        this.orientation = Orientation.OUEST;
    }

    public void moveUp() {
        this.y++;
        this.orientation = Orientation.NORD;
    }

    public void moveDown() {
        this.y++;
        this.orientation = Orientation.SUD;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    enum Orientation {
        NORD, SUD, EST, OUEST;
    }
}
