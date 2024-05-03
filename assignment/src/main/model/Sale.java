package model;
import dto.ItemDTO;
import dto.PaymentDetailsDTO;
import dto.SaleInfoDTO;
import integration.Integration;

import java.util.HashMap;

public class Sale {
    private HashMap<Integer, ItemDTO> items;
    private float discount;
    private Integration integration;

    /**
     * Constructs a new Sale instance with a reference to an integration layer.
     * 
     * @param integration The integration system to be used for database or external service access.
     */
    public Sale(Integration integration){
        this.items = new HashMap<Integer, ItemDTO>();
        this.discount = 0;
        this.integration = integration;
    }

     /**
     * Attempts to add an item to the sale by its ID and quantity.
     * 
     * @param id The ID of the item to be added.
     * @param quantity The quantity of the item to be added.
     * @return true if the item is added successfully, false if the item cannot be found.
     */
    public boolean addItemByID(int id, int quantity){
        ItemDTO item = this.integration.getItemDTOByID(id, quantity);

        if (item==null){
            return false;
        } else if (this.items.containsKey(id)){
            //increase quantity of existing item
            this.items.put(id,
                new ItemDTO(item, this.items.get(id).getQuantity() + quantity)
            );
            return true;
        } else{
            //add new item
            this.items.put(id, item);
            return true;
        }
    }

    // public boolean requestDiscount(int customerID, int discountID){

    // }

    /**
     * Finalizes the sale and returns the sale information.
     * 
     * @param paymentDetails The payment details for the sale.
     * @return SaleInfoDTO object containing details about the sale.
     */
    public SaleInfoDTO finishSale(PaymentDetailsDTO paymentDetails){
        return this.getSaleInfo();
    }

    /**
     * Retrieves the current sale information.
     * 
     * @return SaleInfoDTO containing the items and discount applied to the sale.
     */
    public SaleInfoDTO getSaleInfo(){
        return new SaleInfoDTO(this.items.values(), this.discount);
    }
}
