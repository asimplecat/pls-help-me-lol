package numbertile;


import java.util.ArrayList ;
import java.util.Random;
        
/**
 * A NumberTile is a square tile with an int between 1 and 9, inclusive, on
 * each side
 */
public class NumberTile 
{
    private ArrayList<Integer> tile ;
    private Random generator;    
    /**
     * Create a NumberTile object using 4 random ints in the range 1..9
     */
    public NumberTile() 
    {
        tile = new ArrayList<Integer>();
        generator = new Random();
        tile.add(generator.nextInt(9)+1);
        tile.add(generator.nextInt(9)+1);
        tile.add(generator.nextInt(9)+1);
        tile.add(generator.nextInt(9)+1);
        

    }
    
    /**
     * Rotate this tile 90 degrees clockwise
     */
    public void rotate() 
    { 
        int tobesaved = tile.get(3);
        
        tile.set(3,tile.get(2));
        tile.set(2,tile.get(1));
        tile.set(1,tile.get(0));
        tile.set(0,tobesaved);
    }
    
    /**
     * Get the number on the left side of this tile
     * @return the number on the left side of this tile
     */
    public int getLeft()
    {
    	// DO NOT MODIFY THIS METHOD!
        // =========================
        return tile.get(0) ;
    }
    
    /**
     * Get the number on the right side of this tile
     * @return the number on the right side of this tile
     */
    public int getRight() 
    {
        // DO NOT MODIFY THIS METHOD!
        // =========================
        return tile.get(2) ;
    }    
    
    /** 
     * Return a String representation of this tile in the form
     * 
     *    4
     * 5     7
     *    1
     * 
     * @return the tile as a multi-line String 
     */
    public String toString() 
    {
        String result = ("   " + tile.get(1) + "\n" + tile.get(0) + "     " + 
                tile.get(2) + "\n   " + tile.get(3));       
       return result;
    }    
} // end of NumberTile class
