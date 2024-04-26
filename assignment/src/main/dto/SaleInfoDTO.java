package dto;

import java.util.Collection;
import java.util.Iterator;

public class SaleInfoDTO {
    private Collection<ItemDTO> items;
    private float discount;

    public SaleInfoDTO(Collection<ItemDTO> items, float discount){
        this.items = items;
        this.discount = discount;
    }

    public float getTotalPrice(){
        float sum = 0;
        Iterator<ItemDTO> iterator = this.items.iterator();

        while (iterator.hasNext()) {
            sum += iterator.next().getTotalPrice();
        }

        return sum;
    }

    @Override
    public String toString() {

        return this.items.toString();
        
    }
}
