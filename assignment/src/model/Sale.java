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

    public Sale(Integration integration){
        this.items = new HashMap<Integer, ItemDTO>();
        this.discount = 0;
        this.integration = integration;
    }

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

    public SaleInfoDTO finishSale(PaymentDetailsDTO paymentDetails){
        return this.getSaleInfo();
    }

    public SaleInfoDTO getSaleInfo(){
        return new SaleInfoDTO(this.items.values(), this.discount);
    }
}
