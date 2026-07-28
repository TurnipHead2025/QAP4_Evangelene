//Sheri Evangelene
// June JUl 23- Aug 3 2026
//Java QAP 4

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDBManager {
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/patientsdb";
    private static final String user = "postgres";
    private static final String password = "software2026";

    public static Connection getcon() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void savePatient(Patient patient) {
        String sql = "INSERT INTO patients (patient_fname, patient_lname, patient_dob) VALUES (?, ?, ?)";

        try (Connection conn = getcon();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, patient.getPatientFName());
            stmt.setString(2, patient.getPatientLName());
            
            if (patient.getPatientDOB() != null) {
                stmt.setDate(3, new java.sql.Date(patient.getPatientDOB().getTime()));
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }

            stmt.executeUpdate();
            System.out.println("Patient saved to database successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving patient: " + e.getMessage());
        }
    }

    public static void readPatients() {
        String sql = "SELECT * FROM patients";
        try (Connection conn = getcon();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Patients in Database ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("patient_id") +
                    ", Name: " + rs.getString("patient_fname") + " " + rs.getString("patient_lname") +
                    ", DOB: " + rs.getDate("patient_dob"));
            }
        } catch (SQLException e) {
            System.out.println("Error reading patients: " + e.getMessage());
        }
    }
}