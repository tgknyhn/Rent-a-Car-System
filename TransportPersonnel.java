import java.util.ArrayList;

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
	 * @param vehicles
	 * @param vehicle
	 * @return Returns index of searched vehicle in vehicles list if it exists
	 */
	public Integer indexOfVehicle(ArrayList<Vehicle> vehicles, Vehicle vehicle) {
		int size = vehicles.size();
		
		if(size == 0) {
			System.out.println("There is no vehicles!");
			return -1;
		}
		
		for(int i = 0 ; i < size ; i++) {
			Vehicle currentVehicle = vehicles.get(i);
			
			if(currentVehicle.getModel().equals(vehicle.getModel()) && currentVehicle.getColor() == vehicle.getColor()) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Transports the maintained vehicle from service branch to the rental branch. 
	 * @param service Service Branch
	 * @param rental Rental Branch
	 * @param vehicle
	 * @return Returns true if transportation is successfull
	 */
	public boolean transportServiceToRental(ServiceBranch service, RentalBranch rental, Vehicle vehicle) {
		int vehicleIndex = indexOfVehicle(service.getVehicles(), vehicle);
		
		if(vehicleIndex == -1) {
			System.out.println("Invalid vehicle!");
			return false;
		}
		
		if(vehicle.getDamage() > 0) {
			System.out.println("Vehicle is still damaged!");
			return false;
		}
		service.removeVehicle(vehicleIndex);
		rental.addVehicle(vehicleIndex);
		
		return true;
	}
	
	/**
	 * Transports the vehicle from rental branch to the service branch for maintenance.
	 * @param rental Rental Branch
	 * @param service Service Branch
	 * @param vehicle
	 * @return Returns true if transportation is successfull
	 */
	public boolean transportRentalToService(RentalBranch rental, ServiceBranch service, Vehicle vehicle) {
		int vehicleIndex = indexOfVehicle(rental.getVehicles(), vehicle);
		
		if(vehicleIndex == -1) {
			System.out.println("Invalid vehicle!");
			return false;
		}
	
		rental.removeVehicle(vehicleIndex);
		service.addVehicle(vehicleIndex);
		
		return true;
	}
	/**
	 * @param fromRental Rental Branch
	 * @param toRental Rental Branch
	 * @param vehicle
	 * @return Returns true if transportation is successfull
	 */
	public boolean transportRentalToRental(RentalBranch fromRental, RentalBranch toRental, Vehicle vehicle) {
		int vehicleIndex = indexOfVehicle(fromRental.getVehicles(), vehicle);
		
		if(vehicleIndex == -1) {
			System.out.println("Invalid vehicle!");
			return false;
		}
		
		fromRental.removeVehicle(vehicleIndex);
		toRental.addVehicle(vehicleIndex);
		
		return true;	
	}

}	

	

	

