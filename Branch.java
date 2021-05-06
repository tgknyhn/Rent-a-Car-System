import java.util.ArrayList;

public class Branch {
    // Branch information
    private String branchID;

    public Branch(String branchID) {
        this.branchID = branchID;
    }

    public String getID() { return branchID; }

    public void setID(String name) { branchID = name; }

    public void addVehicle(Company company, Vehicle vehicle) { company.getVehicles().add(vehicle); }

    public void removeVehicle(Company company, Vehicle vehicle) {
        try {
            company.getVehicles().remove(vehicle);
        } catch (Exception e) {
            System.out.println("\n**Error! The vehicle you're trying to remove doesn't exist.**");
        }
    }

    public void listVehicles(Company company, String model) {
        int size = company.getVehicles().size();
        // if statement branch id kontrol et eşitse yazdır
        for(int i=0, j=1; i<size; i++, j++)
            System.out.println(j + ")" + company.getVehicles().get(i));
    }
}
