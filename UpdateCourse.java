import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCourse extends JFrame implements ActionListener {

    JLabel titleLabel;

    JLabel idLabel;
    JLabel nameLabel;
    JLabel durationLabel;
    JLabel feeLabel;

    JTextField idField;
    JTextField nameField;
    JTextField durationField;
    JTextField feeField;

    JButton updateButton;

    
    UpdateCourse() {

        setTitle("Update Course");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Update Course");
        titleLabel.setBounds(180, 30, 200, 30);

        idLabel = new JLabel("Course ID:");
        idLabel.setBounds(50, 90, 100, 30);

        idField = new JTextField();
        idField.setBounds(180, 90, 200, 30);

        nameLabel = new JLabel("Course Name:");
        nameLabel.setBounds(50, 140, 100, 30);

        nameField = new JTextField();
        nameField.setBounds(180, 140, 200, 30);

        durationLabel = new JLabel("Duration:");
        durationLabel.setBounds(50, 190, 100, 30);

        durationField = new JTextField();
        durationField.setBounds(180, 190, 200, 30);

        feeLabel = new JLabel("Course Fee:");
        feeLabel.setBounds(50, 240, 100, 30);

        feeField = new JTextField();
        feeField.setBounds(180, 240, 200, 30);

        updateButton = new JButton("Update Course");
        updateButton.setBounds(150, 300, 180, 40);

        updateButton.addActionListener(this);

        add(titleLabel);

        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(durationLabel);
        add(durationField);

        add(feeLabel);
        add(feeField);

        add(updateButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = idField.getText();

        String name = nameField.getText();

        String duration = durationField.getText();

        String fee = feeField.getText();

        try {

            Connection con =
DBConnection.getConnection();
            String query =
                    "UPDATE course SET course_name=?, course_duration=?, course_fee=? WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, name);

            pst.setString(2, duration);

            pst.setString(3, fee);

            pst.setString(4, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this,
                        "Course Updated Successfully!");

            } else {

                JOptionPane.showMessageDialog(this,
                        "Course ID Not Found!");

            }

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }
    }

    public static void main(String[] args) {

        new UpdateCourse();

    }
}