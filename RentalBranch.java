import java.util.PriorityQueue;

public class RentalBranch {
    // Data Fields //
    private final int    branchID;
    private final String branchName;
    // Vehicles
    private PriorityQueue<String> priorityVehicles;

    public RentalBranch(String branchName, int branchID) {
        this.branchID = branchID;
        this.branchName = branchName;
    }

    // Getters //

    public int getBranchID() { return branchID; }

    public String getBranchName() { return branchName; }


}
