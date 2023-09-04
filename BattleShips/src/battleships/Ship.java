package battleships;
import java.util.List;
import java.util.ArrayList;
/**
 * Ship class
 * @author gmt3870
 */
public class Ship {
    private final int length;
    private List<Cell> coordinates;
    
    public Ship(int len){
        length = len;
        coordinates = new ArrayList<>();
    }
    
    /**
     * Get the length of the ship
     * @return length of ship (int)
     */
    public int getLength(){
        return length;
    }
    
    /**
     * check if the ship has been hit
     * @param x int coordinate of the shot
     * @param y int coordinate of the shot
     * @return whether the ship was hit or not
     */
    public boolean isHit(int x, int y){
        for(Cell cell : coordinates){
            if(cell.x == x && cell.y == y){
                cell.state = CellState.Hit;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the ship has been sunk
     * @return whether the ship has been sunk or not
     */
    public boolean isSunk(){
        int numHits = 0;
        for(Cell cell : coordinates){
            if(cell.state.equals(CellState.Hit)){
                numHits++;
            }
        }
        return numHits >= length;
    }
    
    /**
     * Set the coordinates
     * @param coord List<Cell> of coordinates
     */
    public void setCoord(List<Cell> coord){
        coordinates = coord;
    }
}
