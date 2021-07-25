package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.concurrent.Task;

import java.io.File;

public class InventoryController {
    inventory inventoryManager = new inventory();

    @FXML
    private TextArea textWindow;

    @FXML
    public void addItemClick(ActionEvent actionEvent) {
        // Prompt user for Inventory item parameters
        String ui1, ui2, ui3;
        ui1 = "";
        ui2 = "";
        ui3 = "";
        inventoryItem newItem;

        TextInputDialog valueDialog = new TextInputDialog("Value");
        TextInputDialog serialDialog = new TextInputDialog("Serial");
        TextInputDialog nameDialog = new TextInputDialog("Name");


        valueDialog.setTitle("Item Value");
        valueDialog.setHeaderText("Enter a value for the item. (I.E. 20.24)");
        valueDialog.setContentText("Value:");

        while(!inventoryManager.validateValue(ui1)) {
            ui1 = valueDialog.showAndWait().get();
        }

        serialDialog.setTitle("Serial Number");
        serialDialog.setHeaderText("Please Enter a Serial Number. (I.E. XXXXXXXXXX)");
        serialDialog.setContentText("Date:");

        while(!inventoryManager.validateSerial(ui2)){
            ui2 = serialDialog.showAndWait().get();
        }

        nameDialog.setTitle("Name");
        nameDialog.setHeaderText("Please Enter a Name. (I.E. Dog)");
        nameDialog.setContentText("Name:");

        while(!inventoryManager.validateName(ui3)){
            ui3 = nameDialog.showAndWait().get();
        }

        // Create new item and add the item to the list
        inventoryManager.addItem(newItem = new inventoryItem(ui1, ui2, ui3));
        textWindow.setText(inventoryManager.printList(inventoryManager.inventoryList));
    }

    @FXML
    public void loadClick(ActionEvent actionEvent) {
        // Prompt the user for the file name
        TextInputDialog dialog = new TextInputDialog("list");
        String ui = "";

        dialog.setTitle("Load List");
        dialog.setHeaderText("What is the name of the file? (I.E name.txt)");
        dialog.setContentText("Name:");

        ui = dialog.showAndWait().get();

        // Utilize the file output to load the list
        inventoryManager.loadInventory(ui);
        textWindow.setText(inventoryManager.printList(inventoryManager.inventoryList));
    }

    @FXML
    public void nameSearchClick(ActionEvent actionEvent) {
        // Prompt user for the name they want to search for
        TextInputDialog nameDialog = new TextInputDialog("Name");
        String ui = "";

        nameDialog.setTitle("Name");
        nameDialog.setHeaderText("Please Enter a Name. (I.E. Dog)");
        nameDialog.setContentText("Name:");

        while(!(inventoryManager.validateName(ui))){
            ui = nameDialog.showAndWait().get();
        }

        // Run search function
        textWindow.setText(inventoryManager.printItem(inventoryManager.findName(ui)));
    }

    @FXML
    public void nameSortClick(ActionEvent actionEvent) {
        // Sort by name and set text
        textWindow.setText(inventoryManager.printList(inventoryManager.sortByName()));
    }

    @FXML
    public void saveClick(ActionEvent actionEvent) {
        // Prompt the user for the file name
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("File Name");
        dialog.setHeaderText("What is the name of the file? (I.E name.txt)");
        dialog.setContentText("Name:");

        // Open a file
        File newFile = new File(dialog.showAndWait().get());
        // Write the list to the file
        inventoryManager.saveInventory(newFile);
    }

    @FXML
    public void serialSearchClick(ActionEvent actionEvent) {
        // Prompt user for the serial they want to search for
        TextInputDialog serialDialog = new TextInputDialog("Name");
        String ui = "";

        serialDialog.setTitle("Serial Number");
        serialDialog.setHeaderText("Please Enter a Serial Number");
        serialDialog.setContentText("Serial Number:");

        while(!(inventoryManager.validateSerial(ui))){
            ui = serialDialog.showAndWait().get();
        }

        // Run search function
        textWindow.setText(inventoryManager.printItem(inventoryManager.findSerial(ui)));
    }

    @FXML
    public void valueSortClick(ActionEvent actionEvent) {
        // Run sortByValue and output to screen.
        textWindow.setText(inventoryManager.printList(inventoryManager.sortByValue()));
    }

    @FXML
    public void editNameClick(ActionEvent actionEvent) {
        // Prompt user for item
        TextInputDialog nameDialog = new TextInputDialog("Name");
        TextInputDialog serialDialog = new TextInputDialog("Serial");
        String editItem = "";

        serialDialog.setTitle("Serial Number");
        serialDialog.setHeaderText("Enter the serial number of the item you want to change.");
        serialDialog.setContentText("Serial:");

        while(inventoryManager.findSerial(editItem).getName().equals("N/A")) {
            editItem = serialDialog.showAndWait().get();
        }

        // Prompt user for new name
        nameDialog.setTitle("Item Name");
        nameDialog.setHeaderText("Enter the new name.");
        nameDialog.setContentText("Item:");

        // Change item name
        inventoryManager.findSerial(editItem).editName(nameDialog.showAndWait().get());
        textWindow.setText(inventoryManager.printList(inventoryManager.inventoryList));
    }

    @FXML
    public void editValueClick(ActionEvent actionEvent) {
        // Prompt user for item
        TextInputDialog valueDialog = new TextInputDialog("Value");
        TextInputDialog serialDialog = new TextInputDialog("Serial");
        String itemSerial = "";
        String newValue = "";

        serialDialog.setTitle("Serial Number");
        serialDialog.setHeaderText("Enter the serial number of the item you want to change.");
        serialDialog.setContentText("Serial:");

        while(inventoryManager.findSerial(itemSerial).getName().equals("N/A")) {
            itemSerial = serialDialog.showAndWait().get();
        }

        // Prompt user for new name
        valueDialog.setTitle("Item Value");
        valueDialog.setHeaderText("Enter the new value.");
        valueDialog.setContentText("Value:");

        while(!inventoryManager.validateValue(newValue)){
            newValue = valueDialog.showAndWait().get();
        }

        // Change item value
        inventoryManager.findSerial(itemSerial).editValue(newValue);
        textWindow.setText(inventoryManager.printList(inventoryManager.inventoryList));
    }

    @FXML
    public void removeItemClick(ActionEvent actionEvent) {
        // Prompt the user for the item
        TextInputDialog dialog = new TextInputDialog("list");

        dialog.setTitle("Serial Number");
        dialog.setHeaderText("Enter the serial number of the item you want to remove.");
        dialog.setContentText("Serial Number:");

        // Remove the item from the list
        inventoryManager.removeItem(dialog.showAndWait().get());
        textWindow.setText(inventoryManager.printList(inventoryManager.inventoryList));
    }

    @FXML
    public void editSerialClick(ActionEvent actionEvent) {
        // Prompt user for item
        TextInputDialog replaceDialog = new TextInputDialog("Serial");
        TextInputDialog serialDialog = new TextInputDialog("Serial");
        String itemSerial = "";
        String newValue = "";

        serialDialog.setTitle("Serial Number");
        serialDialog.setHeaderText("Enter the serial number of the item you want to change.");
        serialDialog.setContentText("Serial:");

        while(inventoryManager.findSerial(itemSerial).getName().equals("N/A")) {
            itemSerial = serialDialog.showAndWait().get();
        }

        // Prompt user for new serial
        replaceDialog.setTitle("Item Serial");
        replaceDialog.setHeaderText("Enter the new serial.");
        replaceDialog.setContentText("Serial:");

        while(!inventoryManager.validateSerial(newValue)){
            newValue = replaceDialog.showAndWait().get();
        }

        // Change item value
        inventoryManager.findSerial(itemSerial).editSerial(newValue);
        textWindow.setText(inventoryManager.printList(inventoryManager.inventoryList));
    }

    @FXML
    public void serialSortClick(ActionEvent actionEvent) {
        // Sort by serial and set text
        textWindow.setText(inventoryManager.printList(inventoryManager.sortBySerial()));
    }
}
