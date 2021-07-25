package ucf.assignments;

import java.util.ArrayList;
import java.util.Comparator;

public class inventoryItem {
    // Create private variables "value," "serial," and "name"
    private String value, serial, name;

    public inventoryItem(String newValue, String newSerial, String newName) {
        // Set class variables to their respective values
        value = newValue;
        serial = newSerial;
        name = newName;
    }

    // Method editValue edits item value
    public void editValue(String newValue) {
        // Set value to newValue
        value = newValue;
    }

    // Method editSerial edits item serial
    public void editSerial(String newSerial) {
        // Set serial to newSerial
        serial = newSerial;
    }

    // Method editName edits the item name
    public void editName(String newName) {
        // Set name to newName
        name = newName;
    }

    // Method getSerial returns serial
    public String getSerial() {
        // Return serial
        return serial;
    }

    // Method getValue returns value
    public String getValue() {
        // Return value
        return value;
    }

    // Method getName returns name
    public String getName() {
        // Return name
        return name;
    }

    public static Comparator<inventoryItem> serialComparator = new Comparator<inventoryItem>() {
        public int compare(inventoryItem itemOne, inventoryItem itemTwo) {
            String itemSerialOne = itemOne.getSerial().toUpperCase();
            String itemSerialTwo = itemTwo.getSerial().toUpperCase();

            return itemSerialOne.compareTo(itemSerialTwo);
        }
    };

    public static Comparator<inventoryItem> nameComparator = new Comparator<inventoryItem>() {
        public int compare(inventoryItem itemOne, inventoryItem itemTwo) {
            String itemNameOne = itemOne.getName().toUpperCase();
            String itemNameTwo = itemTwo.getName().toUpperCase();

            return itemNameOne.compareTo(itemNameTwo);
        }
    };

    public static Comparator<inventoryItem> valueComparator = new Comparator<inventoryItem>() {
        public int compare(inventoryItem itemOne, inventoryItem itemTwo) {
            String itemValueOne = itemOne.getValue().toUpperCase();
            String itemValueTwo = itemTwo.getValue().toUpperCase();

            return itemValueOne.compareTo(itemValueTwo);
        }
    };
}
