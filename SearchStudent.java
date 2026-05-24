import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SearchStudent extends JFrame
        implements ActionListener {

    JLabel titleLabel;

    JLabel nameLabel;

    JTextField nameField;

    JButton searchButton;

    JTextArea resultArea;

    

    SearchStudent() {

        setTitle("Search Student");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TITLE

        titleLabel =
                new JLabel("Search Student");

        titleLabel.setBounds(
                180,
                20,
                200,
                30
        );

        // NAME LABEL

        nameLabel =
                new JLabel("Student Name:");

        nameLabel.setBounds(
                50,
                80,
                120,
                30
        );

        // TEXT FIELD

        nameField =
                new JTextField();

        nameField.setBounds(
                170,
                80,
                200,
                30
        );

        // BUTTON

        searchButton =
                new JButton("Search");

        searchButton.setBounds(
                170,
                130,
                120,
                35
        );

        searchButton.addActionListener(this);

        // RESULT AREA

        resultArea =
                new JTextArea();

        resultArea.setBounds(
                50,
                190,
                380,
                120
        );

        add(titleLabel);

        add(nameLabel);

        add(nameField);

        add(searchButton);

        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con =
DBConnection.getConnection();
            String query =
                    "SELECT * FROM students WHERE name = ?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(
                    1,
                    nameField.getText()
            );

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                String id =
                        rs.getString("id");

                String name =
                        rs.getString("name");

                String email =
                        rs.getString("email");

                String course =
                        rs.getString("course");

                resultArea.setText(
                        "ID: " + id +
                        "\nName: " + name +
                        "\nEmail: " + email +
                        "\nCourse: " + course
                );
            }

            else {

                resultArea.setText(
                        "Student Not Found!"
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

        new SearchStudent();
    }
}