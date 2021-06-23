import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MainUI {
    public static void main(String[] args) throws IOException {
        Company myCompany = new Company();

        //new MenuUI(myCompany);

        Customer cust  = new Customer("Fatih","Gtu","x",1,1,1,true);
        Customer cust1 = new Customer();
        Customer cust2 = new Customer("Fat","Gtu","x",1,1,1,true);

        User u = new Technician();
        User u1 = new TransportPersonnel();
        User u2 = new SalesManager();
        User u3 = new SalesManager();

        Admin admin = myCompany.getAdmin();

        FileReader fr = new FileReader("provinces.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while( (line = br.readLine()) != null){
            line = br.readLine();
            if(line.compareTo("Duzce") == 0){
                Branch temp = new RentalBranch(line);
                Branch temp2 = new ServiceBranch(line);
                if(!admin.addServiceBranch(myCompany.getServiceBranch(), temp2)){
                    System.out.println("The branch named " + temp2.getID() + " already exists");
                }
                if(!admin.addRentalBranch(myCompany.getRentalBranches() , temp)){
                    System.out.println("The branch named " + temp.getID() + " already exists.");
                }
                break;
            }

            Branch temp = new RentalBranch(line);
            Branch temp2 = new ServiceBranch(line);

            if(!admin.addServiceBranch(myCompany.getServiceBranch(), temp2)){
                System.out.println("The branch named " + temp2.getID() + " already exists");
            }
            if(!admin.addRentalBranch(myCompany.getRentalBranches() , temp)){
                System.out.println("The branch named " + temp.getID() + " already exists.");
            }
        }

        br.close();
        fr.close();


    }
}
