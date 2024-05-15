package controller;
import exceptionHandling.ItemNotFoundException;
import exceptionHandling.NoResponseException;
import integration.Integration;
import integration.TotalRevenueFileOutput;
import model.ErrorLogger;
import model.Sale;
import model.Register;
import dto.SaleInfoDTO;
import dto.PaymentDetailsDTO;
import view.TotalRevenueView;


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
        this.register.addObserver(new TotalRevenueView());
        this.register.addObserver(new TotalRevenueFileOutput());
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
    public void addItemByID(int id, int quantity) throws ItemNotFoundException{
        this.sale.addItemByID(id, quantity);
    }

    // /**
    //  * requests a discount and appies it to sale if valid
    //  * @param customerID customer id
    //  * @param discountID discount id
    //  * @return sucessful?
    //  */
    /*
    public boolean requestDiscount(int customerID, int discountID) throws NoResponseException {
        boolean discount = true;
        try{
            //call to discountDB and save result in "discount"
        } catch(NoResponseException ex){
            throw new NoResponseException("discount database"); //re-throwing to customize message
            //possibility to write to log
        }
        return discount;
    }*/

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

        try{
            this.integration.accountSale(sale);

        } catch (NoResponseException ex){
            System.out.println(ex);
            ErrorLogger e = new ErrorLogger();
            e.log(ex);
        }

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
