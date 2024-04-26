package controller;
import integration.Integration;
import model.Sale;
import model.Register;
import dto.SaleInfoDTO;
import dto.PaymentDetailsDTO;


/**
 * Controller class that manages the flow of sales operations, integrating various system components.
 */
public class Controller {
    private Integration integration;
    private Sale sale;
    private Register register;

    /**
     * @param integration Integration Object
     */
    public Controller(Integration integration){
        this.integration = integration;
        this.register = new Register();
    }

    /**
     * starts a sale
     */
    public void startSale(){
        this.sale = new Sale(this.integration);
    }

    /**
     * adds item(s) to current sale
     * @param id id of item
     * @param quantity quantity of item
     * @return sucessfull?
     */
    public boolean addItemByID(int id, int quantity){
        return this.sale.addItemByID(id, quantity);
    }

    // /**
    //  * requests a discount and appies it to sale if valid
    //  * @param customerID customer id
    //  * @param discountID discount id
    //  * @return sucessful?
    //  */
    // public boolean requestDiscount(int customerID, int discountID){

    // }

    /**
     * Finalizes the sale and handles payment.
     * @param paymentDetails Details of the payment made.
     */
    public void finishSale(PaymentDetailsDTO paymentDetails){

        SaleInfoDTO sale = this.sale.finishSale(paymentDetails);

        if (paymentDetails.getAmount() != this.getRunningTotal()){
            throw new Error("funds did not match cost");
        } 

        this.register.depopsitToBalance(paymentDetails.getAmount());
        this.integration.accountSale(sale);
        this.sale = null;

        System.out.println("Sale finished sucessfully");

        this.register.printReceipt(sale, paymentDetails);
    }

    public float getRunningTotal(){
        return this.getSaleInfo().getTotalPrice();
    }

    /**
     * get info of current sale
     * @return info of current sale
     */
    public SaleInfoDTO getSaleInfo(){
        return this.sale.getSaleInfo();
    }
}
