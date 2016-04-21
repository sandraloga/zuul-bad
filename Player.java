import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private ArrayList<Item> itemsPlayer;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        itemsPlayer = new ArrayList<Item>();
    }

    /**
     * añadir items a la lista
     * 
     */
    public void addItem(Item item)
    {
        itemsPlayer.add(item); 
    }
}
