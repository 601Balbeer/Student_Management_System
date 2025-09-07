import java.sql.Connection;
import java.sql.DriverManager;

public class Student_M {
    public static void main(String[] args) {
        try {
            Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "Balbeer@1333");
            System.out.println(obj);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
