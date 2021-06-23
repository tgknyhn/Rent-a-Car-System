import java.util.Iterator;
import java.util.PriorityQueue;

public class RentalBranch extends Branch {
    // Data Fields //
    private final int  branch_ID = 40000;
    private final String branchName;
    private String ID;
    private static int count = 0;
    // Vehicles
    private PriorityQueue<String> priorityVehicles;

    public RentalBranch(String branchName) {
        super(branchName);
        createID();
        this.branchName = branchName;
    }

    // Getters //

    public String getBranchID() { return ID; }

    public String getBranchName() { return branchName; }


    public boolean addWithPriority(Vehicle myVehicle) {
        return false;
    }

    public PriorityQueue<Vehicle> getPriorityVehicles() {
        return null;
    }

    private void createID(){
        if(count > 9999){
            System.out.println("There isn't enough space to add a Rental Branch.");
            System.exit(1);
        }
        this.ID = Integer.toString( branch_ID + count++);
    }
}
