package integration;
import dto.ItemDTO;
import dto.SaleInfoDTO;

public class Integration {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private DiscountDatabase discountDatabase;

    public Integration(){
        this.accountingSystem = new AccountingSystem();
        this.inventorySystem = new InventorySystem();
        this.discountDatabase = new DiscountDatabase();
    }

    public ItemDTO getItemDTOByID(int id, int quantity){
        return this.inventorySystem.occupyByID(id, quantity);
    }

    public void accountSale(SaleInfoDTO saleInfo){}
}
