import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Company {
    // Administrator
    private Admin admin;
    // Customer
    private AVLTree<Customer> customers;
    // Employee
    private SkipList<SalesManager>   	 salesManagers;
    private SkipList<Technician>         technicians;
    private SkipList<TransportPersonnel> transportPersonnels;
    // Branches
    private ArrayList<RentalBranch> rentalBranches;
    private ArrayList<ServiceBranch> serviceBranch;
    // Vehicles
    private ArrayList<Vehicle> vehicles;
    
    public Company(Admin admin) {
		this.admin = admin;
    	customers           = new AVLTree<>();
    	salesManagers 		= new SkipList<SalesManager>();
    	technicians 		= new SkipList<Technician>();
    	transportPersonnels = new SkipList<TransportPersonnel>();
    	
    	rentalBranches = new ArrayList<>();
    	serviceBranch  = new ArrayList<>();

    	customers.add(new Customer("ahmet", "sese", "adres", "60001", "1234"));

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

    public Admin getAdmin() { return admin; }

    public ArrayList<Vehicle> getVehicles() { return vehicles; }

	public AVLTree<Customer> getCustomers() { return customers; }

	public SkipList<SalesManager> getSalesManagers() { return salesManagers; }

	public SkipList<Technician> getTechnicians() { return technicians; }

	public SkipList<TransportPersonnel> getTransportPersonnels() { return transportPersonnels; }

	public ArrayList<RentalBranch> getRentalBranches(){ return rentalBranches; }

	public ArrayList<ServiceBranch> getServiceBranch(){ return serviceBranch; }


}
