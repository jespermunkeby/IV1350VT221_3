package model;

import dto.PaymentDetailsDTO;
import dto.SaleInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class Register {
   private float balance;
   private ArrayList<RegisterObserver> observers = new ArrayList<RegisterObserver>();

    /**
     * Update the balance of the register. Use this any time the balance needs to be updated, as it notifies potential observers
     * @param balance the new balance of the register
     */
   private void updateBalance(float balance){
       this.balance = balance;
       for (RegisterObserver observer : this.observers){
           observer.onRevenueChange(balance);
       }
   }


   public float getBalance(){
       return this.balance;
   }

   /**
   * Adds the specified amount to the current balance. Notifies the register observer that the revenue has changed
   * @param amount The amount to deposit. Must be a non-negative number.
   */
   public void depopsitToBalance(float amount){
       this.updateBalance(this.balance + amount);
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

   public void addObserver(RegisterObserver observer){
       this.observers.add(observer);
   }
}
