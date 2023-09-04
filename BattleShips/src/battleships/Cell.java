package battleships;

/**
 * Cell object with coordinates and state
 * @author gmt3870
 */
public class Cell {
    public int x;
    public int y;
    public CellState state;
    
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        state = CellState.Empty;
    }
}
