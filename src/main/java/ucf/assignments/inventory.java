package ucf.assignments;

import java.util.ArrayList;

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
            returnList += String.format("%-10s\t %-15s\t %s\n", listPrint.get(i).getValue(), listPrint.get(i).getSerial(), listPrint.get(i).getName());
        }

        return returnList;
    }

    // Method sortByValue sorts the list by the value parameter
    public ArrayList<inventoryItem> sortByValue(){
        // Create a new list
        ArrayList<inventoryItem> sortedList = new ArrayList<>();
        double biggestNum = -1;
        int currentBig = 0;
        // Loop through the main list
        for(int i = 0; i < inventoryList.size(); i++) {
            // Determine which values are the greatest and move them
            // over to the new list
            for(int j = 0; j < inventoryList.size() - i; j++){
                if(Double.parseDouble(inventoryList.get(j).getValue()) > biggestNum){
                    biggestNum = Double.parseDouble(inventoryList.get(j).getValue());
                    currentBig = j;
                }
            }

            sortedList.add(inventoryList.get(currentBig));
            biggestNum = -1;
            currentBig = 0;
        }

        return sortedList;
    }

    // Method sortBySerial sorts the list by serial numbers
    public ArrayList<inventoryItem> sortBySerial(){
        // Create a new list
        ArrayList<inventoryItem> sortedList = new ArrayList<>();
        String comparedString = "0000000000";
        int currentBig = 0;
        char [] splitStringMain = comparedString.toCharArray();
        char [] splitStringSecondary;
        int charTracker = 1;

        // Loop through the main list
        for(int i = 0; i < inventoryList.size(); i ++) {
            for(int j = 0; j < inventoryList.size() - i; j++) {
                splitStringSecondary = inventoryList.get(j).getSerial().toCharArray();
                // Determine which serial is the greatest by comparing the first char
                // If same char, move onto the next char
                if(splitStringMain[0] == splitStringSecondary[0]){
                    while(charTracker != splitStringMain.length){
                        if(splitStringMain[charTracker] == splitStringSecondary[charTracker]) {
                            charTracker++;
                            continue;
                        }
                        else if(splitStringMain[charTracker] > splitStringSecondary[charTracker]) {
                            break;
                        }
                        else if(splitStringMain[charTracker] < splitStringSecondary[charTracker]){
                            comparedString = inventoryList.get(j).getSerial();
                            splitStringMain = comparedString.toCharArray();
                            currentBig = j;
                            break;
                        }
                    }
                    charTracker = 1;
                }
                else if(splitStringMain[0] < splitStringSecondary[0]){
                    comparedString = inventoryList.get(j).getSerial();
                    splitStringMain = comparedString.toCharArray();
                    currentBig = j;
                }
            }

            sortedList.add(inventoryList.get(currentBig));
        }

        return sortedList;
    }

    // Method sortByName sorts the list by name
    public ArrayList<inventoryItem> sortByName(){
        // Create a new list
        ArrayList<inventoryItem> sortedList = new ArrayList<>();
        String comparedString = "0000000000";
        int currentBig = 0;
        char [] splitStringMain = comparedString.toCharArray();
        char [] splitStringSecondary;
        int charTracker = 1;

        // Loop through the main list
        for(int i = 0; i < inventoryList.size(); i ++) {
            for(int j = 0; j < inventoryList.size() - i; j++) {
                splitStringSecondary = inventoryList.get(j).getName().toCharArray();
                // Determine which name is the greatest by comparing the first char
                // If same char, move onto the next char
                if(splitStringMain[0] == splitStringSecondary[0]){
                    while(charTracker != splitStringMain.length){
                        if(splitStringMain[charTracker] == splitStringSecondary[charTracker]) {
                            charTracker++;
                            continue;
                        }
                        else if(splitStringMain[charTracker] > splitStringSecondary[charTracker]) {
                            break;
                        }
                        else if(splitStringMain[charTracker] < splitStringSecondary[charTracker]){
                            comparedString = inventoryList.get(j).getName();
                            splitStringMain = comparedString.toCharArray();
                            currentBig = j;
                            break;
                        }
                    }
                    charTracker = 1;
                }
                else if(splitStringMain[0] < splitStringSecondary[0]){
                    comparedString = inventoryList.get(j).getName();
                    splitStringMain = comparedString.toCharArray();
                    currentBig = j;
                }
            }

            sortedList.add(inventoryList.get(currentBig));
        }

        return sortedList;
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
        if(newName.length() >= 2)
            return true;

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
}
