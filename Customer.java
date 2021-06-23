import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Customer implements User, Comparable<Customer> {
    // Bounds for score
    private final int MAX_SCORE = 100;
    private final int MIN_SCORE = -100;
    // Bounds for balance
    private final int MAX_BALANCE = 10000;
    private final int MIN_BALANCE = 0;
    // Customer information
    private final int customer_ID = 60000;
    private static int count = 0;
    private String name;
    private String lastname;
    private String address;
    private String password;
    private String email;
    private String ID;
    private int phone;
    private int score;
    private int balance;
    private boolean license;
    // Vehicle information
    private Vehicle myVehicle;

    /* [Constructors]  */

    /**
     * Initializes Customer class with empty data
     */
    public Customer() {
        setName("empty");
        setSurname("empty");
        setAddress("empty");
        createID();
        setPhone(0);
        setScore(0);
        setBalance(0);
        setLicense(false);
    }

    /**
     * Takes all necessary data fields as parameter. Initializes Customer class.
     * @param name Name of the customer
     * @param surname Surname of the customer
     * @param address Address of the customer
     * @param ID ID of the customer
     * @param phone Phone number of the customer
     * @param score Score of the customer
     */
    public Customer(String name, String surname, String address, String ID, String password) {
        createID();
        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhone(0);
        setScore(0);
        setBalance(0);
        setLicense(true);
        setPassword(password);
    }

    /* [Getters] */

    /**
     * Returns name of the customer
     * @return Name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Returns surname of the customer
     * @return Surname of the customer
     */
    public String getLastname() {
        return lastname;
    }

    @Override
    public void setLastname(String surname) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns address of the customer
     * @return Address of the customer
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns phone number of the customer
     * @return Phone number of the customer
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Returns score of the customer
     * @return Score of the customer
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns balance of the customer
     * @return Balance of the customer
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Returns ID of the customer
     * @return ID of the customer
     */
    public String getID() { return ID; }

    /**
     * Returns License status of the customer
     * @return License status
     */
    public boolean getLicense() { return license; }

    public Vehicle getMyVehicle() { return myVehicle; }

    /* [Setters] */

    /**
     * Changes name of the customer with given parameter
     * @param name New name of the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes surname of the customer with given parameter
     * @param lastname New surname of the customer
     */
    public void setSurname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Changes address of the customer with given parameter
     * @param address New address of the customer
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Changes phone number of the customer with given parameter
     * @param phone New phone number of the customer
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Changes score of the customer with given parameter
     * @param score New score of the customer
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Changes score of the customer with given parameter
     * @param balance New balance of the customer
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Changes ID of the customer with given parameter
     * @param ID New ID of the customer
     */
    public void setID(String ID) { this.ID = ID; }

    /**
     * Changes license status of the customer with given parameter
     * @param license license status of the customer
     */
    public void setLicense(boolean license) { this.license = license; }

    /* [Score Methods] */

    public void addToScore(int value) {
        setScore(getScore() + value);

        // score can't be higher than MAX_SCORE
        if(getScore() > MAX_SCORE)
            setScore(MAX_SCORE);
    }

    public void remFromScore(int value) {
        setScore(getScore() - value);

        // score can't be lower than MIN_SCORE
        if(getScore() < MIN_SCORE)
            setScore(MIN_SCORE);
    }

    /* [Balance Methods] */

    public void addToBalance(int value) {
        setBalance(getBalance() + value);

        // balance can't be higher than MAX_BALANCE
        if(getBalance() > MAX_BALANCE)
            setBalance(MAX_BALANCE);
    }

    public void remFromBalance(int value) {
        setBalance(getBalance() - value);

        // balance can't be lower than MIN_BALANCE
        if(getBalance() < MIN_BALANCE)
            setBalance(MIN_BALANCE);
    }

    /* [Renting Methods] */

    /**
     * Returns all vehicles in order.
     * @param vehicles Vehicle list
     */
    public ArrayList<Vehicle> listAllVehicles(ArrayList<Vehicle> vehicles) {
        Vehicle_Sort vehicleSorter = new Vehicle_Sort();
        vehicleSorter.sort(vehicles);

        return vehicles;
    }

    /**
     * Prints out available vehicles with given parameters
     * @param vehicles Holds all vehicles available
     * @param model Model of the vehicle
     */
    public void searchVehicles(ArrayList<Vehicle> vehicles, String model) {
        for(Vehicle vehicle : vehicles)
            if(vehicle.getModel().equals(model))
                System.out.println(vehicle);
    }

    /**
     *
     * @param vehicle Vehicle that customer wants to rent
     * @return Returns true if renting is successful
     * @throws NullPointerException When given parameter is null
     */
    public boolean rentRequest(Vehicle vehicle, SalesManager manager) throws NullPointerException {
        boolean rented = manager.rent(vehicle, this);

        if(rented && myVehicle == null) {
            System.out.println("Sales manager approved your rent request. You rented the car.");
            myVehicle = vehicle;
        }
        else if(rented)
            System.out.println("You already have rented a car. First return rented car back to rent a new one.");
        else
            System.out.println("Sales manager rejected your rent request. You couldn't rent the car.");

        return rented;
    }

    /**
     * Returns customer's car to the given branch
     * @param branch Branch that gets rented car back
     */
    public void returnBackToBranch(RentalBranch branch) {
        if(branch == null)
            System.out.println("Given branch is not valid.");
        else if(myVehicle == null)
            System.out.println("You don't have a car to return.");
        else {
            // giving back to the branch
            branch.addWithPriority(myVehicle);
            // removing from customer
            myVehicle = null;
        }
    }

    /**
     * Return's customer's car back to branch by transportation personnel and sends it to the service branch
     * @param personnel Personnel that carries the car
     * @param rental Branch that car belongs to
     * @param service Service that car goes to for maintenance
     */
    public void returnToTransportation(TransportPersonnel personnel, RentalBranch rental, ServiceBranch service) {
        // temp car
        Vehicle temp = myVehicle;
        // first returning to the branch
        returnBackToBranch(rental);
        // than transporting it into service
        personnel.transportRentalToService(rental, service, temp);
    }

    @Override
    public int compareTo(Customer o) {
        String ID1 = this.getID();
        String ID2 = o.getID();

        return ID1.compareTo(ID2);
    }

    private void createID(){
        this.ID = Integer.toString(customer_ID + count++);
    }
}
