
import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String,Room> salidas;
   

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        salidas =  new HashMap <>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room southEast , Room northWest) 
    {
        if(north != null)
            salidas.put("north",north);
        if(east != null)
            salidas.put("east",east);
        if(south != null)
            salidas.put("south",south);
        if(west != null)
            salidas.put("west",west);
        if (west != null)
           salidas.put("west",west);
        if (southEast != null)
            salidas.put("southEast",southEast);
        if (northWest != null)
           salidas.put("northWest",northWest);

    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public Room getExit(String direcion)
    {
        Room roomDeVuelta  = null;
        if (direcion.equals("north")){
            roomDeVuelta = salidas.get("north");
        }
        if (direcion.equals("east")){
            roomDeVuelta = salidas.get("east");
        }
        if (direcion.equals("south")){
            roomDeVuelta = salidas.get("south");
        }
        if (direcion.equals("west")){
            roomDeVuelta = salidas.get("west");
        }
        if (direcion.equals("southEast")){
            roomDeVuelta = salidas.get("southEast");
        }
        if (direcion.equals("northWest")){
             roomDeVuelta = salidas.get("northWest");
        }
       
        return roomDeVuelta;

    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
        String salida  = "Exits: ";
        if (salidas.get("north") != null){
            salida += "north ";
        }
        if (salidas.get("east") != null){
            salida += "east ";
        }
        if (salidas.get("south") != null){
            salida += "south ";
        }
        if (salidas.get("west") != null){
            salida += "west ";
        }
        if (salidas.get("southEast") != null){
            salida += "southEast ";
        }
        if ( salidas.get("northWest") != null){
            salida += "northWest ";
        }
        return salida;
    
    }

}
