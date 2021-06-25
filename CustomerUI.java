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

@SuppressWarnings("DuplicatedCode")
public class CustomerUI extends JFrame implements ActionListener {
    private JButton button_back;
    private JButton button_exit;
    private JButton button_vehicleStat;
    private JButton button_returnCar;
    private JButton button_search;

    private JComboBox<String> comboBox_brands;
    private JComboBox<String> comboBox_branches;

    private Customer customer;
    private BranchGraph graph;
    private Map<String, Integer> provinceMap;
    private Map<Integer, String> provinceMapReverse;

    private final Company company;

    public CustomerUI(BranchGraph graph, Company company, Customer customer) throws FileNotFoundException {
        // Initializing data fields
        this.company = company;
        this.graph = graph;
        this.customer = customer;
        initProvinceMap();


        // Adding components to the JFrame
        add(getGreeting());
        add(getButtons());
        add(getModels());
        add(getBranches());
        add(getSearch());
        add(getStatus());
        add(getReturn());

        this.button_returnCar.setEnabled(false);
        // JFrame properties
        setTitle("Customer Menu");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x64777a));
        setSize(750, 400);
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
        panel.setBounds(0,0,750,200);

        // Initializing components
        JLabel text_customerMenu = new JLabel();

        // Component properties
        text_customerMenu.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
        text_customerMenu.setText("Customer Menu");
        text_customerMenu.setBounds(45,80, 750, 100);


        // Adding components to the JPanel
        panel.add(text_customerMenu);

        // Returning JPanel
        return panel;

    }

    private JPanel getButtons() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0,300, 750, 100);
        panel.setBackground(Color.BLACK);

        // Initializing components
        button_back = new JButton("Back");
        button_exit = new JButton("Exit");

        // Listeners
        button_back.addActionListener(this);
        button_exit.addActionListener(this);

        // Component properties
        button_back.setBounds(0,0, 375, 70);
        button_exit.setBounds(375,0, 375, 70);

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
        panel.setBounds(0,200,275,50);

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
        panel.setBounds(0,250,275,50);

        // Initializing the components
        comboBox_branches = new JComboBox<>();
        JLabel text_branches = new JLabel();

        // Listeners
        comboBox_branches.addActionListener(this);

        // Component properties
        comboBox_branches.setBounds(120, 15, 125, 20);
        for(int i=1; i<=81; i++)
            comboBox_branches.addItem(provinceMapReverse.get(i));

        text_branches.setBounds(10, 14, 125, 20);
        text_branches.setFont(new Font(null, Font.BOLD, 15));
        text_branches.setText("Select Branch:");

        // Adding components to the JPanel
        panel.add(comboBox_branches);
        panel.add(text_branches);

        // Returning JPanel
        return panel;
    }

    private JPanel getSearch() {
        // Initializing the JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(275,200,200,100);

        // Initializing the components
        button_search = new JButton("Search Vehicles");

        // Listeners
        button_search.addActionListener(this);

        // Component properties
        button_search.setBounds(25, 25, 150, 50);


        // Adding components to the JPanel
        panel.add(button_search);

        // Returning JPanel
        return panel;
    }

    private JPanel getStatus() {
        // Initializing the JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(475,200,275,50);

        // Initializing the components
        button_vehicleStat = new JButton("Vehicle Status");

        // Listeners
        button_vehicleStat.addActionListener(this);

        // Component properties
        button_vehicleStat.setBounds(28, 13, 200, 25);

        // Adding components to the JPanel
        panel.add(button_vehicleStat);

        // Returning JPanel
        return panel;
    }

    private JPanel getReturn() {
        // Initializing the JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(475,250,275,50);

        // Initializing the components
        button_returnCar = new JButton("Return the Car");

        // Listeners
        button_returnCar.addActionListener(this);

        // Component properties
        button_returnCar.setBounds(28, 13, 200, 25);

        // Adding components to the JPanel
        panel.add(button_returnCar);

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
            new SearchUI(comboBox_branches.getSelectedIndex() ,(String)comboBox_brands.getSelectedItem()).setAlwaysOnTop(true);
        }
        else if(source == button_vehicleStat) {
            new StatusUI(customer.getMyVehicle()).setAlwaysOnTop(true);
        }
        else if(source == button_returnCar) {
            customer.returnBackToBranch(new RentalBranch("yey"));
            button_returnCar.setEnabled(false);
        }
    }


    private class SearchUI extends JFrame implements ActionListener {
        private JComboBox<String> selectedVehicles;
        private ArrayList<Vehicle> vehicles;
        private RentalBranch rBranch;

        private JButton button_exit;
        private JButton button_rent;

        public SearchUI(int branch_index, String brand){
            selectedVehicles = new JComboBox<>();
            
            rBranch = company.getRentalBranches().get(branch_index);
            vehicles = rBranch.getVehicles();

            for (Vehicle vehicle : vehicles)
                if (vehicle.getBrand().equals(brand))
                    selectedVehicles.addItem(vehicle.getBrand() + " | " + vehicle.getModel() + " | " + vehicle.getPrice());

            selectedVehicles.setLayout(null);
            selectedVehicles.setBounds(15, 60, 150, 20);

            add(selectedVehicles);
            add(this.getGreeting());
            add(this.getButtons());

            // JFrame properties
            setTitle("Search Vehicles");
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setBackground(new Color(0x64777a));
            setSize(200, 180);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        private JPanel getGreeting() {
            // Initializing JPanel
            JPanel panel = new JPanel();

            // JPanel properties
            panel.setLayout(null);
            panel.setBounds(0,0,200,40);

            // Initializing components
            JLabel text_customerMenu = new JLabel();

            // Component properties
            text_customerMenu.setFont(new Font(null, Font.PLAIN, 20));
            text_customerMenu.setText("Vehicles");
            text_customerMenu.setBounds(50,10, 200, 20);


            // Adding components to the JPanel
            panel.add(text_customerMenu);

            // Returning JPanel
            return panel;
        }

        private JPanel getButtons() {
            // Initializing JPanel
            JPanel panel = new JPanel();

            // JPanel properties
            panel.setLayout(null);
            panel.setBounds(0,100, 200, 100);
            panel.setBackground(Color.BLACK);

            // Initializing components
            button_exit = new JButton("Back");
            button_rent = new JButton("Rent");

            // Listeners
            button_exit.addActionListener(this);
            button_rent.addActionListener(this);

            // Component properties
            button_exit.setBounds(0,0, 95, 40);
            button_rent.setBounds(95,0, 95, 40);

            button_exit.setFont(new Font(null, Font.BOLD, 15));
            button_rent.setFont(new Font(null, Font.BOLD, 15));

            // Adding components to the JPanel
            panel.add(button_exit);
            panel.add(button_rent);

            return panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean found = false;
            if(e.getSource() == this.button_exit)
                dispose();
            else if(e.getSource() == this.button_rent) {
                String currVehicle = selectedVehicles.getSelectedItem().toString();

                for(int i=0; i<vehicles.size(); i++) {
                    if(currVehicle.contains(vehicles.get(i).getModel())) {
                        if (customer.rentRequest(vehicles.get(i), new SalesManager())) {
                            button_returnCar.setEnabled(true);
                            vehicles.remove(i);
                            found = true;
                            break;
                        }
                    }

                }
                if (!found) {
                    File file = new File("provinces.txt");
                    try {
                        graph.createGraph(file);
                    } catch (Exception FileNotFoundException) {
                        System.exit(0);
                    }
                    //Check adjacent provinces.
                }
                
            }

        }
    }

    private class StatusUI extends JFrame {
        public StatusUI(Vehicle vehicle) {
            JLabel text = new JLabel();

            text.setLayout(null);
            text.setFont(new Font(null, Font.BOLD, 20));
            if(vehicle == null) {
                text.setText("You don't own a vehicle");
                text.setBounds(0,0, 400, 100);
            }
            else {
                text.setText("You rented \"" + vehicle.getBrand() + " | " + vehicle.getModel() + " | " + vehicle.getPrice() + "\"");
                text.setBounds(0,0, 400, 100);
            }


            add(text);

            // JFrame properties
            setTitle("Vehicle Status");
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setBackground(new Color(0x64777a));
            setSize(600, 150);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }
    }
}
