
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();

    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room entrada, bolas, bicis,atracciones,videojuegos,cafeteria;

        // create the rooms
        entrada = new Room("hall de entrada");
        bolas = new Room("sala de bolas");
        bicis = new Room("circuito de bicicletas");
        atracciones = new Room("sala de atracciones");
        videojuegos = new Room("sala de videojuegos");
        cafeteria = new Room ("cafeteria");

        //creamos items
        Item itemPerchero =new Item ("perchero", 10.5F); 
        Item itemTaburete = new Item ("taburete", 5.3F);
        Item itemZapatero = new Item ("zapatero",15.5F);
        Item itemBolas = new Item ("bolas",6.5F);
        Item itemBanco = new Item ("banco", 7.3F);
        Item itemConos = new Item ("conos",0.5F);
        Item itemBici = new Item ("bici", 15.2F);
        Item itemTriciclo = new Item ("triciclo",3.2F);
        Item itemSillon = new Item ("sillon", 25.7F);
        Item itemEspejo = new Item ("espejo", 5.6F);
        Item itemBaul = new Item("baúl", 15.6F);
        Item itemHeroe = new Item ("superheroe", 35.9F);
        Item itemPantalla = new Item("pantalla",5.3F);
        Item itemSillonE = new Item ("sillón", 10.2F);
        Item itemMesa =new Item ("mesa", 7.5F);

        // initialise room exits
        entrada.setExit("west",bolas);
        entrada.setExit("southEast",videojuegos);

        bolas.setExit("east",entrada);
        bolas.setExit("south",bicis);
        bolas.setExit("southEast",atracciones);

        bicis.setExit("north",bolas);
        bicis.setExit("east",atracciones);
        bicis.setExit("southEast",cafeteria);

        atracciones.setExit("northWest",bolas);
        atracciones.setExit("west",bicis);
        atracciones.setExit("east",videojuegos);
        atracciones.setExit("south",cafeteria);

        videojuegos.setExit("northWest",entrada);
        videojuegos.setExit("west",atracciones);

        cafeteria.setExit("north",atracciones);
        cafeteria.setExit("northWest",bicis);

        // añadimos items
        entrada.addItem(itemPerchero);
        entrada.addItem(itemTaburete);

        bolas.addItem(itemZapatero);
        bolas.addItem(itemBolas);
        bolas.addItem(itemBanco);

        bicis.addItem(itemConos);
        bicis.addItem(itemBici);
        bicis.addItem(itemTriciclo);

        atracciones.addItem(itemSillon);
        atracciones.addItem(itemEspejo);
        atracciones.addItem(itemBaul);
        atracciones.addItem(itemHeroe);

        videojuegos.addItem(itemPantalla);
        videojuegos.addItem(itemSillonE);

        cafeteria.addItem(itemTaburete);
        cafeteria.addItem(itemMesa);

        player = new Player(entrada);

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        player.printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }


    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            player.goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
        else if (commandWord.equals("eat")) {
            System.out.println ("You have eaten now and you are not hungry any more");
        }
        else if (commandWord.equals("back")){
            player.back();
        }
        else if (commandWord.equals("take")) {
            player.cogerItem(command);
        }
        else if (commandWord.equals("drop")){
            player.drop(command);
        }
        else if (commandWord.equals("items")){
            System.out.println(player.muestraItems());
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.muestraComandos();
    }



    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }


    
}
