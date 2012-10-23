
/**
 * Enumeration class CommandTypes - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum CommandTypes {

    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), PICKUP("pickup"), UNKNOWN("?"), INVENTORY("inventory");

    private String commandString;
    
    CommandTypes(String commandString) {
        this.commandString = commandString;
    }
    
    public String toString() {
        return commandString;
    }
}
