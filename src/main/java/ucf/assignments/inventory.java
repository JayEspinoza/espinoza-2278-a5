package ucf.assignments;

import java.util.ArrayList;

public class inventory {
    ArrayList<inventoryItem> inventoryList = new ArrayList<>();

    // Method addItem adds an item to the list
    public void addItem(inventoryItem newItem){
        // Add item to list
        inventoryList.add(newItem);
    }

    // Method removeItem removes an item from the list
    public void removeItem(String serialRemove){
        // Loop through list until the item is found
        for(int i = 0; i < inventoryList.size(); i++){
            // Remove item if found
            if(inventoryList.get(i).getSerial().equals(serialRemove))
                inventoryList.remove(i);
        }
    }
}
