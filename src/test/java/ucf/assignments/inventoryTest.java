package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class inventoryTest {


    @Test
    void addItem() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        myInventory.addItem(myItem);

        assertEquals(myInventory.inventoryList.get(0).getValue(), "20");
    }

    @Test
    void removeItem() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        myInventory.addItem(myItem);

        // User removes item from inventory
        myInventory.removeItem("1234567893");
        assertEquals(myInventory.inventoryList.size(), 0);
    }

    @Test
    void printList() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        myInventory.addItem(myItem);
        String output = String.format("%-10s\t %-15s\t %s\n", "Value", "Serial Number", "Name");
        output += String.format("$%-10s\t %-15s\t %s\n", myItem.getValue(), myItem.getSerial(), myItem.getName());

        assertEquals(myInventory.printList(myInventory.inventoryList), output);
    }

    @Test
    void sortByValue() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        inventoryItem myItem2 = new inventoryItem("21", "1234567894", "Name2");
        myInventory.addItem(myItem);
        myInventory.addItem(myItem2);

        // User sorts by value
        myInventory.sortByValue();
        assertEquals(myInventory.inventoryList.get(1).getValue(), "21");
    }

    @Test
    void sortBySerial() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        inventoryItem myItem2 = new inventoryItem("21", "1234567894", "Name2");
        myInventory.addItem(myItem);
        myInventory.addItem(myItem2);

        // User sorts by serial
        myInventory.sortBySerial();
        assertEquals(myInventory.inventoryList.get(1).getSerial(), "1234567894");
    }

    @Test
    void sortByName() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        inventoryItem myItem2 = new inventoryItem("21", "1234567894", "Name2");
        myInventory.addItem(myItem);
        myInventory.addItem(myItem2);

        // User sorts by serial
        myInventory.sortByName();
        assertEquals(myInventory.inventoryList.get(0).getName(), "Name");

    }

    @Test
    void findSerial() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        myInventory.addItem(myItem);

        // User searches for the serial
        assertEquals(myInventory.findSerial("1234567893").getValue(), "20");
    }

    @Test
    void findName() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        myInventory.addItem(myItem);

        // User searches for the name
        assertEquals(myInventory.findName("Name").getValue(), "20");
    }

    @Test
    void validateName() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User inputs a name
        assertEquals(myInventory.validateName("Hello"), true);
    }

    @Test
    void validateSerial() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User inputs a serial number
        assertEquals(myInventory.validateSerial("1234"), false);
    }

    @Test
    void validateValue() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User inputs a value
        assertEquals(myInventory.validateValue("20"), true);
    }

    @Test
    void printItem() {
        // User loads inventory
        inventory myInventory = new inventory();

        // User adds a new item to the inventory
        inventoryItem myItem = new inventoryItem("20", "1234567893", "Name");
        String output = String.format("%-10s\t %-15s\t %s\n", "Value", "Serial Number", "Name");
        output += String.format("$%-10s\t %-15s\t %s\n", myItem.getValue(), myItem.getSerial(), myItem.getName());

        assertEquals(myInventory.printItem(myItem), output);

    }
}