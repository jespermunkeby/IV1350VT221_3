package model;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    @org.junit.jupiter.api.Test
    void addItemByID() {
        main.model.Sale s = new main.model.Sale(new main.integration.Integration());
        int falseID = 40;
        int itemID = 1;
        int availableItemQuantity = 5;
        float price = 12.5f;

        assertFalse(s.addItemByID(falseID, 1));
        assertFalse(s.addItemByID(itemID, availableItemQuantity+1));
        assertTrue(s.addItemByID(itemID, 1));
        assertEquals(price, s.getSaleInfo().getTotalPrice());
        assertTrue(s.addItemByID(itemID, 1));
        assertEquals(price*2, s.getSaleInfo().getTotalPrice());
    }

    @org.junit.jupiter.api.Test
    void finishSale() {
        //this is really an extended getter
    }
}