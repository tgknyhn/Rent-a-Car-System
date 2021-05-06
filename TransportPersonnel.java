import java.util.ArrayList;
import java.util.Queue;

public class TransportPersonnel implements User {

	private String name;
	private String lastname;
	private String ID;
	private String email;
	private String password;

    public TransportPersonnel(){
        setName("empty");
		setLastname("empty");
		setID("empty");
        setEmail("empty");
        setPassword("empty");
    }
    
    /**
     * Initializes transportation personnel.
     * @param name Name of the transportation personnel
     * @param lastname Surname of the transportation personnel
     * @param ID ID of the transportation personnel
     * @param email Email of the transportation personnel
     * @param password Password of the transportation personnel
     */
	public TransportPersonnel(String name, String lastname, String ID, String email, String password) {
		setName(name);
		setLastname(lastname);
		setID(ID);
		setEmail(email);
		setPassword(password);
	}
    
    /**
     * @return Name of the transportation personnel
     */
    @Override
	public String getName() {
		return this.name;
	}

    /**
     * @return Last name of the transportation personnel
     */
    @Override
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @return ID of the transportation personnel
	 */
	@Override
	public String getID() {
		return this.ID;
	}

    /**
     * @return Email of the transportation personnel
     */
    @Override
	public String getEmail() {
		return email;
	}

	/**
	 * @return Password of the transportation personnel
	 */
	@Override
	public String getPassword() {
		return password;
	}

	 /**
     * Changes name of the transportation personnel
     * @param name 
     */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	 /**
     * Changes Last name of the transportation personnel
     * @param lastname 
     */
	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	 /**
     * Changes ID of the transportation personnel
     * @param ID
     */
    @Override
	public void setID(String ID) {
		this.ID = ID;
	}

	 /**
     * Changes email of the transportation personnel
     * @param email
     */
	@Override
	public void setEmail(String email) {
	this.email = email;
	}

	 /**
     * Changes password of the transportation personnel
     * @param password
     */
	@Override
	public void setPassword(String password) {
	this.password = password;
	}

	/**
	 * Transports the maintained vehicle from service branch to the rental branch. 
	 * @param service Service Branch
	 * @param rental Rental Branch
	 * @return Returns true if transportation is successfull
	 */
	public boolean transportServiceToRental(ServiceBranch service, RentalBranch rental) {
		/* From queue(remove) to arraylist(add) */

		return true;
	}
	
	/**
	 * Transports the vehicle from rental branch to the service branch for maintenance.
	 * @param rental Rental Branch
	 * @param service Service Branch
	 * @return Returns true if transportation is successfull
	 */
	public boolean transportRentalToService(RentalBranch rental, ServiceBranch service) {
		/* From arraylist(remove) to queue(add) */

		return true;
	}
	/**
	 * @param fromRental Rental Branch
	 * @param toRental Rental Branch
	 * @return Returns true if transportation is successfull
	 */
	public boolean transportRentalToRental(RentalBranch fromRental, RentalBranch toRental) {
		/* From arraylist(remove) to arraylist(add) */

		return true;
	}



}	

	

	

