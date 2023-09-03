package battleships;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author gmt3870
 */
public class HighScores extends JPanel{
    
    public HighScores(){
        JButton startButton = new JButton("Menu");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Menu");
            }
        });
        
        add(new JLabel("<html><h1><strong>High Scores</strong></h1></html>"));
        add(startButton);
    }
}
