import javax.swing.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame
        implements ActionListener {

    JLabel titleLabel;

    // COURSE BUTTONS
    JButton addCourseButton;
    JButton viewCourseButton;
    JButton updateCourseButton;
    JButton deleteCourseButton;
    JButton searchCourseButton;

    // STUDENT BUTTONS
    JButton addStudentButton;
    JButton viewStudentsButton;
    JButton updateStudentButton;
    JButton deleteStudentButton;
    JButton searchStudentButton;

    // ENROLLMENT BUTTONS
    JButton enrollStudentButton;
    JButton viewEnrollmentsButton;

    // LOGOUT
    JButton logoutButton;

    AdminDashboard() {

        setTitle("Admin Dashboard");

        setSize(500, 950);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TITLE

        titleLabel =
                new JLabel(
                        "E-Learning Admin Dashboard"
                );

        titleLabel.setBounds(
                130,
                30,
                300,
                30
        );

        // =========================
        // COURSE MODULE
        // =========================

        addCourseButton =
                new JButton("Add Course");

        addCourseButton.setBounds(
                150,
                90,
                180,
                40
        );

        viewCourseButton =
                new JButton("View Courses");

        viewCourseButton.setBounds(
                150,
                150,
                180,
                40
        );

        updateCourseButton =
                new JButton("Update Course");

        updateCourseButton.setBounds(
                150,
                210,
                180,
                40
        );

        deleteCourseButton =
                new JButton("Delete Course");

        deleteCourseButton.setBounds(
                150,
                270,
                180,
                40
        );

        searchCourseButton =
                new JButton("Search Course");

        searchCourseButton.setBounds(
                150,
                330,
                180,
                40
        );

        // =========================
        // STUDENT MODULE
        // =========================

        addStudentButton =
                new JButton("Add Student");

        addStudentButton.setBounds(
                150,
                420,
                180,
                40
        );

        viewStudentsButton =
                new JButton("View Students");

        viewStudentsButton.setBounds(
                150,
                480,
                180,
                40
        );

        updateStudentButton =
                new JButton("Update Student");

        updateStudentButton.setBounds(
                150,
                540,
                180,
                40
        );

        deleteStudentButton =
                new JButton("Delete Student");

        deleteStudentButton.setBounds(
                150,
                600,
                180,
                40
        );

        searchStudentButton =
                new JButton("Search Student");

        searchStudentButton.setBounds(
                150,
                660,
                180,
                40
        );

        // =========================
        // ENROLLMENT MODULE
        // =========================

        enrollStudentButton =
                new JButton("Enroll Student");

        enrollStudentButton.setBounds(
                150,
                750,
                180,
                40
        );

        viewEnrollmentsButton =
                new JButton("View Enrollments");

        viewEnrollmentsButton.setBounds(
                150,
                810,
                180,
                40
        );

        // =========================
        // LOGOUT
        // =========================

        logoutButton =
                new JButton("Logout");

        logoutButton.setBounds(
                150,
                870,
                180,
                40
        );

        // =========================
        // ACTION LISTENERS
        // =========================

        addCourseButton.addActionListener(this);

        viewCourseButton.addActionListener(this);

        updateCourseButton.addActionListener(this);

        deleteCourseButton.addActionListener(this);

        searchCourseButton.addActionListener(this);

        addStudentButton.addActionListener(this);

        viewStudentsButton.addActionListener(this);

        updateStudentButton.addActionListener(this);

        deleteStudentButton.addActionListener(this);

        searchStudentButton.addActionListener(this);

        enrollStudentButton.addActionListener(this);

        viewEnrollmentsButton.addActionListener(this);

        logoutButton.addActionListener(this);

        // =========================
        // ADD COMPONENTS
        // =========================

        add(titleLabel);

        add(addCourseButton);

        add(viewCourseButton);

        add(updateCourseButton);

        add(deleteCourseButton);

        add(searchCourseButton);

        add(addStudentButton);

        add(viewStudentsButton);

        add(updateStudentButton);

        add(deleteStudentButton);

        add(searchStudentButton);

        add(enrollStudentButton);

        add(viewEnrollmentsButton);

        add(logoutButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // =========================
        // COURSE
        // =========================

        if (e.getSource() ==
                addCourseButton) {

            new AddCourse();
        }

        else if (e.getSource() ==
                viewCourseButton) {

            new ViewCourses();
        }

        else if (e.getSource() ==
                updateCourseButton) {

            new UpdateCourse();
        }

        else if (e.getSource() ==
                deleteCourseButton) {

            new DeleteCourse();
        }

        else if (e.getSource() ==
                searchCourseButton) {

            new SearchCourse();
        }

        // =========================
        // STUDENTS
        // =========================

        else if (e.getSource() ==
                addStudentButton) {

            new AddStudent();
        }

        else if (e.getSource() ==
                viewStudentsButton) {

            new ViewStudents();
        }

        else if (e.getSource() ==
                updateStudentButton) {

            new UpdateStudent();
        }

        else if (e.getSource() ==
                deleteStudentButton) {

            new DeleteStudent();
        }

        else if (e.getSource() ==
                searchStudentButton) {

            new SearchStudent();
        }

        // =========================
        // ENROLLMENTS
        // =========================

        else if (e.getSource() ==
                enrollStudentButton) {

            new EnrollStudent();
        }

        else if (e.getSource() ==
                viewEnrollmentsButton) {

            new ViewEnrollments();
        }

        // =========================
        // LOGOUT
        // =========================

        else if (e.getSource() ==
                logoutButton) {

            JOptionPane.showMessageDialog(
                    this,
                    "Logged Out Successfully!"
            );

            dispose();

            new Login();
        }
    }

    public static void main(String[] args) {

        new AdminDashboard();
    }
}