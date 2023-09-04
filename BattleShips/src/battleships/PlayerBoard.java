package battleships;
import static battleships.GamePage.BOARD_SIZE;
import static battleships.GamePage.state;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author gmt3870
 */
public class PlayerBoard extends JPanel{
    
    public PlayerBoard(){
        setLayout(new GridLayout(BOARD_SIZE + 1, BOARD_SIZE + 1));
        setSize(300, 300);
        
        JLabel topCell = new JLabel();
        topCell.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        Dimension dim = new Dimension(45, 45);
        topCell.setPreferredSize(dim);
        add(topCell);
        
        for(int i = 0; i < BOARD_SIZE; i++){
            char letter = (char)('A' + i);
            JLabel display = new JLabel(String.valueOf(letter), SwingConstants.CENTER);
            display.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            display.setPreferredSize(dim);
            add(display);
        }
        
        for(int i = 0; i < BOARD_SIZE; i++){
            JLabel num = new JLabel(String.valueOf(i + 1), SwingConstants.CENTER);
            num.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            num.setPreferredSize(dim);
            add(num);
            
            for(int j = 0; j < BOARD_SIZE; j++){
                JLabel cell = new JLabel();
                cell.setOpaque(true);
                cell.setBackground(Color.WHITE);
                cell.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                cell.setPreferredSize(dim);                
                
                add(cell);
            }
        }
    }
    
}
