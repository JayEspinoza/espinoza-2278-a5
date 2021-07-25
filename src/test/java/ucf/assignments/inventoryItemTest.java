package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class inventoryItemTest {
    inventoryItem myItem = new inventoryItem("20", "1234567891", "Name");

    @Test
    void editValue() {
        // User edits inventory value
        myItem.editValue("20");

        assertEquals(myItem.getValue(), "20");
    }

    @Test
    void editSerial() {
        // User edits serial number
        myItem.editSerial("1234567892");

        assertEquals(myItem.getSerial(), "1234567892");
    }

    @Test
    void editName() {
        // User edits name
        myItem.editName("Bob");

        assertEquals(myItem.getName(), "Bob");
    }

    @Test
    void getSerial() {
        assertEquals(myItem.getSerial(), "1234567891");
    }

    @Test
    void getValue() {
        assertEquals(myItem.getValue(), "20");
    }

    @Test
    void getName() {
        assertEquals(myItem.getName(), "Name");
    }
}