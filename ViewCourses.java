import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;

public class ViewCourses extends JFrame {

    JTable table;

    JScrollPane scrollPane;

    DefaultTableModel model;

    public ViewCourses() {

        setTitle("View Courses");

        setSize(700, 400);

        setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table Columns
        String[] columns = {
            "ID",
            "Course Name",
            "Duration",
            "Course Fee"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadCourses();

        setVisible(true);
    }

    public void loadCourses() {

        
        try {

            Connection con =
DBConnection.getConnection();

            String query =
                "SELECT * FROM course";

            Statement st =
                con.createStatement();

            ResultSet rs =
                st.executeQuery(query);

            while(rs.next()) {

                int id =
                    rs.getInt("id");

                String name =
                    rs.getString("course_name");

                String duration =
                    rs.getString("course_duration");

                String fee =
                    rs.getString("course_fee");

                Object[] row = {
                    id,
                    name,
                    duration,
                    fee
                };

                model.addRow(row);
            }

            con.close();

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new ViewCourses();
    }
}