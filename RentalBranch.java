import java.util.ArrayList;
import java.util.PriorityQueue;

public class RentalBranch extends Branch {
    // Vehicles
    private PriorityQueue<Vehicle> priorityVehicles;


    /**
     *
     * @param branchName
     */
    public RentalBranch(String branchName) {
        super(branchName);
    }

    RentalBranch() {
        super(null);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PriorityQueue<Vehicle> getPriorityVehicles() { return priorityVehicles; }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean addWithPriority(Vehicle vehicle) { priorityVehicles.offer(vehicle); return true; }

    void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
