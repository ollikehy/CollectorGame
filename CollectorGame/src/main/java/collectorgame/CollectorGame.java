package collectorgame;

import java.util.*;

class CollectorGame {

    public Tile[][] map;

    CollectorGame() {
    }

    public void printMap() {
        createMap();
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                if (map[y][x].getWall() == true) {
                    System.out.print("[]");
                } else if (map[y][x].getItem() == true) {
                    System.out.print("db");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    public void start() {
        Player hahmo = new Player();
        createMap();
        play();
    }

    public void createMap() {
        Tile kartta[][] = new Tile[30][30];
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                kartta[y][x] = new Tile(y, x);
            }
        }
        this.map = kartta;
    }

    public void play() {
        //pelin toteutus
    }

    public Tile[][] getMap() {
        return this.map;
    }

}
