import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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

    private JComboBox<String> comboBox_models;
    private JComboBox<String> comboBox_branches;

    private BranchGraph graph;
    private Map<String, Integer> provinceMap;
    private Map<Integer, String> provinceMapReverse;

    public CustomerUI(BranchGraph graph) throws FileNotFoundException {
        // Initializing data fields
        this.graph = graph;
        initProvinceMap();


        // Adding components to the JFrame
        add(getGreeting());
        add(getButtons());
        add(getModels());
        add(getBranches());
        add(getSearch());
        add(getStatus());
        add(getReturn());

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
        comboBox_models = new JComboBox<>();
        JLabel text_models = new JLabel();

        // Listeners
        comboBox_models.addActionListener(this);

        // Component properties
        comboBox_models.setBounds(120, 15, 125, 20);
        comboBox_models.addItem("selam");
        comboBox_models.addItem("selam2");
        comboBox_models.addItem("selam3");

        text_models.setBounds(15, 14, 125, 20);
        text_models.setFont(new Font(null, Font.BOLD, 15));
        text_models.setText("Select Model:");

        // Adding components to the JPanel
        panel.add(comboBox_models);
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
            new MenuUI();
        }
        else if(source == button_exit)
            System.exit(0);
        else if(source == comboBox_models) {
            System.out.println("ss|nn");
        }
        else if(source == comboBox_branches) {
            System.out.println("selam");
        }
    }
}