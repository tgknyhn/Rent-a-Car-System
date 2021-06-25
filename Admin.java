import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Admin implements User {
	private final int MAX_EMP_SIZE = 100000;
	private String name;
	private String lastname;
	private String ID = "0";
	private String email;
	private String password;
	private Company comp;


	public Admin(){
		setName("empty");
		setLastname("empty");
		setEmail("empty");
		setPassword("empty");
		comp = null;
	}

	/**
	 * Initializes transportation personnel.
	 * @param name Name of the transportation personnel
	 * @param lastname Surname of the transportation personnel
	 * @param ID ID of the transportation personnel
	 * @param email Email of the transportation personnel
	 * @param password Password of the transportation personnel
	 */
	public Admin(String name, String lastname, String ID, String email, String password ) {
		setName(name);
		setLastname(lastname);
		setEmail(email);
		this.ID = ID;
		setPassword(password);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public void setEmail(String email) {
	this.email = email;
	}

	@Override
	public void setPassword(String password) {
	this.password = password;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getLastname() {
		return this.lastname;
	}

	@Override
	public String getID() {
		return this.ID;
	}

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

	/**
	 * Adds all branches a new vehicle kind.
	 * @param vehicle Vehicle to be added.
	 */
	public void addVehicle(RentalBranch branch,  Vehicle vehicle ) {

		/*try {
			FileReader fr = new FileReader("vehicles.txt");
			BufferedReader br = new BufferedReader(fr);

			String line;
			while( (line = br.readLine()) != null){
				String[] tokens = line.split("-");

				if(tokens[0].equals(vehicle.getBrand()) && tokens[1].equals(vehicle.getModel())
					&& Integer.parseInt(tokens[2]) == vehicle.getPrice()){

					System.out.println("The vehicle is already in the company.");
					br.close();
					fr.close();
					return;
				}
			}
			fr.close();
			br.close();

			FileWriter fw = new FileWriter("vehicles.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);

			StringBuilder sb = new StringBuilder();
			sb.append("\n").append(vehicle.getBrand()).append("-").append(vehicle.getModel());
			sb.append("-").append(vehicle.getPrice());

			bw.write(sb.toString());

			bw.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		branch.getVehicles().add(vehicle);
	}

	/**
	 * Removes a vehicle from the company.
	 * @param v Vehicle to be removed.
	 * @return Returns true if removing is succesful.
	 */
	public boolean removeVehicle(RentalBranch rb, Vehicle v) {
		rb.getVehicles().remove(v);
		try{
			FileReader fr = new FileReader("vehicles.txt");
			BufferedReader br = new BufferedReader(fr);

			File f1 = new File("Temp.txt");
			if(f1.exists()) {
				f1.delete();
			}

			FileWriter fw = new FileWriter("Temp.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);

			String line;

			while( (line=br.readLine()) != null) {
				if(!line.equals(v.getBrand() + "-" + v.getModel() + "-" + v.getPrice())){
					bw.write(line);
					bw.newLine();
				}
			}

			bw.close();
			br.close();
			fr.close();
			fw.close();

			File f = new File("vehicles.txt");
			f.delete();

			fr = new FileReader("Temp.txt");
			br = new BufferedReader(fr);

			fw = new FileWriter("vehicles.txt",true);
			bw = new BufferedWriter(fw);

			/* This part of the code copies the lines from temp.txt to vehicles.txt.  */
			int flag = 0;
			while( (line=br.readLine()) != null) {
				if(flag == 0){
					bw.write(line);
					flag = 2;
				}
				else {
					bw.newLine();
					bw.write(line);
				}

				if((line=br.readLine()) != null){
					bw.newLine();
					bw.write(line);
				}

			}
			bw.close();
			br.close();
			fr.close();
			fw.close();

			f = new File("Temp.txt");
			if(f.exists()) {
				f.delete();
			}

			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean addRentalBranch(ArrayList<RentalBranch> rBranches, Branch rb) {

		if(rBranches.contains(rb))
			return false;

		rBranches.add((RentalBranch) rb);
			return true;
	}

	public boolean removeRentalBranch(ArrayList<RentalBranch> rBranches, RentalBranch branch) {
		return rBranches.remove(branch);
	}

	public boolean addServiceBranch(ArrayList<ServiceBranch> sBranches , Branch sb) {
		if(sBranches.contains(sb))
			return false;

		sBranches.add((ServiceBranch) sb);
		return true;
	}

	public boolean removeServiceBranch(ArrayList<ServiceBranch> sBranches, ServiceBranch branch) {
		return sBranches.remove(branch);
	}

	public boolean addSalesManager(SkipList<SalesManager> sManagers, SalesManager sManager) {
		sManagers.add(sManager);

		return true;
	}	

	public boolean removeSalesManager(SkipList<SalesManager> sManagers, SalesManager sm) {
		if (sManagers.remove(sm) == null)
			return false;

		return true;
	}

	public boolean addTransportPersonnel(SkipList<TransportPersonnel> tPersonnel, TransportPersonnel tp) {
		tPersonnel.add(tp);

		return true;
	}

	public boolean removeTransportPersonnel(SkipList<TransportPersonnel> tPersonnel, TransportPersonnel tp) {

		if (tPersonnel.remove(tp) == null)
			return false;
		return true;
	}

	public boolean addTechnician(SkipList<Technician> technicians, Technician tech) {
		technicians.add(tech);

		return true;
	}

	public boolean removeTechnician(SkipList<Technician> technicians, Technician tech) {
		if (technicians.remove(tech) == null)
			return false;
		return true;
	}

	public ArrayList<User> list_all_employees(SkipList<TransportPersonnel> transportPersonnels ,
											  SkipList<Technician> technicians , SkipList<SalesManager> salesManagers) {
		
		ArrayList<User> employees = new ArrayList<User>();
		
		for(int i = 0; i<transportPersonnels.size(); i++) {
			employees.add(transportPersonnels.get(i));
		}
		for(int i = 0; i<technicians.size(); i++) {
			employees.add(technicians.get(i));
		}
		for(int i = 0; i<salesManagers.size(); i++) {
			employees.add(salesManagers.get(i));
		}
		
		// All employees added.

		MergeSort.sort(employees);

		return employees;
	}

	// Creates id, adds the type of the user to head of ID.
	// Checks for t because there is to t's/(Technician, Transportation Personnel)
	// If its admin, and there is already 5 admins, ID will be "A006", if 14 admins it will be "A015".

	public String createId(char code, int size) {
		String id = "";
		if (code == 't') //To seperate T with TP.
			id += "TP";
		else
			id += code;
		
        for (int i = 1; i < 3; i++) { //This loop for add '0' to id if digit is small.
        	if (size+1 < Math.pow(10, 3-i))
        		id += "0";
        }
        id += Integer.toString(size+1);
        return id;
	}


}







