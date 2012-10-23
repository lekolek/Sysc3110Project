import java.util.ArrayList;
import java.util.Stack; //E.K

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ItemHolder{
    private Room currentRoom;
    private Stack<Room> steps; // to keep track of the Steps taken to get to the Current Location.
    
    public Player() {
        currentRoom = null;
        steps = new Stack<Room>();
    }
    
    public Room getRoom() {
        return currentRoom;
    }

    public void setRoom(Room room) {
    	steps.push(currentRoom);
        currentRoom = room;
    } 
    
    public void goRoom(String room) {
        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = currentRoom.getExitRoom(room);

        if (nextRoom == null) {
        	if(!room.equalsIgnoreCase("back")) // undo command E.K
        	{
        		System.out.println("There is no door!");
        		nextRoom = currentRoom; // for refactoring the Else to get a more efficient Code for adding the Undo Command ( Go back). E.K
        	}
        } 
        //else { else has been refactored.
        	if(room.equalsIgnoreCase("back"))
        	{
        		//if(steps.isEmpty()) for some reason the newly created stack shows elementCount = 1, but there is no elements in it. there fore:   E.K
        		if(steps.size()<=1)
        		{
        			System.out.println("You are where you started.");
        			nextRoom=currentRoom;
        		}
        		else
        		{
        			nextRoom = steps.pop();
        		}
        	}
        	else if(nextRoom != currentRoom)//Keeping track of the steps. E.K
        	{
        		steps.push(currentRoom);
        	}
            currentRoom = nextRoom;
            currentRoom.look();
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
