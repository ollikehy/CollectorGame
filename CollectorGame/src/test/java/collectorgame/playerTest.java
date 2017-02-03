package collectorgame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class playerTest {

    Player pelaaja;

    public playerTest() {
    }

    @Before
    public void setUp() {
        this.pelaaja = new Player();
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
    public void xEiVoiOllaNeg() {
        pelaaja.movePlayerLeft();
        pelaaja.movePlayerLeft();
        assertEquals("0,0", pelaaja.getLocation());
    }

    @Test
    public void yEiVoiOllaNeg() {
        pelaaja.movePlayerUp();
        pelaaja.movePlayerUp();
        assertEquals("1,0", pelaaja.getLocation());
    }

}
