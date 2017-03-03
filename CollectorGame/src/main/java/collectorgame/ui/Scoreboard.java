/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectorgame.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Scoreboard luokassa hallinnoidaan tuloksia.
 *
 * @author keolli
 */
public class Scoreboard extends JFrame {

    public JFrame frame;

    /**
     * Metodi luo ikkunan ja tallentaa tuloksen.
     *
     * @param score Pelaajan tallennettava tulos.
     */
    public void saveScore(int score) {
        this.frame = new JFrame("Tulokset");
        frame.setSize(200, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));
        JLabel teksti = new JLabel("Pisteesi: " + score, JLabel.CENTER);
        teksti.setSize(200, 150);
        frame.add(teksti);
        JTextField kentta = new JTextField("Nimi");
        kentta.setSize(200, 25);
        frame.add(kentta);
        JButton button = new JButton("Ok");
        button.setSize(200, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveScoreToFile(kentta.getText(), score);
                } catch (IOException ex) {
                    Logger.getLogger(Scoreboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame.add(button);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    /**
     * Tallentaa tuloksen tekstitiedostoon.
     *
     * @param name Pelaajan nimi jolla tulos tallennetaan.
     * @param score Tallennettava tulos.
     * @throws IOException Heittää IO Exceptionin.
     */
    private void saveScoreToFile(String name, int score) throws IOException {
        File f = new File("scores.txt");

        if (!f.exists()) {
            f.createNewFile();
        }

        if (name.equals("")) {
            name = "Anonymous";
        }
        FileWriter fw = new FileWriter(f, true);
        fw.write(name + ";" + score + "\n");
        fw.flush();
        fw.close();
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Näyttää huipputulokset.
     * @throws FileNotFoundException Heittää FNF Exceptionin. 
     */
    public void showScores() throws FileNotFoundException {
        Scanner file = new Scanner(new File("scores.txt"));
        HashMap<Integer, String> scoresAndNames = new HashMap<>();
        ArrayList<Integer> scores = new ArrayList<>();
        while (file.hasNextLine()) {
            String rivi = file.nextLine();
            String[] palat = rivi.split(";");
            scoresAndNames.put(Integer.parseInt(palat[1]), palat[0]);
            scores.add(Integer.parseInt(palat[1]));
        }
        Collections.sort(scores);
        Collections.reverse(scores);
        this.frame = new JFrame("Huipputulokset");
        frame.setLayout(new GridLayout(6, 1));
        frame.setSize(200, 300);
        for (int i = 0; i < 5; i++) {
            JLabel uusi = new JLabel("");
            int monesko = 1 + i;
            if (monesko > scores.size()) {
                uusi.setText(monesko + ": ei tuloksia");
            } else {
                uusi.setText("<" + monesko + "> " + scoresAndNames.get(scores.get(i)) + " : " + scores.get(i));

            }
            uusi.setSize(200, 50);
            uusi.setVerticalAlignment(SwingConstants.CENTER);
            uusi.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(uusi);
        }
        JButton jb = new JButton("Main menu");
        jb.setActionCommand("EXIT");
        jb.addActionListener(new ButtonClickListener());
        jb.setSize(200, 50);
        frame.add(jb);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("EXIT")) {
                frame.dispose();
            }
        }

    }
}
