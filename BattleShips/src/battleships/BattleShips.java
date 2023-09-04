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
        frame.setSize(1200, 700);
        frame.setLocation(1500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainMenu mainMenu = new MainMenu();
        GamePage gamePage = new GamePage();
        HighScores highScores = new HighScores();

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(mainMenu, "Menu");
        mainPanel.add(gamePage, "Game");
        mainPanel.add(highScores, "Scores");

        cardLayout.show(mainPanel, "Menu");

        frame.add(mainPanel);

        frame.setVisible(true);
    }
}
