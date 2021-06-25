import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class RentalBranch extends Branch {
    // Data Fields //
    private final int  branch_ID = 40000;
    private final String branchName;
    private String ID;
    private static int count = 0;
    // Vehicles
    //private PriorityQueue<String> priorityVehicles;
    private ArrayList<Vehicle> vehicles;

    public RentalBranch(String branchName) {
        super(branchName);
        createID();
        this.branchName = branchName;

        vehicles = new ArrayList<>();
        try {
            FileReader fr = new FileReader("vehicles.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            while( (line = br.readLine()) != null) {
                String[] tokens = line.split("-");
                Vehicle temp = new Vehicle(tokens[0] , tokens[1] , Integer.parseInt(tokens[2]));
                vehicles.add(temp);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public ArrayList<Vehicle> getVehicles() {return vehicles;}

    private void createID(){
        if(count > 9999){
            System.out.println("There isn't enough space to add a Rental Branch.");
            System.exit(1);
        }
        this.ID = Integer.toString( branch_ID + count++);
    }
}
