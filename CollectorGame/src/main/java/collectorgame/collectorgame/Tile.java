package collectorgame.collectorgame;

public class Tile {

    public int x;
    public int y;
    public boolean wall;

    public Tile(int y, int x) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        } else {
            this.x = 0;
            this.y = 0;
        }

        checkTile();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void spawnItem() {
        //esineiden luonti
    }

    private void checkTile() {
        //tarkistaa onko ruutu seinä ja jos on muuttaa booleanin wall trueksi;
    }
}
