package collectorgame;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class collectorgameTest {

    CollectorGame peli;
    Tile[][] map;

    public collectorgameTest() {
    }

    @Before
    public void setUp() {
        this.peli = new CollectorGame(new Scanner(System.in));
        peli.createMap();
        this.map = peli.getMap();
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
