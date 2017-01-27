
import collectorgame.collectorgame.Player;
import collectorgame.collectorgame.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class gameTest {

    Player pelaaja;

    public gameTest() {
    }

    @Before
    public void setUp() {
        this.pelaaja = new Player();
    }

    @Test
    public void ruudunXArvoEiNeg() {
        Tile ruutu = new Tile(0, -1);
        assertEquals(0, ruutu.getX());
    }

    @Test
    public void ruudunYArvoEiNeg() {
        Tile ruutu = new Tile(-1, 0);
        assertEquals(0, ruutu.getY());
    }

    @Test
    public void suuriX() {
        Tile ruutu = new Tile(0, 9999);
        assertEquals(9999, ruutu.getX());
    }

    @Test
    public void suuriY() {
        Tile ruutu = new Tile(9999, 0);
        assertEquals(9999, ruutu.getY());
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
