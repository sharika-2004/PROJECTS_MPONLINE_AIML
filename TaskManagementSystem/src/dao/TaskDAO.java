package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Task;

public class TaskDAO {

    // Add Task
    public boolean addTask(Task task) {

        String sql = "INSERT INTO tasks(employee_name, task_description, completed) VALUES(?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("Connection Failed!");
                return false;
            }

            System.out.println("----------------------------");
            System.out.println("URL : " + con.getMetaData().getURL());
            System.out.println("Database : " + con.getCatalog());

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, task.getEmployeeName());
            ps.setString(2, task.getTaskDescription());
            ps.setString(3, task.getCompleted());

            System.out.println("Employee Name : " + task.getEmployeeName());
            System.out.println("Task Description : " + task.getTaskDescription());
            System.out.println("Completed : " + task.getCompleted());

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted = " + rows);

            ResultSet rs = con.createStatement().executeQuery("SELECT COUNT(*) FROM tasks");

            if (rs.next()) {
                System.out.println("Rows in table after insert = " + rs.getInt(1));
            }

            rs.close();
            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Login Check
    public boolean login(String username, String password) {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            boolean status = rs.next();

            rs.close();
            ps.close();
            con.close();

            return status;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}