import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class LoginUI extends JFrame implements ActionListener {
    private final String user;
    private JButton button_exit;
    private JButton button_next;

    private final Company company;

    JTextField field_ID;
    JTextField field_branchID;
    JTextField field_password;

    JLabel text_ID;
    JLabel text_branchID;
    JLabel text_password;

    String branchID, ID, password;

    public LoginUI(String user, Company company) {
        // Initializing the data fields
        this.user = user;
        this.company = company;
        // Adding components to the JFrame
        add(getGreeting());
        add(getUserInput());
        add(getButtons());

        // JFrame properties
        setTitle("Login");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x64777a));
        setSize(750, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("DuplicatedCode")
    private JPanel getGreeting() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.setBounds(0,0,750,200);

        // Initializing components
        JLabel text_RentACar = new JLabel();

        // Component properties
        text_RentACar.setFont(new Font("Press Start 2P", Font.PLAIN, 60));

        switch(user) {
            case "Admin" -> {
                text_RentACar.setText("Admin Login");
                text_RentACar.setBounds(40, 80, 750, 100);
            }
            case "Employee" -> {
                text_RentACar.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
                text_RentACar.setText("Employee Login");
                text_RentACar.setBounds(20, 80, 750, 100);
            }
            case "Customer" -> {
                text_RentACar.setFont(new Font("Press Start 2P", Font.PLAIN, 50));
                text_RentACar.setText("Customer Login");
                text_RentACar.setBounds(20, 80, 750, 100);
            }
        }


        // Adding components to the JPanel
        panel.add(text_RentACar);

        // Returning JPanel
        return panel;
    }

    private JPanel getUserInput() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0, 200, 750, 100);

        // Initializing components
        JTextField field_ID       = new JTextField();
        JTextField field_branchID = new JTextField();
        JTextField field_password = new JTextField();

        JLabel text_ID       = new JLabel();
        JLabel text_branchID = new JLabel();
        JLabel text_password = new JLabel();

        // Listeners
        field_ID.addActionListener(e -> ID = field_ID.getText());
        field_branchID.addActionListener(e -> branchID = field_branchID.getText());
        field_password.addActionListener(e -> password = field_password.getText());

        // Component properties
        field_ID.setBounds(320, 20 , 100, 20);
        field_branchID.setBounds(320, 40, 100, 20);
        field_password.setBounds(320, 60, 100, 20);

        text_ID.setText("User ID:");
        text_branchID.setText("Branch ID:");
        text_password.setText("Password:");

        text_ID.setFont(new Font(null, Font.BOLD, 15));
        text_branchID.setFont(new Font(null, Font.BOLD, 15));
        text_password.setFont(new Font(null, Font.BOLD, 15));

        text_ID.setBounds(250, 19, 100, 20);
        text_branchID.setBounds(235, 38, 100, 20);
        text_password.setBounds(235, 58, 100, 20);



        // Adding components to the JPanel
        if(user.equals("Admin") || user.equals("Customer")) {
            panel.add(field_ID);          panel.add(text_ID);
            panel.add(field_password);    panel.add(text_password);
        }
        else {
            panel.add(field_branchID);
            panel.add(text_branchID);
        }

        return panel;
    }

    @SuppressWarnings("DuplicatedCode")
    private JPanel getButtons() {
        // Initializing JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0,300, 750, 100);
        panel.setBackground(Color.BLACK);

        // Initializing components
        button_exit = new JButton("Exit");
        button_next = new JButton("Next");

        // Listeners
        button_exit.addActionListener(this);
        button_next.addActionListener(this);

        // Component properties
        button_exit.setBounds(0,0, 375, 70);
        button_next.setBounds(375,0, 375, 70);

        button_exit.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_next.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

        // Adding components to the JPanel
        panel.add(button_exit);
        panel.add(button_next);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_exit)
            System.exit(0);
        else if(e.getSource() == button_next) {
            if(user.equals("Admin")) {
                Admin admin = company.getAdmin();
                if(admin.getID().equals(ID) && admin.getPassword().equals(password)) {
                    System.out.println("Admin successfully login to the system");
                    // Admin gui
                }
                else
                    System.out.println("Admin Login: Invalid ID or Password!");
            }
            else if(user.equals("Employee")) {
                if(Integer.parseInt(ID) >= 10_000 && Integer.parseInt(ID) <= 20_000) {
                    SkipList<SalesManager> employees = company.getSalesManagers();
                    int size = employees.size();

                    for(int i=0; i<size; i++) {
                        if(employees.get(i).getID().equals(ID) && employees.get(i).getPassword().equals(password)) {
                            dispose();
                            // Sales Manager gui
                        }
                    }
                }
                else if(Integer.parseInt(ID) >= 20_000 && Integer.parseInt(ID) <= 30_000) {
                    SkipList<Technician> employees = company.getTechnicians();
                    int size = employees.size();

                    for(int i=0; i<size; i++) {
                        if(employees.get(i).getID().equals(ID) && employees.get(i).getPassword().equals(password)) {
                            dispose();
                            // Technician gui
                        }
                    }
                }
                else if(Integer.parseInt(ID) >= 30_000 && Integer.parseInt(ID) <= 40_000) {
                    SkipList<TransportPersonnel> employees = company.getTransportPersonnels();
                    int size = employees.size();

                    for(int i=0; i<size; i++) {
                        if(employees.get(i).getID().equals(ID) && employees.get(i).getPassword().equals(password)) {
                            dispose();
                            // Technician gui
                        }
                    }
                }
                else
                    System.out.println("Employee Login: Invalid User");
            }
            else if(user.equals("Customer")) {

                AVLTree<Customer> customers = company.getCustomers();
                Customer customer = null;
                boolean isValid = false;

                Iterator<Customer> itr = customers.iterator();

                while(itr.hasNext()) {
                    customer = itr.next();

                    if(customer.getID().equals(ID) && customer.getPassword().equals(password)) {
                        isValid = true;
                        break;
                    }
                }

                if(isValid) {
                    dispose();
                    try {
                        new CustomerUI(null, this.company, customer);
                    } catch (FileNotFoundException fileNotFoundException) {
                        System.exit(0);
                    }
                }
            }
        }
    }



}
