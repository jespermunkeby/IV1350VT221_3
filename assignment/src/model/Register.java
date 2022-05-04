package model;

public class Register {
   private float balance;

   public float getBalance(){
       return this.balance;
   }

   public void depopsitToBalance(float amount){
       this.balance += amount;
   }
}
