import java.util.ArrayList;

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
     * @param upperLimit Maximum price of the vehicle
     * @param lowerLimit Minimum price of the vehicle
     * @throws NullPointerException When vehicle list size is 0
     */
    public void searchVehicles(ArrayList<Vehicle> vehicles, String model, int upperLimit, int lowerLimit) throws NullPointerException {
        final int size = vehicles.size();

        // throwing exception when size of vehicle list is 0
        if(size == 0)
            throw new NullPointerException();

        // printing available vehicles with given parameters
        for(int i=0, j=1; i<size; i++) {
            if(vehicles.get(i).model.equals(model) && vehicles.get(i).price < upperLimit && vehicles.get(i).price > lowerLimit) {
                System.out.println(j + ") " + vehicles.get(i));
                j++;
            }
        }
    }

    /**
     * Rents the car for the customer if employee decides that everything is present by the customer.
     * @param vehicle Vehicle that customer wants to rent
     * @return Returns true if renting is successful
     * @throws NullPointerException When given parameter is null
     */
    public boolean rent(Vehicle vehicle) throws NullPointerException {
        /* Sales manager decides whether customer can rent this vehicle or not
        if(...)
            return false;
        */
        // Checking if given parameter is null or not
        if(vehicle == null)
            throw new NullPointerException();
        // Assigning rented car to Customer
        myVehicle = vehicle;
        // Removing rent price of the car from Customer's balance
        remFromBalance(vehicle.getPrice());

        return true;
    }
}

class Vehicle {
    protected String model;
    protected int price;

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
}
