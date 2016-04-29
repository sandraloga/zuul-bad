import java.util.HashMap;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    private HashMap <String,Option> comandos;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        comandos = new HashMap<>();
        comandos.put("andare",Option.GO);
        comandos.put("uscita",Option.QUIT);
        comandos.put("Solucionado el bug",Option.HELP);
        comandos.put("guardare",Option.LOOK);
        comandos.put("mangiare",Option.EAT);
        comandos.put("ritorno",Option.BACK);
        comandos.put("prendere",Option.TAKE);
        comandos.put("lasciare",Option.DROP);
        comandos.put("elemnti",Option.ITEMS);
        comandos.put("sconosciuto",Option.UNKNOWN);

    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {

        return comandos.containsKey(aString);
    }

    /**
     * Return the object Option associated with a word.
     * @param commandWord The word to look up (as a string).
     * @return the object Option correspondng to the paramater commandWord, or the object Option.UNKNOWN
     *         if it is not a valid command word
     */
    public Option getCommandWord(String commandWord)
    {
        Option optionValido = null;
        if (isCommand(commandWord))
        {
            optionValido=comandos.get(commandWord);
        }
        return optionValido;
    }

    /**
     * Print all valid commands to System.out
     */
    public void showAll()
    {
        for (String comando : comandos.keySet()){
            System.out.println(comando + ";");
        }
        System.out.println();
    }
}
