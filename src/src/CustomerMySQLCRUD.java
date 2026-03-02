/** Project: Lab3 - MySQL CRUD Operations
 * Purpose Details: Handles MySQL database operations for Customer objects
 * Course: IST 411
 * Author: EdwardSaldivar
 * Date Developed: 2/27/26
 * Last Date Changed: 3/1/26
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Handles CRUD (Create, Read, Update, Delete) operations
 * for Customer objects using a MySQL database.
 *
 * edward saldivar
 * @version 1.0
 */
public class CustomerMySQLCRUD {
    /**
     * Database connection URL for MySQL.
     */
    /**
     * Default constructor for CustomerMySQLCRUD.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/retail_store";

    /**
     * Database username.
     */
    private static final String USERNAME = "root";

    /**
     * Database password.
     */
    private static final String PASSWORD = "IST888IST888"; // Change this to your MySQL password

    /**
     * Establishes a connection to the MySQL database.
     *
     * @return Connection object for database operations.
     * @throws SQLException If a database access error occurs.
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * Inserts a new customer into the MySQL database.
     *
     * @param customer The Customer object to be inserted.
     * @throws SQLException If a database access error occurs.
     */
    public void insertCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO Customer (customerId, firstName, lastName, age, email, " +
                "address, loyaltyPoints, newsletterSubscribed, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, customer.getCustomerId());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setInt(4, customer.getAge());
            pstmt.setString(5, customer.getEmail());
            pstmt.setString(6, customer.getAddress());
            pstmt.setInt(7, customer.getLoyaltyPoints());
            pstmt.setString(8, customer.getNewsletterSubscribed());
            pstmt.setString(9, customer.getGender());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("MySQL: Inserted customer " + customer.getCustomerId() +
                    " - Rows affected: " + rowsAffected);
        }
    }

    /**
     * Reads all customers from the MySQL database.
     *
     * @return List of all Customer objects from the database.
     * @throws SQLException If a database access error occurs.
     */
    /**
     * Default constructor for CustomerMONGOCRUD.
     */
    public List<Customer> readAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customer";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getInt("loyaltyPoints"),
                        rs.getString("newsletterSubscribed"),
                        rs.getString("gender")
                );
                customers.add(customer);
            }
        }

        System.out.println("MySQL: Retrieved " + customers.size() + " customers");
        return customers;
    }

    /**
     * Updates an existing customer in the MySQL database.
     *
     * @param customer The Customer object with updated information.
     * @throws SQLException If a database access error occurs.
     */
    public void updateCustomer(Customer customer) throws SQLException {
        String query = "UPDATE Customer SET firstName=?, lastName=?, age=?, email=?, " +
                "address=?, loyaltyPoints=?, newsletterSubscribed=?, gender=? " +
                "WHERE customerId=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setInt(3, customer.getAge());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getAddress());
            pstmt.setInt(6, customer.getLoyaltyPoints());
            pstmt.setString(7, customer.getNewsletterSubscribed());
            pstmt.setString(8, customer.getGender());
            pstmt.setInt(9, customer.getCustomerId());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("MySQL: Updated customer " + customer.getCustomerId() +
                    " - Rows affected: " + rowsAffected);
        }
    }

    /**
     * Deletes a customer from the MySQL database.
     *
     * @param customerId The ID of the customer to be deleted.
     * @throws SQLException If a database access error occurs.
     */
    public void deleteCustomer(int customerId) throws SQLException {
        String query = "DELETE FROM Customer WHERE customerId=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, customerId);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("MySQL: Deleted customer " + customerId +
                    " - Rows affected: " + rowsAffected);
        }
    }
}
