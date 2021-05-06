import java.util.ArrayList;
import java.util.PriorityQueue;

public class RentalBranch implements Branch {
    // Branch information
    private String branchName;

    // Vehicles
    private ArrayList<Vehicle> vehicles;

    public RentalBranch(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String getName() { return branchName; }

    @Override
    public void setName(String name) { branchName = name; }

    @Override
    public ArrayList<Vehicle> getVehicles() { return vehicles; }

    @Override
    public void addVehicle(Vehicle vehicle) { vehicles.add(vehicle); }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        try {
            vehicles.remove(vehicle);
        } catch (Exception e) {
            System.out.println("\n**Error! The vehicle you're trying to remove doesn't exist.**");
        }
    }

    @Override
    public void listVehicles(String model) {
        int size = vehicles.size();

        for(int i=0, j=1; i<size; i++, j++)
            System.out.println(j + ")" + vehicles.get(i));
    }
}
