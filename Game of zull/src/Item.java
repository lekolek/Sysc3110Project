
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String itemName;
    private String itemDescription;
    private int itemWeight;

    public Item(String name) {
        itemName = name;
        itemDescription = "";
        itemWeight = 0;
    }

    public String getName() {
        return itemName;
    }
    
    public String getDescription() {
        return itemDescription;
    }
    
    public int getWeight() {
        return itemWeight;
    }
    
    public void setName (String s) {
        itemName = s;
    }
    
    public void setDescriptiong(String s) {
        itemDescription = s;
    }
    
    public void setWeight(int i) {
        itemWeight = i;
    }
    
    public String toString() {
        return itemName;
    }
}
