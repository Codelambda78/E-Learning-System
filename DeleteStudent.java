import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteStudent extends JFrame implements ActionListener {

    JLabel titleLabel;

    JLabel idLabel;

    JTextField idField;

    JButton deleteButton;

    

    DeleteStudent() {

        setTitle("Delete Student");

        setSize(400, 250);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Delete Student");
        titleLabel.setBounds(130, 30, 200, 30);

        idLabel = new JLabel("Student ID:");
        idLabel.setBounds(50, 90, 100, 30);

        idField = new JTextField();
        idField.setBounds(150, 90, 150, 30);

        deleteButton = new JButton("Delete Student");
        deleteButton.setBounds(110, 150, 150, 40);

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
                    "DELETE FROM students WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(this,
                        "Student Deleted Successfully!");

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

        new DeleteStudent();

    }
}