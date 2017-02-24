package collectorgame.logic;

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
     *
     * @return Palauttaa true jos on ja false jos ei ole.
     */
    public boolean movementAllowed() {
        if (this.dx == -1) {
            if (map[this.y][this.x - 1].getWall()) {
                return false;
            }
        } else if (this.dx == 1) {
            if (map[this.y][this.x + 1].getWall()) {
                return false;
            }
        } else if (this.dy == -1) {
            if (map[this.y - 1][this.x].getWall()) {
                return false;
            }
        } else if (this.dy == 1) {
            if (map[this.y + 1][this.x].getWall()) {
                return false;
            }
        }
        return true;
    }
/**
 * Liikuttaa pelaajaa annettuun suuntaan.
 * @param string Annettu suunta.
 */
    public void movePlayer(String string) {
        if (string.equals("l")) {
            if (this.x - 1 > 0 && !map[this.y][this.x - 1].getWall()) {
                dx = -1;
            } else {
                this.score -= 50;
            }
        } else if (string.equals("r")) {
            if (this.x + 1 < 22 && !map[this.y][this.x + 1].getWall()) {
                dx = 1;
            } else {
                this.score -= 50;
            }
        } else if (string.equals("u")) {
            if (this.y - 1 > 0 && !map[this.y - 1][this.x].getWall()) {
                dy = -1;
            } else {
                this.score -= 50;
            }
        } else if (string.equals("d")) {
            if (this.y + 1 < 11 && !map[this.y + 1][this.x].getWall()) {
                dy = 1;
            } else {
                this.score -= 50;
            }
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
            this.score -= 50;
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
            movePlayer("l");
        }
        if (key == KeyEvent.VK_RIGHT) {
            movePlayer("r");
        }
        if (key == KeyEvent.VK_UP) {
            movePlayer("u");
        }
        if (key == KeyEvent.VK_DOWN) {
            movePlayer("d");
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
        } else if (key == KeyEvent.VK_RIGHT) {
            this.dx = 0;
        } else if (key == KeyEvent.VK_UP) {
            this.dy = 0;
        } else if (key == KeyEvent.VK_DOWN) {
            this.dy = 0;
        } else if (key == KeyEvent.VK_Z) {
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