import java.util.*;
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
public class Room extends ItemHolder {
    public String description;
    private Map<String, Room> exits;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(String roomName, Room roomType) 
    {
        exits.put(roomName, roomType);
    }
    
    public Room getExitRoom(String exitString) {
        return exits.get(exitString);
    }
    
    public String getAllExits() {
        String allExits = new String();
        Iterator iterator = exits.keySet().iterator();

        while(iterator.hasNext()){
            allExits = allExits + "  " + iterator.next();
        }
        return allExits;
    }
    
    public void look() {
        String tempItemList = getAllItems();
        
        System.out.println("You are " + getDescription());
        System.out.print("Items:");
        if (tempItemList.length()>0) System.out.print(getAllItems());
        else System.out.print(" -None-");
        System.out.println();
        System.out.print("Exits:");
        System.out.print(getAllExits());
        System.out.println();
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
