package integration;

import java.util.HashMap;

import dto.ItemDTO;

public class InventorySystem {
    private HashMap<Integer, ItemDTO> inventory;

    public InventorySystem(){
        //Add some mock data for the inventory
        this.inventory = new HashMap<Integer, ItemDTO>();
        this.inventory.put(1, new ItemDTO(1, 10.f, 0.25f, "apple", 5));
        this.inventory.put(2, new ItemDTO(2, 15.f, 0.25f, "soda", 1));
        this.inventory.put(3, new ItemDTO(3, 12.50f, 0.5f, "beer", 6));
    }

    public ItemDTO occupyByID(int id, int quantity){
        
        
        ItemDTO item = this.inventory.get(id);

        if (item == null){
            return null;
        }else if (item.getQuantity() < quantity){
            return null;
        } else{
            this.inventory.put(id,
                new ItemDTO(item, item.getQuantity() - quantity)
            );

            return new ItemDTO(item, quantity);
        }

    }
}
