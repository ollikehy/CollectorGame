package collectorgame;

import java.util.Random;

public class Tile {

    public int x;
    public int y;
    public boolean wall;
    public boolean item;

    public Tile(int y, int x) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        } else {
            this.x = 0;
            this.y = 0;
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

    public void spawnItem() {
        Random r = new Random();
        int i = r.nextInt(5);
        if (i == 4) {
            this.item = true;
        } else {
            this.item = false;
        }
    }

    private void checkTile() {
        //tarkistaa onko ruutu seinä ja jos on muuttaa booleanin wall trueksi;
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
    
}
