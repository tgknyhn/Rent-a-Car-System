import java.util.Iterator;
import java.util.PriorityQueue;

public class RentalBranch extends Branch {
    // Data Fields //
    private final int    branchID;
    private final String branchName;
    // Vehicles
    private PriorityQueue<String> priorityVehicles;

    public RentalBranch(String branchName, int branchID) {
        super(branchName);
        this.branchID = branchID;
        this.branchName = branchName;
    }

    // Getters //

    public int getBranchID() { return branchID; }

    public String getBranchName() { return branchName; }


    public boolean addWithPriority(Vehicle myVehicle) {
        return false;
    }

    public PriorityQueue<Vehicle> getPriorityVehicles() {
        return null;
    }
}
