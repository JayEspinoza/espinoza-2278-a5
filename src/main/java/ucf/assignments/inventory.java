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
        String returnList = String.format("%.15s %.15s %s\n", "Value", "Serial Number", "Name");

        // Loop through the list
        for(int i = 0; i < listPrint.size(); i++) {
            // Add the proper values to their spots in the string
            // according to the format
            returnList += String.format("%.15s %.15s %s\n", listPrint.get(i).getValue(), listPrint.get(i).getSerial(), listPrint.get(i).getName());
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


}
