//Sheri Evangelene
// June JUl 23- Aug 3 2026
//Java QAP 4

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PatientDBManager {
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/patientsdb";
    private static final String user = "postgres";
    private static final String password = "software2026";

    public static Connection getcon()
    {
        Connection connection = null;

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        return connection;
    }


    
}


