import java.util.ArrayList;

public interface Branch {

    /**
     * Returns name of the Branch
     * @return Name of the branch
     */
    String getName();

    /**
     * Changes branch name with given parameter
     */
    void setName(String name);

    /**
     * Returns vehicle array which holds all vehicles in the branch
     * @return All vehicles in the branch
     */
    ArrayList<Vehicle> getVehicles();

    /**
     * Adds given vehicle to the Branch
     * @param vehicle Vehicle that will be added to the Branch
     */
    void addVehicle(Vehicle vehicle);

    /**
     * Removes given vehicle from the Branch
     * @param vehicle Vehicle that will be removed from the Branch
     */
    void removeVehicle(Vehicle vehicle);

    /**
     * Prints out all vehicles in given model
     * @param model Model type that will be printed
     */
    void listVehicles(String model);
}
