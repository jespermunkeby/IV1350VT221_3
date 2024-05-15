package view;

import model.RegisterObserver;
    /**
     * Shows total income to user interface by printing to system out
     */
public class TotalRevenueView implements RegisterObserver {
    public void onRevenueChange(float updatedRevenue){
        System.out.println("new revenue: " + updatedRevenue);
    }

}
