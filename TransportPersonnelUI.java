import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TransportPersonnelUI extends JFrame implements ActionListener {
    private JButton button_back;
    private JButton button_exit;
    private JButton button_search;

    private JComboBox<String> comboBox_brands;
    private JComboBox<String> comboBox_branches;
    private JComboBox<String> comboBox_branches2;

    private TransportPersonnel employee;
    private Map<String, Integer> provinceMap;
    private Map<Integer, String> provinceMapReverse;

    private final Company company;

    public TransportPersonnelUI(BranchGraph graph, Company company, TransportPersonnel employee) throws FileNotFoundException {
        // Initializing data fields
        this.company = company;
        this.employee = employee;
        initProvinceMap();


        // Adding components to the JFrame
        add(getGreeting());
        add(getButtons());
        add(getBranches());
        add(getBranches2());
        add(getModels());
        add(getSearch());

        // JFrame properties
        setTitle("Transportation Personnel Menu");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x64777a));
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public JPanel getGreeting() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.setBounds(0,0,1000,250);

        // Initializing components
        JLabel text_transportPersonnelMenu = new JLabel();

        // Component properties
        text_transportPersonnelMenu.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        text_transportPersonnelMenu.setText("Transportation Personnel Menu");
        text_transportPersonnelMenu.setBounds(45,80, 1000, 100);


        // Adding components to the JPanel
        panel.add(text_transportPersonnelMenu);

        // Returning JPanel
        return panel;

    }

    private JPanel getButtons() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0,400, 1000, 100);
        panel.setBackground(Color.BLACK);

        // Initializing components
        button_back = new JButton("Back");
        button_exit = new JButton("Exit");

        // Listeners
        button_back.addActionListener(this);
        button_exit.addActionListener(this);

        // Component properties
        button_back.setBounds(0,0, 500, 70);
        button_exit.setBounds(500,0, 500, 70);

        button_back.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_exit.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

        // Adding components to the JPanel
        panel.add(button_back);
        panel.add(button_exit);

        return panel;
    }

    private JPanel getModels() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0,350,500,50);

        // Initializing the components
        comboBox_brands = new JComboBox<>();
        JLabel text_models = new JLabel();

        // Listeners
        comboBox_brands.addActionListener(this);

        // Component properties
        comboBox_brands.setBounds(120, 15, 125, 20);
        comboBox_brands.addItem("BMW");
        comboBox_brands.addItem("Toyota");
        comboBox_brands.addItem("Volkswagen");
        comboBox_brands.addItem("Dacia");
        comboBox_brands.addItem("Renault");
        comboBox_brands.addItem("Audi");
        comboBox_brands.addItem("Volvo");

        text_models.setBounds(15, 14, 125, 20);
        text_models.setFont(new Font(null, Font.BOLD, 15));
        text_models.setText("Select Brand:");

        // Adding components to the JPanel
        panel.add(comboBox_brands);
        panel.add(text_models);

        // Returning JPanel
        return panel;
    }

    private JPanel getBranches() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0,250,500,50);

        // Initializing the components
        comboBox_branches = new JComboBox<>();
        JLabel text_branches = new JLabel();

        // Listeners
        comboBox_branches.addActionListener(this);

        // Component properties
        comboBox_branches.setBounds(120, 15, 125, 20);
        for(int i=1; i<=81; i++)
            comboBox_branches.addItem("Rental-"+provinceMapReverse.get(i));
        
        for(int i=1; i<=81; i++)
            comboBox_branches.addItem("Service-" + provinceMapReverse.get(i));

        text_branches.setBounds(10, 14, 125, 20);
        text_branches.setFont(new Font(null, Font.BOLD, 15));
        text_branches.setText("From Branch:");

        // Adding components to the JPanel
        panel.add(comboBox_branches);
        panel.add(text_branches);

        // Returning JPanel
        return panel;
    }
    private JPanel getBranches2() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0,300,500,50);

        // Initializing the components
        comboBox_branches2 = new JComboBox<>();
        JLabel text_branches = new JLabel();

        // Listeners
        comboBox_branches2.addActionListener(this);

        // Component properties
        comboBox_branches2.setBounds(120, 15, 125, 20);
        for(int i=1; i<=81; i++)
            comboBox_branches2.addItem("Rental-" + provinceMapReverse.get(i));
        
        for(int i=1; i<=81; i++)
            comboBox_branches2.addItem("Service-" + provinceMapReverse.get(i));

        text_branches.setBounds(10, 14, 125, 20);
        text_branches.setFont(new Font(null, Font.BOLD, 15));
        text_branches.setText("To Branch:");

        // Adding components to the JPanel
        panel.add(comboBox_branches2);
        panel.add(text_branches);

        // Returning JPanel
        return panel;
    }
    private JPanel getSearch() {
        // Initializing the JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(500,250,500,150);

        // Initializing the components
        button_search = new JButton("Transport");

        // Listeners
        button_search.addActionListener(this);

        // Component properties
        button_search.setBounds(0, 0, 300, 150);


        // Adding components to the JPanel
        panel.add(button_search);

        // Returning JPanel
        return panel;
    }


    private void initProvinceMap() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("provinces.txt"));

        provinceMap = new HashMap<>();
        provinceMapReverse = new HashMap<>();

        int branchID;
        String province;

        for(int i=0; i<81 ;i++) {
            // Getting information
            branchID = Integer.parseInt(scan.nextLine());
            province = scan.nextLine();
            // Inserting into the Map
            provinceMap.put(province, branchID);
            provinceMapReverse.put(branchID, province);
        }

        scan.close();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == button_back) {
            dispose();
            new MenuUI(this.company);
        }
        else if(source == button_exit)
            System.exit(0);
        else if(source == button_search) {
            new SearchUI((String)comboBox_brands.getSelectedItem()).setAlwaysOnTop(true);
        }
    }


    private class SearchUI extends JFrame implements ActionListener {
        private JComboBox<String> selectedVehicles;
        private ArrayList<RentalBranch> rentals = company.getRentalBranches();
        private ArrayList<ServiceBranch> services = company.getServiceBranch();
        
        private JButton button_exit;


        public SearchUI(String brand){
            selectedVehicles = new JComboBox<>();
            
            String branch1= (String)comboBox_branches.getSelectedItem();
            String branch2 = (String)comboBox_branches2.getSelectedItem();
            
            String token1[] = branch1.split("-", 2);
            String type1 = token1[0]; String province1 = token1[1];
            
            String token2[] = branch2.split("-", 2);
            String type2 = token2[0]; String province2 = token2[1];
            RentalBranch b1=null,b2=null;
            ServiceBranch b3=null;
            

            if(type1.equals("Rental") && type2.equals("Service"))
            {
            	for(ServiceBranch b : services) {
            	
            		if(b.getName().equals(province2))
            		{
            			b3 = b;
            		}
            	}
            	for(RentalBranch b : rentals) {
            		if(b.getBranchName().equals(province1))
            		{
            			b1 = b;
        			   for (Vehicle vehicle : b1.getVehicles())
        			   {
        				   if (vehicle.getBrand().equals(brand))
	       	                {
        					   
	       	                	selectedVehicles.addItem(vehicle.getBrand() + " | " + vehicle.getModel() + " | " + vehicle.getPrice());
	       	                	if(employee.transportRentalToService(b1, b3, vehicle))
	       	                	{
 	       	                		System.out.println("Vehicle is transported");
 	       	                	}
 	       	                	else
 	       	                	{
 	       	                		System.out.println("Vehicle couldn't transported!");
 	       	                	}
	       	                	break;
	       	                }   
        			   }
        	                   
            		}
            	}
            	
            	
            }
            else if(type1.equals("Service") && type2.equals("Rental") )
            {
            	for(RentalBranch b : rentals) {
            		if(b.getBranchName().equals(province1))
            		{
            			b1 = b;       
            		}
            	}
            	for(ServiceBranch b : services) {
            		if(b.getName().equals(province2))
            		{
            			b3 = b;
            			if(b3.getVehiclesInService() == null)
            			{
            				System.out.println("There is no vehicle in the service!");
            				break;
            			}
            				
            			for (Vehicle vehicle : b3.getVehiclesInService())
         			   	{
         				   if (vehicle.getBrand().equals(brand))
 	       	                {
 	       	                	selectedVehicles.addItem(vehicle.getBrand() + " | " + vehicle.getModel() + " | " + vehicle.getPrice());
 	       	                	if(employee.transportServiceToRental(b3, b1, vehicle))
 	       	                	{
	       	                		System.out.println("Vehicle is transported");
	       	                	}
	       	                	else
	       	                	{
	       	                		System.out.println("Vehicle couldn't transported!");
	       	                	}
 	       	                	break;
 	       	                }   
         			   }
            		}
            	}
            	
            	
            }
            else
            {
            	for(RentalBranch b : rentals) {
            		if(b.getBranchName().equals(province1))
            		{
            			b1 = b;       
            		}
            	}
            	for(RentalBranch b : rentals) {
            		if(b.getBranchName().equals(province2))
            		{
            			b2 = b;
            			for (Vehicle vehicle : b2.getVehicles())
         			   	{
         				   if (vehicle.getBrand().equals(brand))
 	       	                {
 	       	                	selectedVehicles.addItem(vehicle.getBrand() + " | " + vehicle.getModel() + " | " + vehicle.getPrice());
 	       	                	if(employee.transportRentalToRental(b2, b1, vehicle))
 	       	                	{
 	       	                		System.out.println("Vehicle is transported");
 	       	                	}
 	       	                	else
 	       	                	{
 	       	                		System.out.println("Vehicle couldn't transported!");
 	       	                	}
 	       	                	break;
 	       	                }   
         			   }	
            		}
            	}
            }
           
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == this.button_exit)
                dispose();
        }
    }

   
}
