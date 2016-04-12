
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
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room neighbor)
    {
        salidas.put(direction,neighbor);
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
