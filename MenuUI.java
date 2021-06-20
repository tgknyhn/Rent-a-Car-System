import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame implements ActionListener {
    private JComboBox<String> comboBox_names;
    private JButton button_exit;
    private JButton button_next;
    private String  currentUser = "Admin";

    public MenuUI() {
        // Adding components to the JFrame
        add(getGreeting());
        add(getUsers());
        add(getButtons());

        // JFrame properties
        setTitle("Menu");
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
        text_RentACar.setText("Rent A Car");
        text_RentACar.setBounds(70,80, 750, 100);


        // Adding components to the JPanel
        panel.add(text_RentACar);

        // Returning JPanel
        return panel;
    }

    private JPanel getUsers() {
        String[] userNames = {"Admin", "Employee", "Customer"};

        // Initialize JPanel
        JPanel panel = new JPanel();

        // JPanel properties
        panel.setLayout(null);
        panel.setBounds(0, 200, 750, 100);

        // Initializing components
        comboBox_names    = new JComboBox<>(userNames);
        JLabel text_combo = new JLabel();


        // Component properties
        comboBox_names.addActionListener(this);
        comboBox_names.setBounds(310, 49, 120, 20);

        text_combo.setBounds(190,8, 300, 100);
        text_combo.setFont(new Font(null, Font.BOLD, 15));
        text_combo.setText("Select an User: ");


        // Adding components to the JPanel
        panel.add(comboBox_names);
        panel.add(text_combo);

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
        if(e.getSource() == comboBox_names)
            currentUser = (String) comboBox_names.getSelectedItem();
        else if(e.getSource() == button_exit)
            System.exit(0);
        else if(e.getSource() == button_next) {
            if(currentUser.equals("Admin"))
            dispose();
            new LoginUI(currentUser);
        }
    }
}
