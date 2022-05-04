package dto;

public class ItemDTO {
    private int id;
    private float priceExcludingVat;
    private float percentageVat;
    private int quantity;
    private String name;

    public ItemDTO(int id, float priceExcludingVat, float percentageVat, String name, int quantity){
        this.id = id;
        this.priceExcludingVat = priceExcludingVat;
        this.percentageVat = percentageVat;
        this.name = name;
        this.quantity = quantity;
    }

    public ItemDTO(ItemDTO item, int quantity){
        this.id = item.id;
        this.priceExcludingVat = item.priceExcludingVat;
        this.percentageVat = item.percentageVat;
        this.name = item.name;
        this.quantity = quantity;
    }

    public float getTotalPrice(){
        return (this.percentageVat+1)*this.priceExcludingVat;
    }

    public int getItemID(){
        return this.id;
    }

    public float getVat(){
        return this.percentageVat*this.priceExcludingVat;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("{ItemDTO: %s, $%s*%s (VAT:%s)", this.getName(), this.getTotalPrice(), this.getQuantity(), this.getVat());
    }

}
