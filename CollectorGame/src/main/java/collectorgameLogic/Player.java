package collectorgameLogic;

import java.awt.event.KeyEvent;

/**
 * Pelaajaluokka seuraa pelaajan pisteitä ja sijaintia.
 *
 * @author keolli
 */
public class Player {

    public int score;
    public int x;
    public int y;
    public int dx;
    public int dy;
    public Tile[][] map;

    /**
     * Luokan konstruktori joka ei saa karttaa parametrinaan.
     */
    public Player() {
        this.x = 1;
        this.y = 0;
        this.score = 0;
        this.dx = 0;
        this.dy = 0;
    }

    /**
     * Luokan konstruktori.
     *
     * @param map Kartta minkä luokka saa parametrina.
     */
    public Player(Tile[][] map) {
        this.map = map;
        this.x = 1;
        this.y = 0;
        this.score = 0;
        this.dx = 0;
        this.dy = 0;
    }

    /**
     * Palauttaa hahmon sijainnin.
     *
     * @return Palauttaa x- ja y-koordinaatit.
     */
    public String getLocation() {
        return this.x + "," + this.y;
    }

    /**
     * Tarkistaa onko pelaajan liikkuminen sallittua.
     * @return Palauttaa true jos on ja false jos ei ole.
     */
    
    public boolean movementAllowed() {
        if (this.dx == -1) {
            if (map[this.y][this.x-1].getWall()) {
                return false;
            }
        } else if (this.dx == 1) {
            if (map[this.y][this.x +1].getWall()) {
                return false;
            }
        } else if (this.dy == -1) {
            if (map[this.y-1][this.x].getWall()) {
                return false;
            }
        } else if (this.dy == 1) {
            if (map[this.y+1][this.x].getWall()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Liikuttaa pelaajaa vasemmalle.
     */
    public void movePlayerLeft() {
        if (this.x - 1 > 0 && !map[this.y][this.x - 1].getWall()) {
            dx = -1;
        } else {
            this.score -= 50;
        }
    }

    /**
     * Liikuttaa pelaajaa oikealle.
     */
    public void movePlayerRight() {
        if (this.x + 1 < 22 && !map[this.y][this.x + 1].getWall()) {
            dx = 1;
        } else {
            this.score -= 50;
        }
    }

    /**
     * Liikuttaa pelaajaa ylös.
     */
    public void movePlayerUp() {
        if (this.y - 1 > 0 && !map[this.y - 1][this.x].getWall()) {
            dy = -1;
        } else {
            this.score -= 50;
        }
    }

    /**
     * Liikuttaa pelaajaa alas.
     */
    public void movePlayerDown() {
        if (this.y + 1 < 11 && !map[this.y + 1][this.x].getWall()) {
            dy = 1;
        } else {
            this.score -= 50;
        }
    }

    /**
     * Poimii esineen jos ruudussa on esine, muuten vähentää pisteitä.
     */
    public void pickUpItem() {
        if (map[this.y][this.x].getItem()) {
            addScore(100);
            map[this.y][this.x].removeItem();
        } else {
            this.score -= 100;
        }
    }

    public int getScore() {
        return this.score;
    }

    /**
     * Lisää tai vähentää tuloksesta pisteitä.
     *
     * @param score Lisättävien tai vähennettävien pisteiden määrä.
     */
    public void addScore(int score) {
        if (score < 0 && this.score + score < 0) {
            this.score = 0;
        } else {
            this.score += score;
        }
    }

    /**
     * Uudistaa pelaajan sijainnin ja muuttaa x- sekä y-koordinaattien arvoja.
     */
    public void updatePosition() {
        if (movementAllowed()) {
            this.map[this.y][this.x].setOrRemovePlayer(false);
            this.x += this.dx;
            this.y += this.dy;
            this.map[this.y][this.x].setOrRemovePlayer(true);
        }
    }

    /**
     * Toimii painettujen näppäinten perusteella.
     *
     * @param e Näppäin mitä on painettu.
     */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            movePlayerLeft();
        }

        if (key == KeyEvent.VK_RIGHT) {
            movePlayerRight();
        }

        if (key == KeyEvent.VK_UP) {
            movePlayerUp();
        }

        if (key == KeyEvent.VK_DOWN) {
            movePlayerDown();
        }

        if (key == KeyEvent.VK_Z) {
            pickUpItem();
        }
    }

    /**
     * Seuraa sitä, kun näppäin vapautuu ja toimii sen mukaan.
     *
     * @param e Vapautunut näppäin.
     */
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            this.dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            this.dy = 0;
        }

        if (key == KeyEvent.VK_Z) {
            this.dx = 0;
        }
    }

    /**
     * Palauttaa kartan.
     *
     * @return Kartta.
     */
    public Tile[][] returnMap() {
        return this.map;
    }

}
