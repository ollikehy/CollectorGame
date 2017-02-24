package collectorgame;

import collectorgame.logic.Player;
import collectorgame.logic.Tile;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    Player pelaaja;
    Tile[][] map;

    public PlayerTest() {
    }

    @Before
    public void setUp() {
        Tile kartta[][] = new Tile[30][30];
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                kartta[y][x] = new Tile(y, x);
            }
        }
        this.map = kartta;
        this.pelaaja = new Player(map);
    }

    @Test
    public void oikeaSijainti() {
        assertEquals("1,0", pelaaja.getLocation());
    }

    @Test
    public void oikeaPistemaara() {
        assertEquals(0, pelaaja.getScore());
    }

    @Test
    public void pisteidenLisaysToimii() {
        pelaaja.addScore(1000);
        assertEquals(1000, pelaaja.getScore());
    }

    @Test
    public void pisteetEiNegatiivisia() {
        pelaaja.addScore(-1000);
        assertEquals(0, pelaaja.getScore());
    }

    @Test
    public void pelaajanLiikkuminenSallittu() {
        assertTrue(pelaaja.movementAllowed());
    }

    @Test
    public void pisteetVahenevatOikein() {
        pelaaja.movePlayer("r");
        assertEquals(pelaaja.getScore(), -50);
        pelaaja.movePlayer("l");
        assertEquals(pelaaja.getScore(), -100);
        pelaaja.movePlayer("d");
        pelaaja.updatePosition();
        assertEquals(pelaaja.getScore(), -100);
        pelaaja.movePlayer("d");
        pelaaja.updatePosition();
        assertEquals(pelaaja.getScore(), -100);
    }

    @Test
    public void pisteetVahenevatPoimiessaOikein() {
        pelaaja.pickUpItem();
        assertEquals(pelaaja.getScore(), -50);
        pelaaja.pickUpItem();
        assertEquals(pelaaja.getScore(), -100);
        pelaaja.pickUpItem();
        assertEquals(pelaaja.getScore(), -150);
        map[0][1].setItem();
        pelaaja.pickUpItem();
        assertEquals(pelaaja.getScore(), -50);
    }

    @Test
    public void pelaajaLiikkuuOikein() {
        pelaaja.movePlayer("d");
        pelaaja.updatePosition();
        pelaaja.movePlayer("d");
        pelaaja.updatePosition();
        pelaaja.movePlayer("d");
        pelaaja.updatePosition();
        assertEquals(pelaaja.getLocation(), "1,3");
    }

    @Test
    public void pelaajaEiLiikuVaarin() {
        pelaaja.movePlayer("r");
        pelaaja.updatePosition();
        pelaaja.movePlayer("r");
        pelaaja.updatePosition();
        pelaaja.movePlayer("r");
        pelaaja.updatePosition();
        assertEquals(pelaaja.getLocation(), "1,0");
    }

    @Test
    public void esineetPoistuvatOikein() {
        pelaaja.movePlayer("d");
        pelaaja.updatePosition();
        map[1][1].setItem();
        pelaaja.pickUpItem();
        assertFalse(map[1][1].getItem());
    }
    
    @Test
    public void palauttaaKartan() {
        assertNotNull(pelaaja.returnMap());
    }
}
