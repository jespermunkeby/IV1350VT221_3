package model;

import dto.PaymentDetailsDTO;
import dto.SaleInfoDTO;

public class Register {
   private float balance;

   public float getBalance(){
       return this.balance;
   }

   public void depopsitToBalance(float amount){
       this.balance += amount;
   }

   public void printReceipt(SaleInfoDTO saleInfo, PaymentDetailsDTO paymentDetails){
        System.out.println("\nRECEIPT:");
        System.out.println(saleInfo);
        System.out.println(paymentDetails);
   }
}
