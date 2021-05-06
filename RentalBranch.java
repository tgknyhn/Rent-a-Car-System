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

    public PriorityQueue<Vehicle> getPriorityVehicles() { return priorityVehicles; }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean addWithPriority(Vehicle vehicle) { priorityVehicles.offer(vehicle); return true; }
}
