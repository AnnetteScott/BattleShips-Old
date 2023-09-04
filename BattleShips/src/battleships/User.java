package battleships;
import static battleships.GamePage.BOARD_SIZE;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author gmt3870
 */
public abstract class User {
    public final String name;
    private int score;
    private final Cell[][] grid;
    private final List<Ship> ships;
    private final Set<Cell> shotsTaken;
    
    public User(String name, int score) {
        this.name = name;
        this.score = score;
        
        grid = new Cell[BOARD_SIZE][BOARD_SIZE];
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                grid[x][y] = new Cell(x, y);
            }
        }
        ships = new ArrayList<>();
        shotsTaken = new HashSet<>();
        placeShips();
    }
    
    /**
     * Place the player's ships on their board
     */
    private void placeShips(){
        Random random = new Random();
        int shipsPlaced = 0;
        int[] shipLengths = {5, 4, 3, 3, 2};
        
        while(shipsPlaced < shipLengths.length){
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            
            Ship nextShip = new Ship(shipLengths[shipsPlaced]);
            boolean placed = placeShip(nextShip, x, y, random.nextBoolean());
            if(placed){
                shipsPlaced++;
            }
        }
    }
    
    private boolean placeShip(Ship ship, int x, int y, boolean isVertical){
        if (!validPlacement(ship, x, y, isVertical)) {
            return false;
        }
        List<Cell> coord = new ArrayList<>();
        
        for (int i = 0; i < ship.getLength(); i++) {
            if (isVertical) {
                grid[x + i][y].state = CellState.Ship;
                coord.add(getGrid()[x + i][y]);
            } else {
                grid[x][y + i].state = CellState.Ship;
                coord.add(getGrid()[x][y + i]);
            }
        }
        ship.setCoord(coord);
        getShips().add(ship);
        
        return true;
    }
    
    /**
     * Check if coordinates are valid
     * @param ship Ship object
     * @param x int coordinate to place ship
     * @param y int coordinate to place ship
     * @param isVertical Boolean of whether the ship if vertical or not
     * @return Boolean if valid placement, false otherwise
     */
    private boolean validPlacement(Ship ship, int x, int y, boolean isVertical){
        if(isVertical){
            if(x + ship.getLength() > BOARD_SIZE){
                return false;
            }
        } else {
            if (y + ship.getLength() > BOARD_SIZE) {
                return false;
            }
        }
        
        for(int i = 0; i < ship.getLength(); i++){
            if(isVertical){
                if(getGrid()[x + i][y].state.equals(CellState.Ship)){
                    return false;
                }
            } else {
                if(getGrid()[x][y + i].state.equals(CellState.Ship)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param points update the score
     */
    public void updateScore(int points) {
        this.score += score;
    }

    /**
     * @return the grid
     */
    public Cell[][] getGrid() {
        return grid;
    }

    /**
     * @return the ships
     */
    public List<Ship> getShips() {
        return ships;
    }

    /**
     * @return the shotsTaken
     */
    public Set<Cell> getShotsTaken() {
        return shotsTaken;
    }
    
    
}
