import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class MainUI {
    public static void main(String[] args) {
        // Initializing Admin
        Admin admin = new Admin("admin", "nimda", "1000", "admin.com", "1234asdf" );
        // Initializing the first employees
        Technician         u  = new Technician("tech", "nician_1", "tech_1.com", "1234");
        TransportPersonnel u1 = new TransportPersonnel("transport", "pers_1", "trans_1.com", "1234");
        SalesManager       u2 = new SalesManager("sales", "manager_1", "sales_1.com", "1234", "40000");
        // Initializing the company and adding admin to the company
        Company myCompany = new Company(admin);
        admin.setComp(myCompany);
        // Adding employees to the company
        SkipList<Technician> technicians = myCompany.getTechnicians();
        SkipList<TransportPersonnel> transportPersonnels = myCompany.getTransportPersonnels();
        SkipList<SalesManager> salesManagers = myCompany.getSalesManagers();
        technicians.add(u);
        transportPersonnels.add(u1);
        salesManagers.add(u2);
        // Adding one customer to the company.
        Customer c = new Customer("ali" , "ebe" , "ali@customer.com" , "12345");
        u2.addCustomer(myCompany.getCustomers(), c);

        new MenuUI(myCompany);

        /*ArrayList<RentalBranch> rentalBranches = myCompany.getRentalBranches();

        for(int i=0; i<rentalBranches.size(); i++) {
            System.out.println(rentalBranches.get(i).getBranchName());
        }*/


        /*Iterator<Customer> iter = myCompany.getCustomers().iterator();

        while(iter.hasNext()){
            Customer temp;
            temp = iter.next();
            System.out.println(temp.getEmail() + " " + temp.getPassword() + " " + temp.getName());
        }*/

        Vehicle x = new Vehicle("Audi","Q2",2000);

        admin.addVehicle(x);

    }
}
