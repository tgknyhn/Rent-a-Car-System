import java.util.ArrayList;
import java.util.Scanner;

public class SalesManager implements User {

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
		setID("-");
        setEmail("-");
        setPassword("-");
        setBranchID("-");
    }
    
    /**
     * Initializes transportation personnel.
     * @param _name Name of the sales manager
     * @param _surname Surname of the sales manager
     * @param _ID ID of the sales manager
     * @param _email Email of the sales manager
     * @param _password Password of the sales manager
     */
	public SalesManager(String _name, String _lastname, String _ID, String _email, String _password, String _branchID) {
		setName(_name);
		setLastname(_lastname);
		setID(_ID);
        setEmail(_email);
        setPassword(_password);
        setBranchID(_branchID);
	}
    
    /**
     * @return Name of the sales manager
     */
    @Override
	public String getName() {
		return this.name;
	}

    /**
     * @return Last name of the sales manager
     */
    @Override
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
     * Changes ID of the sales manager
     * @param _ID
     */
    @Override
	public void setID(String _ID) {
		this.ID = _ID;
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
     * @param _branchID
     */
	@Override
	public void setPassword(String _password) {
	this.branchID = _branchID;
	}
    
    /**
	 * @return branchID of the sales manager
	 */
	@Override
	public String getBranchID() {
		return branchID;
	}
	
	/**
     * Checks, is there any available specific vehicle in that specific rental branch or not.
	 * @param vehicles All vehicles available or rented in the branch. 
     * @param theModel The specific vehicle model which asked by user.
	 * @return Returns index of available vehicle in vehicles list otherwise returns -1
	 */
	public Integer availableVehicle(ArrayList<Vehicle> vehicles, String theModel) {
		int size = vehicles.size();
		
		if(size == 0) {
			System.out.println("There is no vehicles!");
			return -1;
		}
        
		for(int i = 0 ; i < size ; i++) {
			Vehicle currentVehicle = vehicles.get(i);
			
			if(currentVehicle.getModel().equals(theModel) && currentVehicle.available() == true) {
				return i;
			}
		}
		return -1;
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
		Scanner scan = new Scanner(System.in);
		String surname = scan.nextLine();
		cus.setSurname(surname);
        
        System.out.println("Type the address of customer.");
		Scanner scan = new Scanner(System.in);
		String address = scan.nextLine();
		cus.setAddress(address);
        
        System.out.println("Type the phone number of customer.");
		Scanner scan = new Scanner(System.in);
		String phone = scan.nextLine();
		cus.setPhone(phone);
        
        // score & balance to 0 for first time.
        cus.setScore(0);
        cus.setBalance(0);
        // need to create unique id.
		cus.setID("test");
        
		theCustomer.add(cus);

		return true;
	}
    
    public boolean removeCustomer(ArrayList<Customer> theCustomer) {
		if (theCustomer.size() == 0) {
			System.out.println("There is no customer in the company.");
			return false;
		}

		for (int i = 0; i<theCustomer.size(); i++) {
			System.out.printf("%d. %s\n", i+1, theCustomer.get(i).getName());
		}
        
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice<0 || choice>theCustomer.size()) {
			System.out.println("Invalid entry.");
			return false;
		}
		theCustomer.remove(choice);

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
            cus.setName(name);
        }
        
        System.out.println("If the surname will change, type the new surname. Otherwise write -1.");
		Scanner scan = new Scanner(System.in);
		String surname = scan.nextLine();
        if(surname == "-1"){
            // do nothing.
        }else{
            cus.setSurname(surname);
        }
        
        System.out.println("If the address will change, type the new address. Otherwise write -1.");
		Scanner scan = new Scanner(System.in);
		String address = scan.nextLine();
        if(address == "-1"){
            // do nothing.
        }else{
            cus.setAddress(address);
        }
        
        System.out.println("If the phone will change, type the new phone. Otherwise write -1.");
		Scanner scan = new Scanner(System.in);
		String phone = scan.nextLine();
        if(phone == "-1"){
            // do nothing.
        }else{
            cus.setPhone(phone);
        }
        
        System.out.println("If the score will change, type the new score. Otherwise write -1.");
		Scanner scan = new Scanner(System.in);
		String score = scan.nextLine();
        if(score == "-1"){
            // do nothing.
        }else{
            cus.setScore(score);
        }
        
        System.out.println("If the balance will change, type the new balance. Otherwise write -1.");
		Scanner scan = new Scanner(System.in);
		String balance = scan.nextLine();
        if(balance == "-1"){
            // do nothing.
        }else{
            cus.setBalance(balance);
        }
        
        System.out.println("Sales manager can't change the unique ID.");

		return true;
	}
    
    public boolean rent(Vehicle vehicle, Custome theCustomer) throws NullPointerException {
        System.out.println("Please enter the type of the vehicle.");
		Scanner scan = new Scanner(System.in);
		String vehicleType = scan.nextLine();
        if( (availableVehicle(ArrayList<Vehicle> vehicles, String vehicleType)) == -1 ){
            return false;
        )
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
