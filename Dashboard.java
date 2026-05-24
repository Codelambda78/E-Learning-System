import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JLabel welcomeLabel;

    JButton viewCoursesButton;

    JButton enrollButton;

    JButton myEnrollmentsButton;

    JButton logoutButton;

    public Dashboard(String name) {

        setTitle("Dashboard");

        setSize(500, 450);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Welcome Label
        welcomeLabel =
                new JLabel("Welcome " + name);

        welcomeLabel.setBounds(
                100,
                40,
                300,
                40
        );

        welcomeLabel.setFont(
                new Font("Arial",
                        Font.BOLD,
                        28)
        );

        add(welcomeLabel);

        // View Courses Button
        viewCoursesButton =
                new JButton("View Courses");

        viewCoursesButton.setBounds(
                150,
                120,
                180,
                40
        );

        add(viewCoursesButton);

        // Enroll Button
        enrollButton =
                new JButton("Enroll Course");

        enrollButton.setBounds(
                150,
                180,
                180,
                40
        );

        add(enrollButton);

        // My Enrollments Button
        myEnrollmentsButton =
                new JButton("My Enrollments");

        myEnrollmentsButton.setBounds(
                150,
                240,
                180,
                40
        );

        add(myEnrollmentsButton);

        // Logout Button
        logoutButton =
                new JButton("Logout");

        logoutButton.setBounds(
                150,
                300,
                180,
                40
        );

        add(logoutButton);

        // Action Listeners
        viewCoursesButton.addActionListener(this);

        enrollButton.addActionListener(this);

        myEnrollmentsButton.addActionListener(this);

        logoutButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // View Courses
        if (e.getSource() == viewCoursesButton) {

            new ViewCourses();

        }

        // Enroll Course
        else if (e.getSource() == enrollButton) {

            new EnrollStudent();

        }

        // My Enrollments
        else if (e.getSource() == myEnrollmentsButton) {

            new ViewEnrollments();

        }

        // Logout
        if (e.getSource() == logoutButton) {

    JOptionPane.showMessageDialog(this,
            "Logged Out Successfully!");

    dispose();

    new Login();

}
    }

    public static void main(String[] args) {

        new Dashboard("Student");

    }
}