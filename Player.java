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
    private float pesoTotal;
    public static final float LIMITE_PESO= 50;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        itemsPlayer = new ArrayList<Item>();
        pesoTotal = 0;
    }

    /**
     * añadir items a la lista
     * 
     */
    public void addItem(Item item)
    {
        
        itemsPlayer.add(item);
        
    }
    /**
     * devuelve el peso del jugador
     */
    public float getPesoTotal()
    {
        return pesoTotal;
    }
    
    /**
     * suma del peso al peso tota
     */
    public void setPesoTotal( float peso)
    {
        pesoTotal += peso;
    }
}
