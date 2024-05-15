import controller.Controller;
import integration.Integration;
import view.View;
import dto.PaymentDetailsDTO;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Create integration object 
        Integration integration = new Integration();

        //Create controller object
        Controller controller = new Controller(integration);

        //Create view object
        View view = new View(controller);

        //create new sale
        System.out.println("\n\n **START NEW SALE**");
        view.newSale();
        view.printSaleInfo();
        System.out.println("--------------------------------");


        System.out.println("\n\n **ADD ITEM WITH ID=2 (SODA)**");
        view.enterID(2);
        view.printSaleInfo();
        System.out.println("--------------------------------");


        System.out.println("\n\n **ADD ITEM WITH ID=1 (APPLE)**");
        view.enterID(1);
        view.printSaleInfo();
        System.out.println("--------------------------------");

        System.out.println("\n\n **ADD ITEM WITH ID=3 (BEER)**");
        view.enterID(3);
        view.printSaleInfo();
        System.out.println("--------------------------------");


        System.out.println("\n\n **ADD ITEM WITH ID=1 AGAIN (APPLE) (ALT: FLOW 3-4b)**");
        view.enterID(1);
        view.printSaleInfo();
        System.out.println("--------------------------------");


        System.out.println("\n\n **ADD ITEM WITH ID=2 (SODA) - NONE LEFT IN INVENTORY; A MISTAKE MUST HAVE BEEN MADE**");
        view.enterID(2);
        view.printSaleInfo();
        System.out.println("--------------------------------");

        view.enterID(2223);
        view.printSaleInfo();

        System.out.println("\n\n **END SALE**");
        view.payAndEnd(new PaymentDetailsDTO(controller.getRunningTotal()));

    }
}
