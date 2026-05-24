import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteCourse extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel;

    JTextField idField;

    JButton deleteButton;

    
    DeleteCourse() {

        setTitle("Delete Course");

        setSize(400, 250);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Delete Course");
        titleLabel.setBounds(120, 30, 200, 30);

        idLabel = new JLabel("Course ID:");
        idLabel.setBounds(50, 90, 100, 30);

        idField = new JTextField();
        idField.setBounds(150, 90, 150, 30);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(130, 150, 120, 35);

        deleteButton.addActionListener(this);

        add(titleLabel);
        add(idLabel);
        add(idField);
        add(deleteButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = idField.getText();

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
                    "DELETE FROM course WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, Integer.parseInt(id));

            int rows = pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this,
                        "Course Deleted Successfully!");

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

        new DeleteCourse();
    }
}