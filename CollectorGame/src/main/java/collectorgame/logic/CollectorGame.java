package collectorgame.logic;

import collectorgame.ui.Board;
import javax.swing.JFrame;

/**
 * Luokka on itse peli, missä tällä hetkellä ainoa toiminnallisuus on pelikentän
 * luominen.
 *
 * @author keolli
 */
public class CollectorGame extends JFrame {

    public Board board;
    public Tile[][] map;
    
    /**
     * Konstruktori luo UI:n.
     */
    public CollectorGame() {
        initUI();
    }

    /**
     * Tämä konstruktori on kartan luomista varten.
     *
     * @param esim huolehtii siitä, että ainoa toiminnallisuus on tosiaan kartan
     * luominen
     */
    public CollectorGame(boolean esim) {
        initUI();
    }

    /**
     * Luo UI:n.
     */
    private void initUI() {
        this.board = new Board();
        add(board);
        setSize(690, 370);
        setTitle("Collector Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
