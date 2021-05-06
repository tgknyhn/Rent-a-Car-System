import java.util.ArrayList;

public class Technician implements User {
/**/
	private String name;
	private String lastname;
	private String ID;
	private String email;
	private String password;

    public Technician(){
        setName("empty");
		setLastname("empty");
		setID("empty");
        setEmail("empty");
        setPassword("empty");
    }
    
    /**
     * Initializes transportation personnel.
     * @param name Name of the transportation personnel
     * @param surname Surname of the transportation personnel
     * @param ID ID of the transportation personnel
     * @param email Email of the transportation personnel
     * @param password Password of the transportation personnel
     */
	public Technician(String name, String lastname, String ID, String email, String password) {
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
	 * @param vehicle
	 * @return Returns the cost of the damage
	 */
	public int checkVehicleSituations(Vehicle vehicle) {
		/*vehicle clası içersinde araç parçarları olursa(motor far şanzıman kaporta)
		bu parçaları. araç kaza yapma methoduyla çağırıp belli bir yüzdelik ile hasar verebilir 
		Technician içersinde tutulan fiyat listesinden bu parçaların fiyatı çıkartılıp fatura kesilebilir.*/
	}

	/**
	 * @param vehicle
	 * @return return false if the vehicle is badly damaged beyond repair. If it is repaired, return true.
	 */	
	public boolean repairTheDamagedVehicle (Vehicle vehicle) {
		/*hasar miktarını ölcerek belli bir yüzdeliğe göre aracın tamir edilip edilemeyeceğini return eder*/
	}

	/**
	 * @param vehicle
	 * @return Returns the cost of bill
	 */
	public int maintenanceVehilcle(Vehicle vehicle){
		/*aracın türüne göre periodik bakımının kontrolu.*/
	}



}	
