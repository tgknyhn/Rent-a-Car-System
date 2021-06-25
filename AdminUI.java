import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("DuplicatedCode")
public class AdminUI extends JFrame implements ActionListener {
    private Admin admin;
    private Company company;

    private JButton button_back;
    private JButton button_exit;
    private JButton button_add_vehicle;
    private JButton button_rem_vehicle;
    private JButton button_add_rBranch;
    private JButton button_rem_rBranch;
    private JButton button_add_sBranch;
    private JButton button_rem_sBranch;
    private JButton button_add_sManager;
    private JButton button_rem_sManager;
    private JButton button_add_tPerson;
    private JButton button_rem_tPerson;
    private JButton button_add_tech;
    private JButton button_rem_tech;


    public AdminUI(Company comp) {
        this.company = comp;
        admin = comp.getAdmin();
        admin.setComp(comp);
        add(greetingMessage());
        add(buttons());
        setTitle("Admin Menu");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x64777a));
        setSize(850, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public JPanel greetingMessage() {
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.setBounds(0, 0, 850, 140);

        JLabel text = new JLabel();

        text.setFont(new Font("Press Start 2P", Font.PLAIN, 60));
        text.setText("Admin Menu");
        text.setBounds(40, 33, 850, 100);

        panel.add(text);
        return panel;
    }

    public JPanel buttons() {
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBounds(0, 140, 850, 260);
        panel.setBackground(new Color(0x64777a));

        //Menu buttons.
        button_back = new JButton("Back");
        button_exit = new JButton("Exit");
        button_add_vehicle = new JButton("Add Vehicle");
        button_rem_vehicle = new JButton("Remove Vehicle");
        button_add_rBranch = new JButton("Add Rental Branch");
        button_rem_rBranch = new JButton("Remove Rental Branch");
        button_add_sBranch = new JButton("Add Service Branch");
        button_rem_sBranch = new JButton("Remove Service Branch");
        button_add_sManager = new JButton("Add Sales Manager");
        button_rem_sManager = new JButton("Remove Sales Manager");
        button_add_tPerson = new JButton("Add Transport Person");
        button_rem_tPerson = new JButton("Remove Transport Person");
        button_add_tech = new JButton("Add Technician");
        button_rem_tech = new JButton("Remove Technician");

        button_back.addActionListener(this);
        button_exit.addActionListener(this);
        button_add_rBranch.addActionListener(this);
        button_rem_rBranch.addActionListener(this);
        button_add_sBranch.addActionListener(this);
        button_rem_sBranch.addActionListener(this);
        button_add_sManager.addActionListener(this);
        button_rem_sManager.addActionListener(this);
        button_add_tPerson.addActionListener(this);
        button_rem_tPerson.addActionListener(this);
        button_add_tech.addActionListener(this);
        button_rem_tech.addActionListener(this);
        button_add_vehicle.addActionListener(this);
        button_rem_vehicle.addActionListener(this);


        button_back.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_exit.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_add_rBranch.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_rem_rBranch.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_add_sBranch.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_rem_sBranch.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_add_sManager.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_rem_sManager.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_add_tPerson.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_rem_tPerson.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_add_tech.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_rem_tech.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_add_vehicle.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
        button_rem_vehicle.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

        button_back.setBounds(0, 180, 425, 60);
        button_exit.setBounds(425, 180, 425, 60);

        //Placing add buttons
        button_add_rBranch.setBounds(10, 10, 180, 40);
        button_add_sBranch.setBounds(10, 60, 180, 40);
        button_add_sManager.setBounds(10, 110, 180, 40);
        button_add_tPerson.setBounds(200, 10, 200, 40);
        button_add_tech.setBounds(200, 60, 200, 40);
        button_add_vehicle.setBounds(200, 110, 200, 40);

        //Placing remove buttons
        button_rem_rBranch.setBounds(440, 10, 180, 40);
        button_rem_sBranch.setBounds(440, 60, 180, 40);
        button_rem_sManager.setBounds(440, 110, 180, 40);
        button_rem_tPerson.setBounds(630, 10, 200, 40);
        button_rem_tech.setBounds(630, 60, 200, 40);
        button_rem_vehicle.setBounds(630, 110, 200, 40);

        panel.add(button_back);
        panel.add(button_exit);
        panel.add(button_add_vehicle);
        panel.add(button_add_rBranch);
        panel.add(button_add_sBranch);
        panel.add(button_add_sManager);
        panel.add(button_add_tPerson);
        panel.add(button_add_tech);
        panel.add(button_rem_vehicle);
        panel.add(button_rem_rBranch);
        panel.add(button_rem_sBranch);
        panel.add(button_rem_sManager);
        panel.add(button_rem_tPerson);
        panel.add(button_rem_tech);

        return panel;
    }

    private class removeUI extends JFrame implements ActionListener {
        private JButton button_back;
        private JButton button_apply;
        private int code;
        private JComboBox<String> combo;

        public removeUI(Admin admin, int code) {
            this.code = code;
            add(buttons());
            add(readProperties());

            setTitle("Remove");
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setBackground(new Color(0x64777a));
            setSize(500, 300);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        private JPanel readProperties() {
            JPanel panel = new JPanel();

            panel.setLayout(null);
            panel.setBounds(0, 0, 500, 220);

            JLabel text = new JLabel();
            text.setFont(new Font(null, Font.BOLD, 15));
            text.setText("Choose Branch");
            text.setBounds(20, 100, 150, 20);

            combo = new JComboBox<>();
            if (code == 0) {
                for (int i = 0; i < company.getRentalBranches().size(); i++) {
                    combo.addItem(company.getRentalBranches().get(i).getBranchName());
                }
            }
            else if (code == 1) {
                for (int i = 0; i < company.getServiceBranch().size(); i++) {
                    combo.addItem(company.getServiceBranch().get(i).getBranchName());
                }
            }
            /*else if (code == 2) {
                combo.addItem("None");
                for (int i = 0; i < company.getSalesManagers().size(); i++) {
                    combo.addItem(company.getSalesManagers().get(i).getName());
                }
            }
            else if (code == 3) {
                combo.addItem("None");
                for (int i = 0; i < company.getTransportPersonnels().size(); i++) {
                    combo.addItem(company.getTransportPersonnels().get(i).getName());
                }
            }
            else if (code == 4) {
                combo.addItem("None");
                for (int i = 0; i < company.getTechnicians().size(); i++) {
                    combo.addItem(company.getTechnicians().get(i).getName());
                }
            }*/
            else if (code == 5) {
                for (int i = 0; i < company.getRentalBranches().size(); i++) {
                    combo.addItem(company.getRentalBranches().get(i).getBranchName());
                }
            }
            combo.setBounds(200, 100, 150, 20);

            panel.add(text);
            panel.add(combo);
            return panel;
        }

        private JPanel buttons() {
            JPanel panel = new JPanel();

            panel.setLayout(null);
            panel.setBounds(0, 220, 500, 80);

            button_back = new JButton("Back");
            button_apply = new JButton("Apply");

            button_back.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
            button_apply.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

            button_back.setBounds(0, 0, 250, 70);
            button_apply.setBounds(250, 0, 250, 70);

            button_back.addActionListener(this);
            button_apply.addActionListener(this);

            panel.add(button_back);
            panel.add(button_apply);
            return panel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == button_back)
                dispose();
            else if (source == button_apply) {
                switch (code) {
                    case 0:
                        admin.removeRentalBranch(company.getRentalBranches(), company.getRentalBranches().get(combo.getSelectedIndex()));
                        break;
                    case 1:
                        admin.removeServiceBranch(company.getServiceBranch(), company.getServiceBranch().get(combo.getSelectedIndex()));
                        break;
                    case 2:
                        //admin.removeSalesManager(company.getSalesManagers(), (SalesManager)company.getSalesManagers().get(combo.getSelectedIndex()));
                        break;
                    case 3:
                        //admin.removeTransportPersonnel(company.getTransportPersonnels(), (TransportPersonnel) company.getTransportPersonnels().get(combo.getSelectedIndex()));
                        break;
                    case 4:
                        //admin.removeTechnician(company.getTechnicians(), (Technician) company.getTechnicians().get(combo.getSelectedIndex()));
                        break;
                    case 5:
                        new RemoveVehicleUI(combo.getSelectedIndex());
                        break;
                }
            }
        }
        private class RemoveVehicleUI extends JFrame implements ActionListener{
            private JComboBox<String> combo;
            private JButton button_back;
            private JButton button_apply;
            private int index;

            public RemoveVehicleUI(int index) {
                this.index = index;

                add(buttons());
                add(readProperties());

                setTitle("Remove Vehicle");
                setLayout(null);
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                getContentPane().setBackground(new Color(0x64777a));
                setSize(500, 300);
                setLocationRelativeTo(null);
                setResizable(false);
                setVisible(true);
            }

            private JPanel readProperties() {
                JPanel panel = new JPanel();

                panel.setLayout(null);
                panel.setBounds(0, 0, 500, 220);

                JLabel text = new JLabel();
                text.setFont(new Font(null, Font.BOLD, 15));
                text.setText("Choose");
                text.setBounds(20, 100, 150, 20);

                combo = new JComboBox<>();
                ArrayList<Vehicle> veh = company.getRentalBranches().get(index).getVehicles();
                for (int i = 0; i < veh.size(); i++) {
                    combo.addItem(veh.get(i).toString());
                }

                combo.setBounds(200, 100, 150, 20);

                panel.add(combo);
                panel.add(text);
                return panel;
            }

            private JPanel buttons() {
                JPanel panel = new JPanel();

                panel.setLayout(null);
                panel.setBounds(0, 220, 500, 80);

                button_back = new JButton("Back");
                button_apply = new JButton("Apply");

                button_back.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
                button_apply.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

                button_back.setBounds(0, 0, 250, 70);
                button_apply.setBounds(250, 0, 250, 70);

                button_back.addActionListener(this);
                button_apply.addActionListener(this);

                panel.add(button_back);
                panel.add(button_apply);
                return panel;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == button_back)
                    dispose();
                else if (source == button_apply)
                    admin.removeVehicle(company.getRentalBranches().get(index), company.getRentalBranches().get(index).getVehicles().remove(combo.getSelectedIndex()));
            }
        }
    }

    private class addEmployee extends JFrame implements ActionListener {
        private JButton button_back;
        private JButton button_apply;
        private int code;
        String name;
        String lastname;
        String email;

        public addEmployee(Admin admin, int code) {
            this.code = code;
            add(buttons());
            add(readProperties());

            setTitle("Add Employee");
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setBackground(new Color(0x64777a));
            setSize(500, 300);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        private JPanel readProperties() {
            JPanel panel = new JPanel();

            panel.setLayout(null);
            panel.setBounds(0, 0, 500, 220);

            JTextField field_name = new JTextField();
            JTextField field_lastname = new JTextField();
            JTextField field_email = new JTextField();

            JLabel text_name = new JLabel();
            JLabel text_lastname = new JLabel();
            JLabel text_email = new JLabel();

            text_name.setFont(new Font(null, Font.BOLD, 15));
            text_lastname.setFont(new Font(null, Font.BOLD, 15));
            text_email.setFont(new Font(null, Font.BOLD, 15));

            text_name.setText("Name");
            text_lastname.setText("LastName");
            text_email.setText("E-Mail");

            field_name.addActionListener(e -> name = field_name.getText());
            field_lastname.addActionListener(e -> lastname = field_lastname.getText());
            field_email.addActionListener(e -> email = field_email.getText());

            text_name.setBounds(20, 20, 150, 20);
            text_lastname.setBounds(20, 80, 150, 20);
            text_email.setBounds(20, 140, 150, 20);

            field_name.setBounds(200, 20, 150, 20);
            field_lastname.setBounds(200, 80, 150, 20);
            field_email.setBounds(200, 140, 150, 20);

            panel.add(text_name);
            panel.add(text_lastname);
            panel.add(text_email);
            panel.add(field_name);
            panel.add(field_lastname);
            panel.add(field_email);
            return panel;
        }

        private JPanel buttons() {
            JPanel panel = new JPanel();

            panel.setLayout(null);
            panel.setBounds(0, 220, 500, 80);

            button_back = new JButton("Back");
            button_apply = new JButton("Apply");

            button_back.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
            button_apply.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

            button_back.setBounds(0, 0, 250, 70);
            button_apply.setBounds(250, 0, 250, 70);

            button_back.addActionListener(this);
            button_apply.addActionListener(this);

            panel.add(button_back);
            panel.add(button_apply);
            return panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == button_back)
                dispose();
            else if (source == button_apply) {
                if (code == 0)
                    admin.addSalesManager(company.getSalesManagers(), new SalesManager(name, lastname, email, "sm", "00"));
                else if (code == 1) {
                    admin.addTransportPersonnel(company.getTransportPersonnels(), new TransportPersonnel(name, lastname, email, "tp"));
                }
                else {
                    admin.addTechnician(company.getTechnicians(), new Technician(name, lastname, email, "tech"));
                }
            }
        }
    }


    private class addVehicleUI extends JFrame implements ActionListener {
        private JButton button_back;
        private JButton button_apply;
        private String model;
        JComboBox<String> combo_branches;

        public addVehicleUI(Admin admin) {
            add(readProperties());
            add(buttons());

            setTitle("Add Vehicle");
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setBackground(new Color(0x64777a));
            setSize(500, 300);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        private JPanel readProperties() {
            JPanel panel = new JPanel();

            panel.setLayout(null);
            panel.setBounds(0, 0, 500, 220);

            JLabel text_model = new JLabel();
            JLabel text_brand = new JLabel();
            JLabel text_color = new JLabel();
            JLabel text_branch = new JLabel();

            JTextField field_model = new JTextField();
            JComboBox<String> combo_brands = new JComboBox<>();
            JComboBox<String> combo_colors = new JComboBox<>();
            combo_branches = new JComboBox<>();

            text_model.setText("Model");
            text_brand.setText("Brand");
            text_color.setText("Color");
            text_branch.setText("Branch");

            text_model.setFont(new Font(null, Font.BOLD, 15));
            text_brand.setFont(new Font(null, Font.BOLD, 15));
            text_color.setFont(new Font(null, Font.BOLD, 15));
            text_branch.setFont(new Font(null, Font.BOLD, 15));

            text_model.setBounds(20, 20, 150, 20);
            text_brand.setBounds(20, 70, 150, 20);
            text_color.setBounds(20, 120, 150, 20);
            text_branch.setBounds(20, 170, 150, 20);

            field_model.addActionListener(e -> model = field_model.getText());
            combo_brands.addActionListener(this);
            combo_colors.addActionListener(this);
            combo_branches.addActionListener(this);

            combo_brands.addItem("BMW");
            combo_brands.addItem("Toyota");
            combo_brands.addItem("Volkswagen");
            combo_brands.addItem("Dacia");
            combo_brands.addItem("Renault");
            combo_brands.addItem("Audi");
            combo_brands.addItem("Volvo");

            combo_colors.addItem("Black");
            combo_colors.addItem("White");
            combo_colors.addItem("Blue");
            combo_colors.addItem("Red");
            combo_colors.addItem("Green");

            for (int i = 0; i < company.getRentalBranches().size(); i++) {
                combo_branches.addItem(company.getRentalBranches().get(i).getBranchName());
            }

            field_model.setBounds(280, 20, 150, 20);
            combo_brands.setBounds(280, 70, 150, 20);
            combo_colors.setBounds(280, 120, 150, 20);
            combo_branches.setBounds(280, 170, 150, 20);


            panel.add(text_model);
            panel.add(text_brand);
            panel.add(text_color);
            panel.add(text_branch);
            panel.add(field_model);
            panel.add(combo_brands);
            panel.add(combo_colors);
            panel.add(combo_branches);
            return panel;
        }

        private JPanel buttons() {
            JPanel panel = new JPanel();

            panel.setLayout(null);
            panel.setBounds(0, 220, 500, 80);

            button_back = new JButton("Back");
            button_apply = new JButton("Apply");

            button_back.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
            button_apply.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

            button_back.setBounds(0, 0, 250, 70);
            button_apply.setBounds(250, 0, 250, 70);

            button_back.addActionListener(this);
            button_apply.addActionListener(this);

            panel.add(button_back);
            panel.add(button_apply);
            return panel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == button_back)
                dispose();
            else if(source == button_apply)
                admin.addVehicle(company.getRentalBranches().get(combo_branches.getSelectedIndex()), new Vehicle());
            //dispose();

        }
    }

    private class addBranchUI extends JFrame implements ActionListener {
        private boolean isRental;
        private String name;
        private JButton button_apply;
        private JButton button_back;
        private String[] adjacents;
        private ArrayList<JComboBox> branches;

        public addBranchUI(Admin admin, boolean isRental) {
            this.isRental = isRental;
            adjacents = new String[5];

            add(readProperties());
            add(buttons());

            setTitle("Add Branch");
            setLayout(null);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setBackground(new Color(0x64777a));
            setSize(500, 300);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        private JPanel readProperties() {

            JPanel panel = new JPanel();

            // JPanel properties
            panel.setLayout(null);
            panel.setBounds(0, 0, 500, 220);

            JTextField field_name = new JTextField();

            JLabel text_branchName = new JLabel();

            text_branchName.setText("Branch Name:");
            text_branchName.setFont(new Font(null, Font.BOLD, 15));
            text_branchName.setBounds(20, 20, 150, 20);

            field_name.setBounds(200, 20, 150, 20);
            field_name.addActionListener(e -> name = field_name.getText());


            panel.add(text_branchName);
            panel.add(field_name);

            if (isRental) {
                JLabel text_branchAdj0 = new JLabel();
                JLabel text_branchAdj1 = new JLabel();
                JLabel text_branchAdj2 = new JLabel();
                JLabel text_branchAdj3 = new JLabel();
                JLabel text_branchAdj4 = new JLabel();

                text_branchAdj0.setFont(new Font(null, Font.BOLD, 15));
                text_branchAdj1.setFont(new Font(null, Font.BOLD, 15));
                text_branchAdj2.setFont(new Font(null, Font.BOLD, 15));
                text_branchAdj3.setFont(new Font(null, Font.BOLD, 15));
                text_branchAdj4.setFont(new Font(null, Font.BOLD, 15));

                text_branchAdj0.setText("Adjacent Branch:");
                text_branchAdj1.setText("Adjacent Branch:");
                text_branchAdj2.setText("Adjacent Branch:");
                text_branchAdj3.setText("Adjacent Branch:");
                text_branchAdj4.setText("Adjacent Branch:");

                text_branchAdj0.setBounds(20, 50, 150, 20);
                text_branchAdj1.setBounds(20, 80, 150, 20);
                text_branchAdj2.setBounds(20, 110, 150, 20);
                text_branchAdj3.setBounds(20, 140, 150, 20);
                text_branchAdj4.setBounds(20, 170, 150, 20);


                text_branchName.setBounds(20, 20, 150, 20);

                panel.add(text_branchAdj0);
                panel.add(text_branchAdj1);
                panel.add(text_branchAdj2);
                panel.add(text_branchAdj3);
                panel.add(text_branchAdj4);

                JComboBox<String> combo = new JComboBox<>();
                JComboBox<String> combo1 = new JComboBox<>();
                JComboBox<String> combo2 = new JComboBox<>();
                JComboBox<String> combo3 = new JComboBox<>();
                JComboBox<String> combo4 = new JComboBox<>();
                combo.addItem("None");
                combo1.addItem("None");
                combo2.addItem("None");
                combo3.addItem("None");
                combo4.addItem("None");
                for (int i = 0; i < company.getRentalBranches().size(); i++) {
                    combo.addItem(company.getRentalBranches().get(i).getBranchName());
                    combo1.addItem(company.getRentalBranches().get(i).getBranchName());
                    combo2.addItem(company.getRentalBranches().get(i).getBranchName());
                    combo3.addItem(company.getRentalBranches().get(i).getBranchName());
                    combo4.addItem(company.getRentalBranches().get(i).getBranchName());
                }

                branches = new ArrayList<>();
                branches.add(combo);
                branches.add(combo1);
                branches.add(combo2);
                branches.add(combo3);
                branches.add(combo4);

                branches.get(0).setBounds(200, 50, 150, 20);
                branches.get(1).setBounds(200, 80, 150, 20);
                branches.get(2).setBounds(200, 110, 150, 20);
                branches.get(3).setBounds(200, 140, 150, 20);
                branches.get(4).setBounds(200, 170, 150, 20);

                for (int i = 0; i < 5; i++) {
                    branches.get(i).addActionListener(this);
                    panel.add(branches.get(i));
                }

            }
            return panel;
        }

        private JPanel buttons() {
            JPanel panel = new JPanel();

            panel.setLayout(null);
            panel.setBounds(0, 220, 500, 80);

            button_back = new JButton("Back");
            button_apply = new JButton("Apply");

            button_back.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
            button_apply.setFont(new Font("Press Start 2P", Font.PLAIN, 15));

            button_back.setBounds(0, 0, 250, 70);
            button_apply.setBounds(250, 0, 250, 70);

            button_back.addActionListener(this);
            button_apply.addActionListener(this);

            panel.add(button_back);
            panel.add(button_apply);
            return panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == button_back)
                dispose();
            else if (source == button_apply) {
                for (int i = 0; i < 5; i++) {
                    if (branches.get(i).getSelectedIndex() != 0)
                        adjacents[i] = company.getRentalBranches().get(branches.get(i).getSelectedIndex()-1).getBranchName();
                }
                if (isRental)
                    admin.addRentalBranch(company.getRentalBranches(), new RentalBranch(name));
                else
                    admin.addServiceBranch(company.getServiceBranch(), new ServiceBranch(name));
            }

        }
    }














    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button_back) {
            dispose();
            //new MenuUI(this.company);
        }
        else if(source == button_exit)
            System.exit(0);
        else if(source == button_add_rBranch)
            new addBranchUI(admin, true);
        else if(source == button_rem_rBranch)
            new removeUI(admin, 0);
        else if(source == button_add_sBranch)
            new addBranchUI(admin, false);
        else if(source == button_rem_sBranch)
            new removeUI(admin, 1);
        else if(source == button_add_sManager)
            new addEmployee(admin, 0);
        else if(source == button_rem_sManager)
            new removeUI(admin, 2);
        else if(source == button_add_tPerson)
            new addEmployee(admin, 1);
        else if(source == button_rem_tPerson)
            new removeUI(admin, 3);
        else if(source == button_add_tech)
            new addEmployee(admin, 2);
        else if(source == button_rem_tech)
            new removeUI(admin, 4);
        else if(source == button_add_vehicle)
            new addVehicleUI(admin);
        else if(source == button_rem_vehicle)
            new removeUI(admin, 5);
    }


}
