import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {

    JLabel titleLabel;

    JLabel idLabel;
    JLabel nameLabel;
    JLabel emailLabel;
    JLabel courseLabel;

    JTextField idField;
    JTextField nameField;
    JTextField emailField;
    JTextField courseField;

    JButton updateButton;

    
    UpdateStudent() {

        setTitle("Update Student");

        setSize(500, 420);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        titleLabel = new JLabel("Update Student");
        titleLabel.setBounds(170, 30, 200, 30);

        // Student ID
        idLabel = new JLabel("Student ID:");
        idLabel.setBounds(50, 90, 100, 30);

        idField = new JTextField();
        idField.setBounds(180, 90, 200, 30);

        // Name
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 140, 100, 30);

        nameField = new JTextField();
        nameField.setBounds(180, 140, 200, 30);

        // Email
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 190, 100, 30);

        emailField = new JTextField();
        emailField.setBounds(180, 190, 200, 30);

        // Course
        courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 240, 100, 30);

        courseField = new JTextField();
        courseField.setBounds(180, 240, 200, 30);

        // Button
        updateButton = new JButton("Update Student");
        updateButton.setBounds(150, 320, 180, 40);

        updateButton.addActionListener(this);

        // Add Components
        add(titleLabel);

        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(emailLabel);
        add(emailField);

        add(courseLabel);
        add(courseField);

        add(updateButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = idField.getText();

        String name = nameField.getText();

        String email = emailField.getText();

        String course = courseField.getText();

        try {

            Connection con =
DBConnection.getConnection();
            String query =
                    "UPDATE students SET name=?, email=?, course=? WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, name);

            pst.setString(2, email);

            pst.setString(3, course);

            pst.setString(4, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this,
                        "Student Updated Successfully!");

            }

            else {

                JOptionPane.showMessageDialog(this,
                        "Student ID Not Found!");

            }

            con.close();

        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }
    }

    public static void main(String[] args) {

        new UpdateStudent();

    }
}