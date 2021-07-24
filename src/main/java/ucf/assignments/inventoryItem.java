package ucf.assignments;

import java.util.ArrayList;

public class inventoryItem {
    // Create private variables "value," "serial," and "name"
    private String value, serial, name;

    public inventoryItem(String newValue, String newSerial, String newName){
        // Set class variables to their respective values
        value = newValue;
        serial = newSerial;
        name = newName;
    }

    // Method editValue edits item value
    public void editValue(String newValue){
        // Set value to newValue
        value = newValue;
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

    // Method editSerial edits item serial
    public void editSerial(String newSerial){
        // Set serial to newSerial
        serial = newSerial;
    }

    // Method validateSerial checks to see if a serial number
    // is valid
    public boolean validateSerial(String serialCheck, ArrayList<inventoryItem> comparedList){
        // Check to see if the String meets the required
        // length
        if(serialCheck.length() != 10){
            return false;
        }

        // Split the string into characters
        char [] splitSerial = serialCheck.toCharArray();

        // Check to see if each character is a letter or number
        for(char c : splitSerial){
            if(!(Character.isLetter(c)) || !(Character.isDigit(c)))
                return false;
        }

        // Check to see if the serial already exists
        for(inventoryItem c : comparedList){
            if(c.getSerial().equals(serialCheck))
                return false;
        }

        // Return true if so
        return true;
    }

    // Method editName edits the item name
    public void editName(String newName){
        // Set name to newName
        name = newName;
    }

    // Method validateName checks to see if the name is valid
    public boolean validateName(String newName){
        if(newName.length() >= 2)
            return true;

        return false;
    }

    // Method getSerial returns serial
    public String getSerial(){
        // Return serial
        return serial;
    }

    // Method getValue returns value
    public String getValue(){
        // Return value
        return value;
    }

    // Method getName returns name
    public String getName(){
        // Return name
        return name;
    }
}
