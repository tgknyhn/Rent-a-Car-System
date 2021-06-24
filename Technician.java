import java.util.ArrayList;

public class Technician implements User , Comparable<Technician>{
/**/
	private final int technician_ID = 20000;
	private static int count = 0;
	private String name;
	private String lastname;
	private String ID;
	private String email;
	private String password;

    public Technician(){
        setName("empty");
		setLastname("empty");
		createID();
        setEmail("empty");
        setPassword("empty");
    }
    
    /**
     * Initializes transportation personnel.
     * @param name Name of the transportation personnel
     * @param lastname Surname of the transportation personnel
     * @param email Email of the transportation personnel
     * @param password Password of the transportation personnel
     */
	public Technician(String name, String lastname, String email, String password) {
		setName(name);
		setLastname(lastname);
		createID();
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
	//public int checkVehicleSituations(Vehicle vehicle) {
		/*vehicle clası içersinde araç parçarları olursa(motor far şanzıman kaporta)
		bu parçaları. araç kaza yapma methoduyla çağırıp belli bir yüzdelik ile hasar verebilir 
		Technician içersinde tutulan fiyat listesinden bu parçaların fiyatı çıkartılıp fatura kesilebilir.*/

	//	return 0;
	//}

	/**
	 * @param vehicle
	 * @return return false if the vehicle is badly damaged beyond repair. If it is repaired, return true.
	 */	
	//public boolean repairTheDamagedVehicle (Vehicle vehicle) {
		/*hasar miktarını ölcerek belli bir yüzdeliğe göre aracın tamir edilip edilemeyeceğini return eder*/
	//	return true;
	//}

	/**
	 * @param vehicle
	 * @return Returns the cost of bill
	 */
	public void maintenanceVehilcle(Vehicle vehicle){
		
		String[] vehicleParts  = vehicle.getVehicleParts();
		int[] partsHealth      = vehicle.getPartsHealth();
		double[] costRatioOfPiece = vehicle.getCostRatioOfPiece();
		int numberOfParts = vehicle.getNumberOfParts();
		int totalPriceOfCar = vehicle.getTotalPriceOfCar();

		double bill=0;
		for(int i=0;i<numberOfParts;i++){
			double tempBill=0;
			tempBill=((100.0-partsHealth[i]))/100.0*costRatioOfPiece[i]*totalPriceOfCar;
			System.out.println("Part Name: "+vehicleParts[i]+"\tDamege Rate: "+(100-partsHealth[i])+"%"+"\tRepair Cost: "+tempBill+"$");
			bill+=tempBill;
		}
		System.out.println("Total Repair Cost:"+bill+"$");
		fixCar(vehicle);

	}

	private void fixCar(Vehicle vehicle){
		int[] partsHealth      = vehicle.getPartsHealth();
		int numberOfParts = vehicle.getNumberOfParts();
		int [] newPartsHealth = new int[numberOfParts];
			for(int i=0;i<numberOfParts;i++){
			newPartsHealth[i]=100;
		}
		vehicle.setPartsHealth(newPartsHealth);
	}


	@Override
	public int compareTo(Technician o) {
		String ID1 = this.getID();
		String ID2 = o.getID();

		return ID1.compareTo(ID2);
	}

	private void createID(){
		if(count > 9999){
			System.out.println("There is not enough space for a new Technician.");
			System.exit(1);
		}
		ID = Integer.toString( technician_ID + count++);
	}
}
