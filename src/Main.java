import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main extends JFrame implements ActionListener {

    JLabel titleLabel, nameLabel, emailLabel, passwordLabel;

    JTextField nameField, emailField;

    JPasswordField passwordField;

    JButton registerButton;

    public Main() {

        setTitle("Student Registration Form");

        setSize(400, 300);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        titleLabel = new JLabel("Student Registration");

        titleLabel.setBounds(100, 20, 200, 30);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        add(titleLabel);

        // Name
        nameLabel = new JLabel("Name:");

        nameLabel.setBounds(50, 80, 100, 30);

        add(nameLabel);

        nameField = new JTextField();

        nameField.setBounds(150, 80, 150, 30);

        add(nameField);

        // Email
        emailLabel = new JLabel("Email:");

        emailLabel.setBounds(50, 120, 100, 30);

        add(emailLabel);

        emailField = new JTextField();

        emailField.setBounds(150, 120, 150, 30);

        add(emailField);

        // Password
        passwordLabel = new JLabel("Password:");

        passwordLabel.setBounds(50, 160, 100, 30);

        add(passwordLabel);

        passwordField = new JPasswordField();

        passwordField.setBounds(150, 160, 150, 30);

        add(passwordField);

        // Button
        registerButton = new JButton("Register");

        registerButton.setBounds(130, 210, 120, 35);

        registerButton.addActionListener(this);

        add(registerButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();

        String email = emailField.getText();

        String password = new String(passwordField.getPassword());

        String url = "jdbc:mysql://localhost:3306/elearningsystem";

        String user = "root";

        String dbPassword = "1a,2b,3c,A7893";

        try {

            Connection con =
                DriverManager.getConnection(url, user, dbPassword);

            String query =
                "INSERT INTO student(name,email,password) VALUES(?,?,?)";

            PreparedStatement pst =
                con.prepareStatement(query);

            pst.setString(1, name);

            pst.setString(2, email);

            pst.setString(3, password);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                "Student Registered Successfully!");

            nameField.setText("");

            emailField.setText("");

            passwordField.setText("");

            con.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Main();
    }
}