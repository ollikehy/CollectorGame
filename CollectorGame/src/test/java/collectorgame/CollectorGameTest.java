package collectorgame;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CollectorGameTest {

    CollectorGame peli;
    Tile[][] map;

    public CollectorGameTest() {
    }

    @Before
    public void setUp() {
        Board b = new Board();
        b.createMap();
        this.map = b.getMap();
    }

    @Test
    public void ensimmainenRuutuEiNull() {
        assertNotNull(map[0][0]);
    }

    @Test
    public void ruutuKeskeltaKarttaaEiNull() {
        assertNotNull(map[10][20]);
    }

    @Test
    public void ensimmainenRuutuOnSeina() {
        assertTrue(map[0][0].getWall());
    }
    
    @Test
    public void maaliRuutuEiOleSeina() {
        assertFalse(map[10][21].getWall());
    }
}
