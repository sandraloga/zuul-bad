import java.util.ArrayList;
import java.util.Stack;
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
    public static final float LIMITE_PESO = 50;   
    private Room currentRoom;
    private Stack <Room> salas;

    /**
     * Constructor for objects of class Player
     */
    public Player(Room currentRoom)
    {
        // initialise instance variables
        this.currentRoom =  currentRoom;
        itemsPlayer = new ArrayList<Item>();
        pesoTotal = 0;
        salas = new Stack<>();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();

        printLocationInfo();

        System.out.println();
    } 

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public void goRoom(Command command) 
    {

        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.

        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            salas.push(currentRoom);
            currentRoom = nextRoom;
            printLocationInfo();
            System.out.println();
        }
    }

    /**
     * 
     */
    public void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());

    }

    /**
     * da opcion a elegir item y controla que no sobrepasa el peso limite
     */

    public void cogerItem (Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Que quieres coger?");
            return;
        }
        String itemElegido = command.getSecondWord();

        Item item = currentRoom.buscarItem(itemElegido);
        if (item == null)
        {
            System.out.println("No existe item con ese nombre");
        }
        else if(LIMITE_PESO >= getPesoTotal() + item.getPeso()) {
            addItem(currentRoom.borrarItem(item));
        }
        else{
            System.out.println ("El peso ha sido sobrepasado!!!");
        }

    }

    /**
     * elimina el item y lo deja en la sala
     */
    public void drop(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Que quieres coger?");
            return;
        }

        String descripcionItem = command.getSecondWord();
        Item item = buscarItemPlayer(descripcionItem);

        if ( item == null)
        {
            System.out.println("No hay items en la bolsa");
        }else
        {
            currentRoom.addItem(borrarItem(item));
            restaPeso(item.getPeso());
        }
    }

    /**
     * vuelve a la sala anterior
     */
    public void back()
    {
        if ( !salas.empty())
        {
            currentRoom = salas.pop();
            printLocationInfo();

        }else
        {
            System.out.println ("Estas en la entrada");
        }

    }

    /**
     * devuelve la habitacion actual
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * resta peso al jugador del item dejado
     */
    public void restaPeso( float peso)
    {
        pesoTotal -= peso;
    }

    /**
     * añadir items a la lista
     * 
     */
    public void addItem(Item item)
    {

        itemsPlayer.add(item);
        setPesoTotal(item.getPeso());
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

    /**
     * busca los items del jugador
     */
    public Item buscarItemPlayer(String itemBuscado)
    {
        Item itemEncontrado = null;
        for (Item item : itemsPlayer)
        {
            if (item.descripcionItem().equals(itemBuscado))
            {
                itemEncontrado = item;
            }

        }
        return itemEncontrado;
    }

    /**
     * muestra los items que tiene el jugador
     */
    public String muestraItems()
    {
        String descripcion = "Peso: " + getPesoTotal() + 
            "\n" + "Los items que tienes son: "  + "\n";
        if (itemsPlayer.size()==0)
        {
            descripcion += "No hay items" + ".\n";
        }else
        {

            for(Item  item : itemsPlayer)
            {
                descripcion+= "El nombre del item es: " + item.descripcionItem()+
                    " y su peso es : " + item.getPeso() + ".\n";
            }
        }
        return descripcion;
    }

    /**
     * elimina un item
     */
    public Item borrarItem(Item item)
    {
        Item itemBuscado =item;
        if (item != null)
        {
            itemsPlayer.remove(item);
        }
        return itemBuscado;
    }
}
