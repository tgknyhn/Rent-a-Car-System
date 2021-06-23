import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginUI extends JFrame implements ActionListener {
    private final String user;
    private JButton button_exit;
    private JButton button_next;

    private final Company company;

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


        // Listeners

        field_ID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char letter = e.getKeyChar();

                field_ID.setEditable(letter >= '0' && letter <= '9');
            }
        });

        field_branchID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char letter = e.getKeyChar();

                field_branchID.setEditable(letter >= '0' && letter <= '9');
            }
        });


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
        else if(e.getSource() == button_next)
            System.out.println("selam");
    }
}
