import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ItemHolder{
    private Room currentRoom;
    
    public Player() {
        currentRoom = null;
    }
    
    public Room getRoom() {
        return currentRoom;
    }

    public void setRoom(Room room) {
        currentRoom = room;
    } 
    
    public void goRoom(String room) {
        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = currentRoom.getExitRoom(room);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            currentRoom.look();
        }
    }
    
    public void pickUpItem(String itemName) {
        Item removingItem = null;
        
        for (Item item : currentRoom.getItemList()) {
            if (item.getName().equals(itemName)) {
                removingItem = item;
            }
        }
        currentRoom.removeItem(removingItem);
        insertItem(removingItem);
        System.out.println(removingItem + " has been picked up");
    }
    
    public void dspInventory() {
        String allItems = getAllItems();
        System.out.print("Inventory:");
        if (allItems.length()>0) System.out.print(allItems);
        else System.out.print(" -Empty-");
        System.out.println();
    }
}
