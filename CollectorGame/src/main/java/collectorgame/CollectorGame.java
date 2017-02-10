package collectorgame;

import collectorgame.Board;
import javax.swing.JFrame;

/**
 * Luokka on itse peli, missä tällä hetkellä ainoa toiminnallisuus on pelikentän
 * luominen.
 *
 * @author keolli
 */
public class CollectorGame extends JFrame {

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
     * Metodi luo hahmon ja käynnistää pelin.
     */
    public void start() {
        Player hahmo = new Player();
        play();
    }

    /**
     * Luo UI:n.
     */
    private void initUI() {
        add(new Board());
        setSize(690, 350);
        setTitle("Collector Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Tulevaisuudessa pelin toiminnallisuus tapahtuu tässä metodissa.
     * Esimerkiksi hahmon liikkuminen ja esineiden poimiminen.
     */
    public void play() {
        //pelin toteutus
    }
}
