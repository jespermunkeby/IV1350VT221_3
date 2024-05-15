package exceptionHandling;

/**
 * Thrown when item does not exist in Inventory System.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Creates a new instance including a message and what item ID
     * could not be found.
     */
    public ItemNotFoundException(int itemID) {
        super("Item with id \"%d\" does not exist in inventory system.".formatted(itemID));
    }
}