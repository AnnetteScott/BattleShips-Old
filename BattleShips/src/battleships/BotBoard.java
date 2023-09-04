package battleships;
import static battleships.GamePage.BOARD_SIZE;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author gmt3870
 */
public class BotBoard extends JPanel{
    
    public BotBoard(Player player){
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
        
        for(int y = 0; y < BOARD_SIZE; y++){
            JLabel num = new JLabel(String.valueOf(y + 1), SwingConstants.CENTER);
            num.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            num.setPreferredSize(dim);
            add(num);
            
            for(int x = 0; x < BOARD_SIZE; x++){
                JButton cell = new JButton();
                cell.setBackground(Color.WHITE);
                cell.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                cell.setPreferredSize(dim);
                final int row = x;
                final int col = y;
                cell.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CellState state = player.getGrid()[col][row].state;
                        if(state.equals(CellState.Empty)){
                            cell.setBackground(Color.GREEN);
                            cell.setEnabled(false);
                            player.getGrid()[col][row].state = CellState.Miss;
                        }
                        else if(state.equals(CellState.Ship)){
                            cell.setBackground(Color.RED);
                            cell.setEnabled(false);
                            player.getGrid()[col][row].state = CellState.Hit;
                        }
                    }
                });
                
                add(cell);
            }
        }
    }
    
}
