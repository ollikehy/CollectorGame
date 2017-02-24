package collectorgame.logic;

import java.util.Random;

/**
 * Luokka Tile vastaa siitä, että ruudut ovat oikeassa paikassa. Luokassa myös
 * huolehditaan siitä että ruudut tietävät olevansa seiniä tai sisältävänsä
 * esineitä.
 *
 * @author keolli
 */
public class Tile {

    public int x;
    public int y;
    public boolean wall;
    public boolean item;
    public boolean player;

    /**
     * Konstruktori luo ruudun ja asettaa ensimmäiseen ruutuun pelaajan.
     *
     * @param y Kertoo ruudun sijainnin y-akselilla.
     * @param x Kertoo ruudun sijainnin x-akselilla.
     */
    public Tile(int y, int x) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        } else {
            this.x = 0;
            this.y = 0;
        }
        if (this.x == 1 && this.y == 0) {
            this.player = true;
        } else {
            this.player = false;
        }
        spawnItem();
        checkTile();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Arpoo tuleeko ruutuun esinettä vai ei.
     */
    public void spawnItem() {
        Random r = new Random();
        int i = r.nextInt(5);
        if (i == 4) {
            if (this.y < 11 && this.y > 0) {
                this.item = true;
            }
        } else {
            this.item = false;
        }
    }
    
    public void setItem() {
        this.item = true;
    }

    /**
     * Tarkistaa ruudun sijainnin ja jos se on seinä muuttaa booleanin wall
     * arvon trueksi.
     */
    private void checkTile() {
        if (this.x == 0) {
            this.wall = true;
        } else if (this.x % 2 == 0 && this.y != 9 && this.x % 4 != 0) {
            this.wall = true;
        } else if (this.x % 4 == 0 && this.y != 1) {
            this.wall = true;
        } else if (this.y == 10 && this.x != 21) {
            this.wall = true;
        } else if (this.x == 22) {
            this.wall = true;
        } else if (this.y == 0 && this.x != 1) {
            this.wall = true;
        }
    }

    public boolean getWall() {
        return this.wall;
    }

    public boolean getItem() {
        return this.item;
    }

    public boolean getPlayer() {
        return this.player;
    }

    /**
     * Poistaa ruudulta esineen.
     */
    public void removeItem() {
        this.item = false;
    }

    /**
     * Asettaa ruutuun pelaajan tai poistaa pelaajan ruudusta.
     *
     * @param arvo Määrittelee asetetaanko pelaaja vai poistetaanko pelaaja.
     */
    public void setOrRemovePlayer(boolean arvo) {
        this.player = arvo;
    }
}
