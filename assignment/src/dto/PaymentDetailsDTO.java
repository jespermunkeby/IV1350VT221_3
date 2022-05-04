package dto;

public class PaymentDetailsDTO {
    private float amount;

    public PaymentDetailsDTO(float amount){
        this.amount = amount;
    }

    public float getAmount(){
        return this.amount;
    }
}
