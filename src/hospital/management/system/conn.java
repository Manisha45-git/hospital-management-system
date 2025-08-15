package hospital.management.system;

import java.sql.*;

public class conn {

    Connection connection;
    Statement statement;


    public conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database (Change DB name, user, and password)
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_management_system", // DB URL
                    "root",                                   // Username
                    "root"                                // Password
            );

            // Create statement object
            statement = connection.createStatement();

            System.out.println("✅ Database Connected Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Database Connection Failed!");
        }
    }
}






