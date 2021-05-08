import java.util.ArrayList;

public class Company {
    // Administrator
    private Admin admin;

    // Employee
    private BinarySearchTree<Customer>     customers;
    private ArrayList<SalesManager>        salesManagers;
    private ArrayList<Technician>          technicians;
    private ArrayList<TransportPersonnel>  transportPersonnels;

    // Branches
    private ArrayList<RentalBranch> rentalBranches;
    private ArrayList<ServiceBranch> serviceBranch;

    // Vehicles
    private ArrayList<Vehicle> vehicles;

    public void addAdmin() { /* */ }

    public Admin getAdmin() { return admin; }

    public ArrayList<Vehicle> getVehicles() { return vehicles; }

}
