package model;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    @org.junit.jupiter.api.Test
    void addItemByID() {
        model.Sale s = new model.Sale(new integration.Integration());
        int falseID = 40;
        int itemID = 1;
        int availableItemQuantity = 5;
        float price = 12.5f;

        // Assert that an exception is thrown when a false item ID is used
        assertThrows(Exception.class, () -> s.addItemByID(falseID, 1));

        // Assert that an exception is thrown when requesting more items than available
        assertThrows(Exception.class, () -> s.addItemByID(itemID, availableItemQuantity + 1));

        // Assert that no exception is thrown when adding a valid item with valid quantity
        assertDoesNotThrow(() -> s.addItemByID(itemID, 1));
        // Check if the total price is as expected after adding the item
        assertEquals(price, s.getSaleInfo().getTotalPrice());

        // Assert that adding another unit of the item does not throw an exception
        assertDoesNotThrow(() -> s.addItemByID(itemID, 1));
        // Check if the total price is updated correctly
        assertEquals(price * 2, s.getSaleInfo().getTotalPrice());
    }
}
