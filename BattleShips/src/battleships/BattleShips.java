package battleships;
import javax.swing.*;
import java.awt.*;

/**
 * Entry point for battleships
 * @author gmt3870
 */
public class BattleShips {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Battleships");
        frame.setSize(1000, 800);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }
}
