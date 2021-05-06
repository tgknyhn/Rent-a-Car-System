import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ServiceBranch extends Branch {

    private Queue<Vehicle> vehiclesInService;

    public ServiceBranch(String branchName) {
        super(branchName);
    }

    public Queue<Vehicle> getVehiclesInService() { return vehiclesInService; }


}
