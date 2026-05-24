import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener {

    JLabel titleLabel;

    JLabel nameLabel;
    JLabel emailLabel;
    JLabel courseLabel;

    JTextField nameField;
    JTextField emailField;
    JTextField courseField;

    JButton addButton;

    
    AddStudent() {

        setTitle("Add Student");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        titleLabel = new JLabel("Student Registration");
        titleLabel.setBounds(150, 30, 200, 30);

        // Name
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);

        nameField = new JTextField();
        nameField.setBounds(180, 100, 200, 30);

        // Email
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 150, 100, 30);

        emailField = new JTextField();
        emailField.setBounds(180, 150, 200, 30);

        // Course
        courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 200, 100, 30);

        courseField = new JTextField();
        courseField.setBounds(180, 200, 200, 30);

        // Button
        addButton = new JButton("Add Student");
        addButton.setBounds(150, 280, 180, 40);

        addButton.addActionListener(this);

        // Add Components
        add(titleLabel);

        add(nameLabel);
        add(nameField);

        add(emailLabel);
        add(emailField);

        add(courseLabel);
        add(courseField);

        add(addButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();

        String email = emailField.getText();

        String course = courseField.getText();

        try {

            Connection con =
            DBConnection.getConnection();
            String query =
                    "INSERT INTO students(name,email,course) VALUES(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, name);

            pst.setString(2, email);

            pst.setString(3, course);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Student Added Successfully!");

            con.close();

        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }
    }

    public static void main(String[] args) {

        new AddStudent();

    }
}