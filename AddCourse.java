import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddCourse extends JFrame
        implements ActionListener {

    JLabel titleLabel;

    JLabel nameLabel;
    JLabel durationLabel;
    JLabel feeLabel;

    JTextField nameField;
    JTextField durationField;
    JTextField feeField;

    JButton addButton;

    AddCourse() {

        setTitle("Add Course");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TITLE

        titleLabel =
                new JLabel("Add New Course");

        titleLabel.setBounds(
                170,
                30,
                200,
                30
        );

        // COURSE NAME

        nameLabel =
                new JLabel("Course Name:");

        nameLabel.setBounds(
                50,
                100,
                120,
                30
        );

        nameField =
                new JTextField();

        nameField.setBounds(
                180,
                100,
                200,
                30
        );

        // DURATION

        durationLabel =
                new JLabel("Duration:");

        durationLabel.setBounds(
                50,
                160,
                120,
                30
        );

        durationField =
                new JTextField();

        durationField.setBounds(
                180,
                160,
                200,
                30
        );

        // FEE

        feeLabel =
                new JLabel("Course Fee:");

        feeLabel.setBounds(
                50,
                220,
                120,
                30
        );

        feeField =
                new JTextField();

        feeField.setBounds(
                180,
                220,
                200,
                30
        );

        // BUTTON

        addButton =
                new JButton("Add Course");

        addButton.setBounds(
                150,
                290,
                180,
                40
        );

        addButton.addActionListener(this);

        // ADD COMPONENTS

        add(titleLabel);

        add(nameLabel);
        add(nameField);

        add(durationLabel);
        add(durationField);

        add(feeLabel);
        add(feeField);

        add(addButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String courseName =
                nameField.getText();

        String duration =
                durationField.getText();

        String fee =
                feeField.getText();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO course(course_name, course_duration, course_fee) VALUES (?, ?, ?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, courseName);

            pst.setString(2, duration);

            pst.setString(3, fee);

            int rows =
                    pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Course Added Successfully!"
                );
            }

            con.close();
        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        new AddCourse();
    }
}