package integration;
import dto.ItemDTO;
import dto.SaleInfoDTO;
import exceptionHandling.NoResponseException;

public class Integration {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private DiscountDatabase discountDatabase;

    public Integration(){
        this.accountingSystem = new AccountingSystem();
        this.inventorySystem = new InventorySystem();
        this.discountDatabase = new DiscountDatabase();
    }

    public ItemDTO getItemDTOByID(int id, int quantity) throws NoResponseException {
        try{
            return this.inventorySystem.occupyByID(id, quantity);
        } catch (NoResponseException ex) {
            throw new NoResponseException("inventory system"); //re-thrown to customize message.
        }
    }

    public void accountSale(SaleInfoDTO saleInfo)throws NoResponseException { //unchecked exception
        try {
            //Call to accounting system
        } catch (NoResponseException ex) {
            throw new NoResponseException("accounting system"); //re-throwing to modify message
            //possibility to write exception to log
        }
    }
}
