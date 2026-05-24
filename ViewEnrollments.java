import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewEnrollments extends JFrame {

    JTable table;

    JScrollPane scrollPane;

    DefaultTableModel model;

    
    ViewEnrollments() {

        setTitle("View Enrollments");

        setSize(800, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("Enrollment ID");

        model.addColumn("Student Name");

        model.addColumn("Email");

        model.addColumn("Course Name");

        table = new JTable(model);

        scrollPane = new JScrollPane(table);

        scrollPane.setBounds(20, 20, 740, 300);

        add(scrollPane);

        loadEnrollments();

        setVisible(true);
    }

    public void loadEnrollments() {

        try {

          Connection con =
DBConnection.getConnection();
            String query =
                    "SELECT enrollments.id, students.name, students.email, course.course_name " +
                    "FROM enrollments " +
                    "INNER JOIN students ON enrollments.student_id = students.id " +
                    "INNER JOIN course ON enrollments.course_id = course.id";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String id =
                        rs.getString("id");

                String studentName =
                        rs.getString("name");

                String email =
                        rs.getString("email");

                String courseName =
                        rs.getString("course_name");

                model.addRow(new Object[] {
                        id,
                        studentName,
                        email,
                        courseName
                });
            }

            con.close();

        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());
        }
    }

    public static void main(String[] args) {

        new ViewEnrollments();
    }
}