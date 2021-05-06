import java.util.ArrayList;
import java.util.PriorityQueue;

public class Customer {
    // Bounds for score
    private final int MAX_SCORE = 100;
    private final int MIN_SCORE = -100;
    // Bounds for balance
    private final int MAX_BALANCE = 10000;
    private final int MIN_BALANCE = 0;
    // Customer information
    private String name, surname, address;
    private int phone;
    private int score;
    private int balance;
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
        setPhone(0);
        setScore(0);
        setBalance(0);
    }

    /**
     * Takes all necessary data fields as parameter. Initializes Customer class.
     * @param name Name of the customer
     * @param surname Surname of the customer
     * @param address Address of the customer
     * @param phone Phone number of the customer
     * @param score Score of the customer
     */
    public Customer(String name, String surname, String address, int phone, int score, int balance) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhone(phone);
        setScore(score);
        setBalance(balance);
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
    public String getSurname() {
        return surname;
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
     * @param surname New surname of the customer
     */
    public void setSurname(String surname) {
        this.surname = surname;
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
     * Prints out available vehicles with given parameters
     * @param vehicles Holds all vehicles available
     * @param model Model of the vehicle
     */
    public void searchVehicles(PriorityQueue<Vehicle> vehicles, String model) {
        /* Search through every vehicle in the list, print out only given models. */
    }

    /**
     * Rents the car for the customer if employee decides that everything is present by the customer.
     * @param vehicle Vehicle that customer wants to rent
     * @return Returns true if renting is successful
     * @throws NullPointerException When given parameter is null
     */
    public boolean rent(Vehicle vehicle) throws NullPointerException {
        /*  */

        return true;
    }

    public void bringCarBack(ArrayList<RentalBranch> branches) {
        /* Returns car into branch and system sends this car to the technical branch */
    }


}
