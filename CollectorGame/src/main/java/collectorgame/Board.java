package collectorgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Luokka luo pelikentän.
 *
 * @author keolli
 */
public class Board extends JPanel implements ActionListener {

    public Tile[][] map;
    public Player hahmo;
    private Timer timer;

    /**
     * Konstruktori kutsuu ensin metodia joka luo kartan. Asettaa myös ruudun
     * taustan valkoiseksi.
     */
    public Board() {
        initBoard();
    }

    private void initBoard() {
        createMap();
        this.hahmo = new Player(this.map);
        setBackground(Color.white);

        setFocusable(true);
        addKeyListener(new TAdapter());

        this.timer = new Timer(150, this);
        timer.start();
    }

    /**
     * Metodi kutsuu drawBackground metodia joka piirtää kartan.
     *
     * @param g On Javan abstrakti grafiikka-luokka.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
    }

    /**
     * Metodi piirtää kartan.
     *
     * @param g On Javan abstrakti grafiikka-luokka.
     */
    public void drawMap(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.addRenderingHints(rh);

        Dimension size = getSize();
        int leveys = size.width;
        int korkeus = size.height;

        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                int sijaintiX = x * 30;
                int sijaintiY = y * 30;
                if (map[y][x].getWall()) {
                    g2d.setPaint(Color.red);
                    g2d.drawRect(sijaintiX, sijaintiY, 30, 30);
                    g2d.fillRect(sijaintiX, sijaintiY, 30, 30);
                } else if (map[y][x].getItem() == true && map[y][x].getPlayer() == true) {
                    g2d.setPaint(Color.cyan);
                    g2d.drawOval(sijaintiX + 3, sijaintiY + 3, 25, 25);
                    g2d.fillOval(sijaintiX + 3, sijaintiY + 3, 25, 25);
                    g2d.setPaint(Color.black);
                    g2d.drawRect(sijaintiX + 7, sijaintiY + 7, 15, 15);
                    g2d.fillRect(sijaintiX + 7, sijaintiY + 7, 15, 15);

                } else if (map[y][x].getItem()) {
                    g2d.setPaint(Color.cyan);
                    g2d.drawOval(sijaintiX + 3, sijaintiY + 3, 25, 25);
                    g2d.fillOval(sijaintiX + 3, sijaintiY + 3, 25, 25);
                } else if (map[y][x].getPlayer()) {
                    g2d.setPaint(Color.black);
                    g2d.drawRect(sijaintiX + 7, sijaintiY + 7, 15, 15);
                    g2d.fillRect(sijaintiX + 7, sijaintiY + 7, 15, 15);
                }
            }
        }
    }

    /**
     * Luo kartan kaksiulotteiseen taulukkoon.
     */
    public void createMap() {
        Tile kartta[][] = new Tile[30][30];
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 23; x++) {
                kartta[y][x] = new Tile(y, x);
            }
        }
        this.map = kartta;
    }

    public Tile[][] getMap() {
        return this.map;
    }

    /**
     * Hakee hahmolta kartan joka on uudempi kuin luokan nykyinen oma kartta.
     */
    public void updateMap() {
        this.map = hahmo.returnMap();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hahmo.updatePosition();
        updateMap();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            hahmo.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            hahmo.keyPressed(e);
        }
    }

}
