package vut;

import java.sql.*;
import java.util.ArrayList;

public abstract class StudentDA {

    private static ArrayList<StudentPD> arListStudent = new ArrayList<>();

    private static Connection con;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    public static void initializeConnection() {
        final String USERNAME = "root";
        final String PASSWORD = "";
        final String URL = "jdbc:mysql://localhost/StudentManagementSystem";
        final String DRIVER = "com.mysql.cj.jdbc.Driver";


        try {
            Class.forName(DRIVER);

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("DataBase driver not found\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Message: " + e.getSQLState());
        }

    }

    public static void addStudent(StudentPD studentObj) {
        String qry = "INSERT INTO Student VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(qry);
            ps.setString(1, studentObj.getStudentNumber());
            ps.setString(3, studentObj.getInitials());
            ps.setString(2, studentObj.getSurname());

            ps.execute();
        } catch (SQLException e) {
            System.out.println(studentObj.getSurname() + " Not Added\n" + e.getMessage());
        }
    }

    public static ArrayList<StudentPD> getAll() {
        arListStudent.clear();
        String query = "SELECT * FROM Student";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                arListStudent.add(new StudentPD(rs.getString(3), rs.getString(2), rs.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println("No Data retrived.\n" + e.getMessage());
        }

        return arListStudent;
    }

    public static void removeStudent(String studentNumber) {
        String qry = "DELETE FROM Student WHERE Student_Number = ?";
        try {
            ps = con.prepareStatement(qry);
            ps.setString(1, studentNumber);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
