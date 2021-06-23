import java.io.FileNotFoundException;

public class MainUI {
    public static void main(String[] args) throws FileNotFoundException {
        Company myCompany = new Company();

        //new MenuUI(myCompany);

        Customer cust  = new Customer("Fatih","Gtu","x",1,1,1,true);
        Customer cust1 = new Customer("Fati","Gtu","x",1,1,1,true);
        Customer cust2 = new Customer("Fat","Gtu","x",1,1,1,true);

        User u = new Technician();
        User u1 = new TransportPersonnel();
        User u2 = new SalesManager();
        User u3 = new SalesManager();

        System.out.println(u.getID() +" " + u1.getID() + " " + u3.getID());

    }
}
