import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel emailLabel;
    JLabel passwordLabel;

    JTextField emailField;

    JPasswordField passwordField;

    JButton loginButton;

    String url = "jdbc:mysql://localhost:3306/elearningsystem";
    String user = "root";
    String dbPassword = "1a,2b,3c,A7893";

    Login() {

    setTitle("Java E-Learning System");

    setSize(400, 300);

    setLocationRelativeTo(null);

    setLayout(null);

    getContentPane().setBackground(
            new Color(245, 247, 250)
    );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Student Login");

titleLabel.setFont(
        new Font("Arial",
                Font.BOLD,
                26)
);

titleLabel.setBounds(140, 30, 200, 30);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 90, 100, 30);

        emailField = new JTextField();
        emailField.setBounds(150, 90, 180, 30);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 140, 100, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 140, 180, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(140, 200, 120, 35);

        loginButton.addActionListener(this);

        add(titleLabel);

        add(emailLabel);
        add(emailField);

        add(passwordLabel);
        add(passwordField);

        add(loginButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String email = emailField.getText();

        String password =
                String.valueOf(passwordField.getPassword());

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            user,
                            dbPassword
                    );

            String query =
                    "SELECT * FROM student WHERE email=? AND password=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, email);

            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful!");

                dispose();

                     new Dashboard(email);
            }

            else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Email or Password!");

            }

            con.close();

        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }
    }

    public static void main(String[] args) {
        

        
        new Login();
    }
}