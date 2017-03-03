package collectorgame.ui;

import collectorgame.logic.CollectorGame;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Luokka on pelin päävalikko, mikä käynnistyy Main-luokasta. Päävalikossa
 * käyttäjä pystyy valitsemaan haluamansa toiminnon.
 *
 * @author keolli
 */
public class Menu {

    private JFrame menuFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;

    /**
     * Metodi valmistelee graafisen käyttöliittymän ja lisää siihen painikkeet.
     */
    public void start() {
        prepareGui();
        addButtons();
    }

    /**
     * Metodi käynnistää itse pelin luomalla ensin CollectorGame olion ja sen
     * jälkeen asettamalla sen näkyviin. Metodi myös käynnistää pelin sen play()
     * metodilla.
     */
    public void gameOn() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CollectorGame peli = new CollectorGame();
                peli.setVisible(true);
            }
        });
    }

    /**
     * Tulevaisuudessa tämä metodi avaa uuden ikkunan jossa näkyy
     * huipputulokset.
     */
    public void score() {
        //tulosta huipputulokset
    }

    /**
     * Metodi avaa uuden ikkunan jossa näkyy mallikartta ilman, että itse peli
     * alkaa.
     * @throws java.io.IOException Heittää IOExceptionin.
     */
    public void printMap() throws IOException {
        Map map = new Map();
    }

    /**
     * Metodi valmistelee päävalikon luomalla JFramen.
     */
    public void prepareGui() {

        menuFrame = new JFrame("CollectorGame");
        menuFrame.setSize(300, 300);
        menuFrame.setLayout(new GridLayout(2, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        menuFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(4, 1));

        menuFrame.add(headerLabel);
        menuFrame.add(controlPanel);
    }

    /**
     * Metodi lisää valintapainikkeet päävalikkoon.
     */
    public void addButtons() {
        headerLabel.setText("Päävalikko");
        JButton playButton = new JButton("Pelaa");
        JButton scoreButton = new JButton("Tulokset");
        JButton mapButton = new JButton("Kartta");
        JButton endButton = new JButton("Lopeta");

        playButton.setActionCommand("PLAY");
        scoreButton.setActionCommand("SCORE");
        mapButton.setActionCommand("MAP");
        endButton.setActionCommand("END");

        playButton.addActionListener(new ButtonClickListener());
        scoreButton.addActionListener(new ButtonClickListener());
        mapButton.addActionListener(new ButtonClickListener());
        endButton.addActionListener(new ButtonClickListener());

        controlPanel.add(playButton);
        controlPanel.add(scoreButton);
        controlPanel.add(mapButton);
        controlPanel.add(endButton);

        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);

    }

    /**
     * Metodi lisää nappien painallusta seuraavan ominaisuuden nappeihin. Tämän
     * jälkeen napit toimivat tarkoitetulla tavalla.
     */
    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("PLAY")) {
                gameOn();
            } else if (command.equals("SCORE")) {
                Scoreboard sb = new Scoreboard();
                try {
                    sb.showScores();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (command.equals("MAP")) {
                try {
                    printMap();
                } catch (IOException ex) {
                    printStackTrace();
                }
            } else if (command.equals("END")) {
                System.exit(0);
            }
        }
    }

}
