import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ServiceBranch extends Branch {
    // Data Fields //
    private final int  branch_ID = 40000;
    private final String branchName;
    private String ID;
    private static int count = 0;

    private Queue<Vehicle> vehiclesInService;

    public ServiceBranch(String branchName) {
        super(branchName);
        createID();
        this.branchName = branchName;
    }

    public ServiceBranch() {
        super("");
        branchName = null;
    }

    public Queue<Vehicle> getVehiclesInService() { return vehiclesInService; }

    void addVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void listVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void removeVehicle(int choice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void createID(){
        if(count > 9999){
            System.out.println("There isn't enough space to add a Rental Branch.");
            System.exit(1);
        }
        this.ID = Integer.toString( branch_ID + count++);
    }

    public String getBranchName() {
        return this.branchName;
    }
}
