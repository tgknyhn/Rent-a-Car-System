import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    
    public Company(Admin admin) {
		this.admin = admin;
    	customers           = new AVLTree<>();
    	salesManagers 		= new SkipList<SalesManager>();
    	technicians 		= new SkipList<Technician>();
    	transportPersonnels = new SkipList<TransportPersonnel>();
    	
    	rentalBranches = new ArrayList<>();
    	serviceBranch  = new ArrayList<>();

    	customers.add(new Customer("ahmet", "sese", "adres","1234"));
    	try {
			getBranchesFromFile();
		}
    	catch (Exception IOException) {
    		System.exit(0);
		}
    }

    public void getBranchesFromFile() throws IOException {
		FileReader fr = new FileReader("provinces.txt");
		BufferedReader br = new BufferedReader(fr);

		String line;
		while( (line = br.readLine()) != null){
			line = br.readLine();

			RentalBranch temp = new RentalBranch(line);
			ServiceBranch temp2 = new ServiceBranch(line);

			rentalBranches.add(temp);
			serviceBranch.add(temp2);

			if(line.compareTo("Duzce") == 0)
				break;
		}

		br.close();
		fr.close();
	}

    public Admin getAdmin() { return admin; }

    //public ArrayList<Vehicle> getVehicles() { return vehicles; }

	public AVLTree<Customer> getCustomers() { return customers; }

	public SkipList<SalesManager> getSalesManagers() { return salesManagers; }

	public SkipList<Technician> getTechnicians() { return technicians; }

	public SkipList<TransportPersonnel> getTransportPersonnels() { return transportPersonnels; }

	public ArrayList<RentalBranch> getRentalBranches(){ return rentalBranches; }

	public ArrayList<ServiceBranch> getServiceBranch(){ return serviceBranch; }


}
