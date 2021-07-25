package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.concurrent.Task;

public class InventoryController {
    inventory inventoryManager = new inventory();

    @FXML
    private TextArea textWindow;

    @FXML
    public void addItemClick(ActionEvent actionEvent) {
        // Prompt user for Inventory tem parameters
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
        nameDialog.setHeaderText("Please Enter a Name. (I.E. Dog");
        nameDialog.setContentText("Name:");

        while(!inventoryManager.validateName(ui3)){
            ui3 = nameDialog.showAndWait().get();
        }

        // Create new item and add the item to the list
        inventoryManager.addItem(newItem = new inventoryItem(ui1, ui2, ui3));
        textWindow.setText(inventoryManager.printList(inventoryManager.inventoryList));
    }

    public void loadClick(ActionEvent actionEvent) {
    }

    public void valueSearchClick(ActionEvent actionEvent) {
    }

    public void nameSortClick(ActionEvent actionEvent) {
    }

    public void saveClick(ActionEvent actionEvent) {
    }

    public void serialSearchClick(ActionEvent actionEvent) {
    }

    public void valueSortClick(ActionEvent actionEvent) {
    }

    public void editNameClick(ActionEvent actionEvent) {
    }

    public void editValueClick(ActionEvent actionEvent) {
    }

    public void removeItemClick(ActionEvent actionEvent) {
    }

    public void editSerialClick(ActionEvent actionEvent) {
    }

    public void serialSortClick(ActionEvent actionEvent) {
    }
}
