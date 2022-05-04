package view;

import controller.Controller;
import dto.PaymentDetailsDTO;

public class View {
    private Controller controller;

    public View(Controller controller){
        this.controller = controller;
    }

    public void enterID(int id){
        if (controller.addItemByID(id, 1)){
            System.out.printf("successfully added 1 item with id:%s to ongoing sale\n", id);
        } else {
            System.out.printf("could not add item with id:%s\n", id);
        }
    }

    public void newSale(){
        controller.startSale();
    }

    public void printSaleInfo(){
        System.out.println("current items in sale:");
        System.out.println(this.controller.getSaleInfo());
    }

    public void payAndEnd(PaymentDetailsDTO paymentDetails){
        controller.finishSale(paymentDetails);
    }
}
