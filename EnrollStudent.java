import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class EnrollStudent extends JFrame implements ActionListener {

    JLabel titleLabel;

    JLabel studentIdLabel;
    JLabel courseIdLabel;

    JTextField studentIdField;
    JTextField courseIdField;

    JButton enrollButton;

    

    EnrollStudent() {

        setTitle("Enroll Student");

        setSize(500, 350);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        titleLabel =
                new JLabel("Student Enrollment");

        titleLabel.setBounds(160, 30, 200, 30);

        // Student ID
        studentIdLabel =
                new JLabel("Student ID:");

        studentIdLabel.setBounds(50, 100, 100, 30);

        studentIdField = new JTextField();

        studentIdField.setBounds(180, 100, 200, 30);

        // Course ID
        courseIdLabel =
                new JLabel("Course ID:");

        courseIdLabel.setBounds(50, 170, 100, 30);

        courseIdField = new JTextField();

        courseIdField.setBounds(180, 170, 200, 30);

        // Button
        enrollButton =
                new JButton("Enroll");

        enrollButton.setBounds(150, 240, 180, 40);

        enrollButton.addActionListener(this);

        // Add Components
        add(titleLabel);

        add(studentIdLabel);
        add(studentIdField);

        add(courseIdLabel);
        add(courseIdField);

        add(enrollButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String studentId =
                studentIdField.getText();

        String courseId =
                courseIdField.getText();

        try {

            Connection con =
             DBConnection.getConnection();

            String query =
                    "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, studentId);

            pst.setString(2, courseId);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this,
                        "Enrollment Successful!");

            }

            con.close();

        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }
    }

    public static void main(String[] args) {

        new EnrollStudent();

    }
}