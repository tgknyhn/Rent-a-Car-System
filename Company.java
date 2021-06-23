import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Company {
    // Administrator
    private Admin admin;

    // Employee
    private AVLTree<Customer>     customers;
    private SkipList<SalesManager>   	  salesManagers;
    private SkipList<Technician>          technicians;
    private SkipList<TransportPersonnel>  transportPersonnels;

    // Branches
    private ArrayList<RentalBranch> rentalBranches;
    private ArrayList<ServiceBranch> serviceBranch;

    // Vehicles
    private ArrayList<Vehicle> vehicles;
    
    public Company() {
    	customers = new AVLTree<>();
    	salesManagers = new SkipList<SalesManager>();
    	technicians = new SkipList<Technician>();
    	transportPersonnels = new SkipList<TransportPersonnel>();
    	
    	rentalBranches = new ArrayList<RentalBranch>();
    	serviceBranch = new ArrayList<ServiceBranch>();
    	
    	vehicles = new ArrayList<Vehicle>();
    	try {
			FileReader fr = new FileReader("vehicles.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			while( (line = br.readLine()) != null) {
				String tokens[] = line.split("-");
				Vehicle temp = new Vehicle(tokens[0] , tokens[1] , Integer.parseInt(tokens[2]));
				vehicles.add(temp);		
			}
			br.close();
			fr.close();
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void addAdmin() { /* */ }

    public Admin getAdmin() { return admin; }

    public ArrayList<Vehicle> getVehicles() { return vehicles; }

}
