package model;

import dto.PaymentDetailsDTO;
import dto.SaleInfoDTO;

public class Register {
   private float balance;

   public float getBalance(){
       return this.balance;
   }

   /**
   * Adds the specified amount to the current balance.
   * @param amount The amount to deposit. Must be a non-negative number.
   */
   public void depopsitToBalance(float amount){
       this.balance += amount;
   }

   /**
  * Prints a formatted receipt with details from a sale and its corresponding payment.
  * 
  * @param saleInfo The details of the sale.
  * @param paymentDetails The details of the payment.
  */
   public void printReceipt(SaleInfoDTO saleInfo, PaymentDetailsDTO paymentDetails){
        System.out.println("\nRECEIPT:");
        System.out.println(saleInfo);
        System.out.println(paymentDetails);
   }
}
