package collectorgame.collectorgame;

import java.util.*;

class CollectorGame {

    public Tile[] map;
    public Scanner scanner;

    CollectorGame(Scanner scanner) {
        this.scanner = scanner;
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
    }

    public void play() {
        //pelin toteutus
    }

}
