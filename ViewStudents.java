import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewStudents extends JFrame {

    JTable table;

    DefaultTableModel model;

    
    ViewStudents() {

        setTitle("View Students");

        setSize(700, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table Columns
        String[] columns = {

                "ID",
                "Name",
                "Email",
                "Course"

        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);

        pane.setBounds(20, 20, 640, 300);

        add(pane);

        loadStudents();

        setVisible(true);
    }

    public void loadStudents() {

        try {

            Connection con =
DBConnection.getConnection();
            String query = "SELECT * FROM students";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");

                String name = rs.getString("name");

                String email = rs.getString("email");

                String course = rs.getString("course");

                Object[] row = {

                        id,
                        name,
                        email,
                        course

                };

                model.addRow(row);

            }

            con.close();

        }

        catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }
    }

    public static void main(String[] args) {

        new ViewStudents();

    }
}