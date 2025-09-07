import java.sql.*;
import java.util.Scanner;

public class Student_Management_System {

    static final String URL  = "jdbc:mysql://localhost:3306/StudentDB";
    static final String USER = "root";
    static final String PASS = "Balbeer@1333";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: updateStudent(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // Add student
    static void addStudent() {
        System.out.print("Enter USN: "); String usn = sc.nextLine();
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Branch: "); String branch = sc.nextLine();
        System.out.print("Enter Semester: "); int sem = sc.nextInt(); sc.nextLine();

        String sql = "INSERT INTO Students VALUES (?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, usn);
            pst.setString(2, name);
            pst.setString(3, branch);
            pst.setInt(4, sem);
            pst.executeUpdate();
            System.out.println("Student added!");
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    // View all
    static void viewStudents() {
        String sql = "SELECT * FROM Students";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("usn") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("branch") + " | " +
                        rs.getInt("semester"));
            }
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    // Search
    static void searchStudent() {
        System.out.print("Enter USN to search: "); String usn = sc.nextLine();
        String sql = "SELECT * FROM Students WHERE usn=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, usn);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Found: " + rs.getString("name") + ", " +
                        rs.getString("branch") + ", Sem " +
                        rs.getInt("semester"));
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    // Delete
    static void deleteStudent() {
        System.out.print("Enter USN to delete: "); String usn = sc.nextLine();
        String sql = "DELETE FROM Students WHERE usn=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, usn);
            int rows = pst.executeUpdate();
<<<<<<< HEAD
            System.out.println(rows > 0 ? "Deleted!" : "Student not found!");
=======
            System.out.println(rows > 0 ? " Deleted!" : "Student not found!");
>>>>>>> 868ebeb13b166362da0b73efc9007555d530e793
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    // Update
    static void updateStudent() {
        System.out.print("Enter USN to update: "); String usn = sc.nextLine();
        System.out.print("Enter New Name: "); String name = sc.nextLine();
        System.out.print("Enter New Branch: "); String branch = sc.nextLine();
        System.out.print("Enter New Semester: "); int sem = sc.nextInt(); sc.nextLine();

        String sql = "UPDATE Students SET name=?, branch=?, semester=? WHERE usn=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, branch);
            pst.setInt(3, sem);
            pst.setString(4, usn);
            int rows = pst.executeUpdate();
            System.out.println(rows > 0 ? " Updated!" : "Student not found!");
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }
}
