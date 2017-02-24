package collectorgame.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Luokassa luodaan karttaikkuna päävalikkoon.
 *
 * @author keolli
 */
public class Map {

    JFrame frame;

    /**
     * Konstruktori luo ikkunan mihini tuo lataa kartan ja lisää painikkeen.
     *
     * @throws IOException Heittää exceptionin jos tiedostoa ei löydy.
     */
    public Map() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("screenshot.png");
        BufferedImage img = ImageIO.read(is);
        ImageIcon icon = new ImageIcon(img);
        this.frame = new JFrame("Esimerkki kartta");
        frame.setLayout(new FlowLayout());
        frame.setSize(img.getWidth(), img.getHeight() + 60);
        JLabel label = new JLabel();
        label.setIcon(icon);
        frame.add(label);
        frame.setLocationRelativeTo(null);

        JButton button = new JButton();
        button.setSize(img.getWidth(), 30);
        button.setActionCommand("EXIT");
        button.addActionListener(new ButtonClickListener());
        button.setText("Main Menu");
        frame.add(button);

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
