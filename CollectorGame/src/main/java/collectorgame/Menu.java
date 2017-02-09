package collectorgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {

    private JFrame menuFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;

    public void start() {
        prepareGui();
        addButtons();
    }

    public void gameOn() {
        CollectorGame peli = new CollectorGame();
        peli.start();
    }

    public void score() {
        //tulosta huipputulokset
    }

    public void printMap() {
        System.out.println("");
        CollectorGame peli = new CollectorGame();
        peli.printMap();
        System.out.println("\n Tässä on esimerkkikartta, oikeassa pelissä esineiden sijainnit ovat erilaiset \n");
    }

    public void prepareGui() {

        menuFrame = new JFrame("CollectorGame");
        menuFrame.setSize(300, 300);
        menuFrame.setLayout(new GridLayout(2, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        menuFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(4, 1));

        menuFrame.add(headerLabel);
        menuFrame.add(controlPanel);
    }

    public void addButtons() {
        headerLabel.setText("Päävalikko");
        JButton playButton = new JButton("Pelaa");
        JButton scoreButton = new JButton("Tulokset");
        JButton mapButton = new JButton("Kartta");
        JButton endButton = new JButton("Lopeta");

        playButton.setActionCommand("OK");
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

        menuFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("PLAY")) {
                gameOn();
            } else if (command.equals("SCORE")) {
                score();
            } else if (command.equals("MAP")) {
                printMap();
            } else if (command.equals("END")) {
                System.exit(0);
            }
        }
    }

}
