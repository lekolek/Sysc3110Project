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
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandTypes> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandTypes>();
        for(CommandTypes command : CommandTypes.values()) {
            if(command != CommandTypes.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandTypes getCommandWord(String commandWord)
    {
        CommandTypes command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        } else {
            return CommandTypes.UNKNOWN;
        }
    }
    
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    public void showAll() {
        for(String command : validCommands.keySet())
            System.out.print(command + "  ");
        System.out.println();
    }
}