package collectorgame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    
    public TileTest() {
    }

    @Before
    public void setUp() {

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
    public void onkoSeinaOikeassaReunassa() {
        Tile ruutu = new Tile(0,0);
        assertTrue(ruutu.getWall());
    }
    
    @Test
    public void onkoSeinaKeskellaKarttaaOikein() {
        Tile ruutu = new Tile(9,9);
        assertFalse(ruutu.getWall());
    }
    
    @Test
    public void pelaajaLoytyyAlkuruudusta() {
        Tile ruutu = new Tile(0,1);
        assertTrue(ruutu.getPlayer());
    }
}
