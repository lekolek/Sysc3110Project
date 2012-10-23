import java.util.*;
/**
 * Abstract class ItemHolder - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class ItemHolder {
    protected List<Item> items;
    
    public ItemHolder() {
        items = new ArrayList<Item>();
    }
    
    public void insertItem(Item item) {
        items.add(item);
    }
    
    public void removeItem(Item item) {
        if (items.contains(item)) items.remove(item);
    }
    
    public void removeItem(String itemName) {
        for (Item item : items )
            if (item.getName().equals(itemName)) removeItem(item);
    }

    public String getAllItems() {
        String allItems = new String();
        Iterator iterator = items.iterator();
        
        while(iterator.hasNext()) {
            allItems = allItems + " " + iterator.next();
        }
        return allItems;
    }
    
    public List<Item> getItemList() {
        return items;
    }
}
