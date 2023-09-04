package battleships;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author gmt3870
 */
public class GamePage extends JPanel{
    
    final static int BOARD_SIZE = 10;
    
    public GamePage(){
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JPanel header = new JPanel();
        header.setSize(1200, 40);
        header.setPreferredSize(new Dimension(1200, 40));
        
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "Menu");
            }
        });

        header.add(menuButton);
        add(header);
        
        JPanel gameBoard = new JPanel(new GridLayout(BOARD_SIZE + 1, BOARD_SIZE + 1));
        gameBoard.setSize(300, 300);
        gameBoard.add(new JLabel());
        for(int i = 0; i < BOARD_SIZE; i++){
            char letter = (char)('A' + i);
            JLabel display = new JLabel(String.valueOf(letter));
            display.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            gameBoard.add(display);
        }
        
        for(int i = 0; i < BOARD_SIZE; i++){
            JLabel num = new JLabel(String.valueOf(i + 1));
            num.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            gameBoard.add(num);
            
            for(int j = 0; j < BOARD_SIZE; j++){
                JLabel display = new JLabel();
                display.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                gameBoard.add(display);
            }
            
        }
        
        add(gameBoard, BorderLayout.CENTER);
    }
}
