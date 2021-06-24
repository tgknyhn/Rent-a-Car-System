import java.util.ArrayList;
import java.util.Scanner;

public class SalesManager implements User, Comparable<SalesManager> {

	private final int salesManager_ID = 10000;
	private static int count = 0;
	private String name;
	private String lastname;
	private String ID;
	private String email;
	private String password;
    private String branchID;
    
    private final int MAX_EMP_SIZE = 1000;
    
    // need something like ArrayList<Vehicle> vehicles, for the vehicles in that specific branch.

    /**
     * Default constructor.
     */
    public SalesManager(){
        setName("-");
		setLastname("-");
		createId();
        setEmail("-");
        setPassword("-");
        setBranchID("-");
    }
    
    /**
     * Initializes transportation personnel.
     * @param _name Name of the sales manager
     * @param _lastname Surname of the sales manager
     * @param _email Email of the sales manager
     * @param _password Password of the sales manager
     */
	public SalesManager(String _name, String _lastname, String _email, String _password, String _branchID) {
		setName(_name);
		setLastname(_lastname);
		createId();
        setEmail(_email);
        setPassword(_password);
        setBranchID(_branchID);
	}
    
    /**
     * @return Name of the sales manager
     */
	public String getName() {
		return this.name;
	}

    /**
     * @return Last name of the sales manager
     */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @return ID of the sales manager
	 */
	@Override
	public String getID() {
		return this.ID;
	}

    /**
     * @return Email of the sales manager
     */
    @Override
	public String getEmail() {
		return email;
	}

	/**
	 * @return Password of the sales manager
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
     * Changes name of the sales manager
     * @param _name 
     */
	@Override
	public void setName(String _name) {
		this.name = _name;
	}

	/**
     * Changes surname of the sales manager
     * @param _lastname 
     */
	@Override
	public void setLastname(String _lastname) {
		this.lastname = _lastname;
	}



	/**
     * Changes email of the sales manager
     * @param _email
     */
	@Override
	public void setEmail(String _email) {
	this.email = _email;
	}

	/**
     * Changes password of the sales manager
     * @param _password
     */
	@Override
	public void setPassword(String _password) {
	this.password = _password;
	}
    
    /**
     * Changes branchID of the sales manager
     */
	public void setBranchID(String branchID) {
	this.branchID = branchID;
	}
    
    /**
	 * @return branchID of the sales manager
	 */
	public String getBranchID() {
		return branchID;
	}


	/**
     * Checks, is there any available specific vehicle in that specific rental branch or not.
	 * @param company Check vehicle list from company
     * @param theModel The specific vehicle model which asked by user.
	 * @return Returns index of available vehicle in vehicles list otherwise returns -1
	 */
	public Integer isVehicleAvailable(Company company, String theModel) {
		int size = company.getVehicles().size();
		
		if(size == 0) {
			System.out.println("There is no vehicles!");
			return -1;
		}

		// company'deki vehicle listesinde tüm vehicellar burada tek tek check edilmedi.
		/**for(int i = 0 ; i < size ; i++) {
			Vehicle currentVehicle = company.getVehicles(i).get(i);
			
			if(currentVehicle.getModel().equals(theModel) && currentVehicle.available() == true) {
				return i;
			}
		}*/
		return -1;
	}

	/**
	 *
	 * @param rentalBranches
	 * @param vehicle
	 * @throws NullPointerException
	 */
	public void fillPriority(ArrayList<RentalBranch> rentalBranches, Vehicle vehicle) throws NullPointerException {
		/*
		//rentalBranch. ile direk işlem yapılmıyor
		for (RentalBranch rentalBranch : rentalBranches)
			if (rentalBranch.getID().equals(getBranchID()))
				rentalBranch.addWithPriority(vehicle); */
	}

	/**
	 *
	 * @param vehicles
	 */
	public void availableVehicles(ArrayList<Vehicle> vehicles) {
		/* Shows available vehicles with their priority(Priority Queue) */
	}

	/**
	 * Adds an existing user to the company as a customer.
	 * @param customers Customers in the company.
	 * @param u Customer's itself.
	 * @return True if the adding is succesful.
	 */
	public boolean addCustomer(AVLTree<Customer> customers , Customer u){

		if(customers.size() == MAX_EMP_SIZE){
			// need to change size&cap.
			return false;
		}
		customers.add(u);
		return true;

	}
	public boolean addCustomer(ArrayList<Customer> theCustomer) {
		if (theCustomer.size() == MAX_EMP_SIZE) {
			// need to change size&cap.
			return false;
		}
        
        // need to check that customer is in system or not.
        // if the user in system return false;

		Customer cus = new Customer();
        
		System.out.println("Type the name of customer.");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		cus.setName(name);

		System.out.println("Type the surname of customer.");
		scan = new Scanner(System.in);
		String surname = scan.nextLine();
		cus.setSurname(surname);

		System.out.println("Type the address of customer.");
		scan = new Scanner(System.in);
		String address = scan.nextLine();
		cus.setEmail(address);

		System.out.println("Type the phone number of customer.");
		scan = new Scanner(System.in);
		String phone = scan.nextLine();
		cus.setPhone(Integer.parseInt(phone));
        
        // score & balance to 0 for first time.
        cus.setScore(0);
        cus.setBalance(0);
		/*
		bilgilerini topladığımız cus, theCustomer listesine yeni obje olarak
			eklenmeli. Customer listesini company'den almamız gerekiyor.
		theCustomer.add(cus);
		 */

		return true;
	}
    
    public boolean removeCustomer(ArrayList<Customer> theCustomer) {
		if (theCustomer.size() == 0) {
			System.out.println("There is no customer in the company.");
			return false;
		}

		for (int i = 0; i<theCustomer.size(); i++) {
			/*
			* theCustomer listesi company'den gelmeli.
			*
			* System.out.printf("%d. %s\n", i+1, theCustomer.get(i).getName());
			 */
		}
        
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice<0 || choice>theCustomer.size()) {
			System.out.println("Invalid entry.");
			return false;
		}
		/*
		* theCustomer listesi company'den gelmeli.
		* seçilmiş customer o listeden silinmeli.
		*
		* theCustomer.remove(choice);
		 */

		return true;
	}
    
    public boolean updateCustomer(Customer aCustomer) {
		if (aCustomer.getName() == "empty") {
			System.out.println("There is no customer in the company.");
			return false;
		}

		System.out.println("If the name will change, type the new name. Otherwise write -1.");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
        if(name == "-1"){
            // do nothing.
        }else{
			aCustomer.setName(name);
        }

		System.out.println("If the surname will change, type the new surname. Otherwise write -1.");
		scan = new Scanner(System.in);
		String surname = scan.nextLine();
        if(surname == "-1"){
            // do nothing.
        }else{
			aCustomer.setSurname(surname);
        }

		System.out.println("If the address will change, type the new address. Otherwise write -1.");
		scan = new Scanner(System.in);
		String address = scan.nextLine();
        if(address == "-1"){
            // do nothing.
        }else{
			aCustomer.setEmail(address);
        }

		System.out.println("If the phone will change, type the new phone. Otherwise write -1.");
		scan = new Scanner(System.in);
		String phone = scan.nextLine();
        if(phone == "-1"){
            // do nothing.
        }else{
			aCustomer.setPhone(Integer.parseInt(phone));
        }

		System.out.println("If the score will change, type the new score. Otherwise write -1.");
		scan = new Scanner(System.in);
		String score = scan.nextLine();
        if(score == "-1"){
            // do nothing.
        }else{
			aCustomer.setScore(Integer.parseInt(score));
        }

		System.out.println("If the balance will change, type the new balance. Otherwise write -1.");
		scan = new Scanner(System.in);
		String balance = scan.nextLine();
        if(balance == "-1"){
            // do nothing.
        }else{
			aCustomer.setBalance(Integer.parseInt(balance));
        }

		System.out.println("Sales manager can't change the unique ID.");

		return true;
	}
    
    public boolean rent(Vehicle vehicle, Customer theCustomer) throws NullPointerException {
		/**
		 * ...
		 * if( (availableVehicle(ArrayList<Vehicle> vehicles, String vehicleType)) == -1 ) {
		 * 		return false;
		 * }
		 */

        // Checking if given parameter is null or not
        if(vehicle == null)
            throw new NullPointerException();
        // Assigning rented car to Customer
        // need to setter/getter here.
        // theCustomer.setVehicle(vehicle);
        // Removing rent price of the car from Customer's balance
        // need to setter/getter here.
        // theCustomer.remFromBalance(vehicle.getPrice());

        return true;
    }

	public void createId() {
		if(count > 9999){
			System.out.println("There is not enough space for a new Sales Manager.");
			System.exit(1);
		}
		ID = Integer.toString( salesManager_ID + count++);
	}

	@Override
	public int compareTo(SalesManager o) {
		String ID1 = this.getID();
		String ID2 = o.getID();

		return ID1.compareTo(ID2);
	}
}