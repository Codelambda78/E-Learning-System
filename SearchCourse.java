import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SearchCourse extends JFrame
        implements ActionListener {

    JLabel titleLabel;

    JLabel courseLabel;

    JTextField courseField;

    JButton searchButton;

    JTextArea resultArea;

    

    SearchCourse() {

        setTitle("Search Course");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TITLE

        titleLabel =
                new JLabel("Search Course");

        titleLabel.setBounds(
                180,
                20,
                200,
                30
        );

        // LABEL

        courseLabel =
                new JLabel("Course Name:");

        courseLabel.setBounds(
                50,
                80,
                120,
                30
        );

        // TEXTFIELD

        courseField =
                new JTextField();

        courseField.setBounds(
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

        add(courseLabel);

        add(courseField);

        add(searchButton);

        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con =
DBConnection.getConnection();
            String query =
                    "SELECT * FROM course WHERE course_name = ?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(
                    1,
                    courseField.getText()
            );

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                String id =
                        rs.getString("id");

                String courseName =
                        rs.getString("course_name");

                String duration =
                        rs.getString("course_duration");

                String fee =
                        rs.getString("course_fee");

                resultArea.setText(
                        "ID: " + id +
                        "\nCourse: " + courseName +
                        "\nDuration: " + duration +
                        "\nFee: " + fee
                );
            }

            else {

                resultArea.setText(
                        "Course Not Found!"
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

        new SearchCourse();
    }
}