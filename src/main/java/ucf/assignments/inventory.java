package ucf.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class inventory {
    ArrayList<inventoryItem> inventoryList = new ArrayList<>();

    // Method getInventory returns inventoryList
    public ArrayList<inventoryItem> getInventoryList() {
        return inventoryList;
    }

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

    // Method printList prints the list inputted in a value, serial, name format
    public String printList(ArrayList<inventoryItem> listPrint){
        String returnList = String.format("%-10s\t %-15s\t %s\n", "Value", "Serial Number", "Name");

        // Loop through the list
        for(int i = 0; i < listPrint.size(); i++) {
            // Add the proper values to their spots in the string
            // according to the format
            returnList += String.format("$%-10s\t %-15s\t %s\n", listPrint.get(i).getValue(), listPrint.get(i).getSerial(), listPrint.get(i).getName());
        }

        return returnList;
    }

    // Method sortByValue sorts the list by the value parameter
    public ArrayList<inventoryItem> sortByValue(){
        // Run Comparator to sort by name
        Collections.sort(inventoryList, inventoryItem.valueComparator);
        return inventoryList;
    }

    // Method sortBySerial sorts the list by serial numbers
    public ArrayList<inventoryItem> sortBySerial(){
        // Run Comparator to sort by serial number
        Collections.sort(inventoryList, inventoryItem.serialComparator);
        return inventoryList;
    }

    // Method sortByName sorts the list by name
    public ArrayList<inventoryItem> sortByName(){
        // Run Comparator to sort by name
        Collections.sort(inventoryList, inventoryItem.nameComparator);
        return inventoryList;
    }

    // Method findSerial finds and returns the item associated
    // with the input serial number
    public inventoryItem findSerial(String serialTrack){
        inventoryItem placeholderItem = new inventoryItem("0", "XXXXXXXXXX", "N/A");

        // Loop through the list
        for(int i = 0; i < inventoryList.size(); i++) {
            // Return serial item if found
            if(inventoryList.get(i).getSerial().equals(serialTrack))
                return inventoryList.get(i);
        }

        // Otherwise return placeholder
        return placeholderItem;
    }

    // Method findName finds and returns the item associated
    // with the input name
    public inventoryItem findName(String nameTrack){
        inventoryItem placeholderItem = new inventoryItem("0", "XXXXXXXXXX", "N/A");

        // Loop through the list
        for(int i = 0; i < inventoryList.size(); i++) {
            // Return serial item if found
            if(inventoryList.get(i).getName().equals(nameTrack))
                return inventoryList.get(i);
        }

        // Otherwise return placeholder
        return placeholderItem;
    }

    // Method validateName checks to see if the name is valid
    public boolean validateName(String newName){
        if(newName.length() >= 2 && newName.length() <= 256)
            return true;
        else
            return false;
    }

    // Method validateSerial checks to see if a serial number
    // is valid
    public boolean validateSerial(String serialCheck){
        // Check to see if the String meets the required
        // length
        if(serialCheck.length() != 10){
            return false;
        }

        // Split the string into characters
        char [] splitSerial = serialCheck.toCharArray();

        // Check to see if each character is a letter or number
        for(char c : splitSerial){
            if((Character.isLetter(c)) || (Character.isDigit(c)))
                continue;
            else
                return false;
        }

        // Check to see if the serial already exists
        for(inventoryItem c : inventoryList){
            if(c.getSerial().equals(serialCheck))
                return false;
        }

        // Return true if so
        return true;
    }

    // Method validateValue checks to see if value is a
    // valid number
    public boolean validateValue(String newValue){
        // Check to see if value is a valid number
        try{
            Double.parseDouble(newValue);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    // Method printItem returns a single item string
    public String printItem(inventoryItem printedItem){
        // Assemble string
        String output = String.format("%-10s\t %-15s\t %s\n", "Value", "Serial Number", "Name");
        output += String.format("$%-10s\t %-15s\t %s\n", printedItem.getValue(), printedItem.getSerial(), printedItem.getName());

        return output;
    }

    // Method saveList saves a list to external storage
    public void saveInventory(File file){
        // Create a new scanner based on name
        String output = "";

        try {
            FileWriter writer = new FileWriter(file);
            // For loop through the list for the length of the list
            writer.write(String.format("%-10s\t %-15s\t %s\n", "Value", "Serial Number", "Name"));
            for(int i = 0; i < inventoryList.size(); i++){
                // Output each item to the newly created file
                writer.write(String.format("%-10s\t %-15s\t %s\n", inventoryList.get(i).getValue(), inventoryList.get(i).getSerial(), inventoryList.get(i).getName()));
            }
            // Close file
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Method loadInventory loads an inventory list
    public void loadInventory(String ui){
        clearList();
        // Open a file
        int i = 1;
        inventoryItem placeholderItem = new inventoryItem("0", "XXXXXXXXXX", "N/A");
        File loadedFile = new File(ui);
        ArrayList<String> loadedList = new ArrayList<>();

        try {
            Scanner reader = new Scanner(loadedFile);
            // While loop through the file until a blank line is reached
            while(reader.hasNextLine()) {
                // Add the results of each line to a list
                loadedList.add(reader.nextLine());
            }

            reader.close();
            splitList(loadedList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void splitList(ArrayList<String> loadedList) {
        String [] splitKeeper;
        inventoryItem newItem;

        // Loop through the list
        for(int i = 1; i < loadedList.size(); i++) {
            // Split the Strings into separate strings split by
            // the tab
            splitKeeper = loadedList.get(i).split("\t");

            // Create new items
            newItem = new inventoryItem(splitKeeper[0].replaceAll("\\s", ""), splitKeeper[1].replaceAll("\\s", ""), splitKeeper[2].replaceAll("\\s", ""));

            // Add the items to the inventory
            inventoryList.add(newItem);
        }
    }

    // Method clearList removes all items from the list
    private void clearList(){
        inventoryList.clear();
    }
}
