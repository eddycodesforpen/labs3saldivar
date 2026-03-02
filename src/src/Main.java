/** Project: Lab3 - Main Application for Database Operations
 * Purpose Details: Demonstrates CRUD operations on both MySQL and MongoDB
 * Course: IST 411
 * Author: Saldivar
 * Date Developed: 2/27/26
 * Last Date Changed: 3/1/26
 */

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 * Main driver class for the Customer database application.
 * Runs the program and demonstrates CRUD operations.
 *
 * Edward saldivar
 * @version 1.0
 */
public class Main { /**
 * Entry point of the program.
 *
 * @param args Command-line arguments
 */
    public static void main(String[] args) {

        System.out.println("=== LAB 3: DATABASE OPERATIONS DEMONSTRATION ===\n");

        /**
         * Creates customers with their specific attributes
         */
        Customer customer1 = new Customer(1, "Brady", "Swencak", 20, "bms7008@psu.edu",
                "10 PSU Rd.", 20, "YES", "male");
        Customer customer2 = new Customer(2, "John", "Doe", 33, "johndoe@psu.edu",
                "28 Penn State Drive", 0, "NO", "male");
        Customer customer3 = new Customer(3, "Jane", "Does", 28, "janedoes@psu.edu",
                "68 Road Rd.", 3284, "YES", "female");

        /**
         * Creates objects to communicate with other classes
         * allowing for connection to the database in Main.java
         */
        CustomerMONGOCRUD mongoStore = new CustomerMONGOCRUD();
        CustomerMySQLCRUD mySQLStore = new CustomerMySQLCRUD();

        try {
            // === CREATE OPERATIONS ===
            System.out.println("\n--- CREATE OPERATIONS ---");

            // Insert into MongoDB
            System.out.println("\nInserting into MongoDB:");
            mongoStore.insertCustomer(customer1);
            mongoStore.insertCustomer(customer2);
            mongoStore.insertCustomer(customer3);

            // Insert into MySQL
            System.out.println("\nInserting into MySQL:");
            mySQLStore.insertCustomer(customer1);
            mySQLStore.insertCustomer(customer2);
            mySQLStore.insertCustomer(customer3);

            System.out.println("\nPress Enter to continue to READ operations...");
            new Scanner(System.in).nextLine();

            // === READ OPERATIONS ===
            System.out.println("\n--- READ OPERATIONS ---");

            // Read from MongoDB
            System.out.println("\nReading from MongoDB:");
            List<Customer> mongoCustomers = mongoStore.readAllCustomers();
            for (Customer c : mongoCustomers) {
                System.out.println(c);
            }

            // Read from MySQL
            System.out.println("\nReading from MySQL:");
            List<Customer> mysqlCustomers = mySQLStore.readAllCustomers();
            for (Customer c : mysqlCustomers) {
                System.out.println(c);
            }

            System.out.println("\nPress Enter to continue to UPDATE operations...");
            new Scanner(System.in).nextLine();

            // === UPDATE OPERATIONS ===
            System.out.println("\n--- UPDATE OPERATIONS ---");

            // Update customer1
            customer1.setLoyaltyPoints(100);
            customer1.setNewsletterSubscribed("NO");

            System.out.println("\nUpdating customer 1 in MongoDB:");
            mongoStore.updateCustomer(customer1);

            System.out.println("\nUpdating customer 1 in MySQL:");
            mySQLStore.updateCustomer(customer1);

            System.out.println("\nPress Enter to continue to READ after UPDATE...");
            new Scanner(System.in).nextLine();

            // Verify updates
            System.out.println("\n--- VERIFY UPDATES ---");

            System.out.println("\nMongoDB after update:");
            mongoCustomers = mongoStore.readAllCustomers();
            for (Customer c : mongoCustomers) {
                System.out.println(c);
            }

            System.out.println("\nMySQL after update:");
            mysqlCustomers = mySQLStore.readAllCustomers();
            for (Customer c : mysqlCustomers) {
                System.out.println(c);
            }

            System.out.println("\nPress Enter to continue to DELETE operations...");
            new Scanner(System.in).nextLine();

            // === DELETE OPERATIONS ===
            System.out.println("\n--- DELETE OPERATIONS ---");

            // Delete customer3
            System.out.println("\nDeleting customer 3 from MongoDB:");
            mongoStore.deleteCustomer(3);

            System.out.println("\nDeleting customer 3 from MySQL:");
            mySQLStore.deleteCustomer(3);

            System.out.println("\nPress Enter to continue to FINAL READ...");
            new Scanner(System.in).nextLine();

            // Final read to show deletions
            System.out.println("\n--- FINAL DATABASE STATE AFTER DELETIONS ---");

            System.out.println("\nMongoDB final state:");
            mongoCustomers = mongoStore.readAllCustomers();
            for (Customer c : mongoCustomers) {
                System.out.println(c);
            }

            System.out.println("\nMySQL final state:");
            mysqlCustomers = mySQLStore.readAllCustomers();
            for (Customer c : mysqlCustomers) {
                System.out.println(c);
            }

            System.out.println("\n=== LAB 3 DEMONSTRATION COMPLETE ===");

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close MongoDB connection
            mongoStore.close();
        }
    }
}