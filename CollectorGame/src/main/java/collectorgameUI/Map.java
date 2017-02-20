package collectorgameUI;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author keolli
 */
public class Map {

    JFrame frame;
    
    public Map() throws IOException {
        BufferedImage img = ImageIO.read(new File("src/main/resources/resources/screenshot.png"));
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
