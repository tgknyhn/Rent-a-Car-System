import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ServiceBranch extends Branch {

    private Queue<Vehicle> vehiclesInService;

    public ServiceBranch(String branchName) {
        super(branchName);
    }

    public ServiceBranch() {
        super("");
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


}
