package model;

public interface RegisterObserver {
    /**
     * Callled when revenue is changed
     * @param updatedRevenue the new updated revenue
     */
    void onRevenueChange(float updatedRevenue);
}


//TODO: register totalkevenue file output and view on register model. Handle update of revenue when sale completes.
//