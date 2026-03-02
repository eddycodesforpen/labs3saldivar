/** Project: Lab3 - MongoDB CRUD Operations
 * Purpose Details: Handles MongoDB database operations for Customer objects
 * Course: IST 242
 * Author: Edward Saldivar
 * Date Developed: 2/27/26
 * Last Date Changed: 3/1/26
 */

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
/**
 * Handles CRUD operations for Customer objects
 * using a MongoDB database.
 *
 * Edward saldivar
 * @version 1.0
 */

public class CustomerMONGOCRUD {
    /**
     * MongoDB connection URI.
     */
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    /**
     * Database name in MongoDB.
     */
    private static final String DATABASE_NAME = "retail_store";

    /**
     * Collection name for customers.
     */
    private static final String COLLECTION_NAME = "customers";

    /**
     * MongoClient instance for database connection.
     */
    private MongoClient mongoClient;

    /**
     * MongoDatabase instance for database operations.
     */
    private MongoDatabase database;

    /**
     * MongoCollection instance for customer operations.
     */
    private MongoCollection<Document> collection;

    /**
     * Default constructor that initializes MongoDB connection.
     */
    public CustomerMONGOCRUD() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            collection = database.getCollection(COLLECTION_NAME);
            System.out.println("MongoDB: Connected successfully");
        } catch (Exception e) {
            System.err.println("MongoDB: Connection failed - " + e.getMessage());
        }
    }

    /**
     * Converts a Customer object to a MongoDB Document.
     *
     * @param customer The Customer object to convert.
     * @return MongoDB Document representation of the customer.
     */
    private Document customerToDocument(Customer customer) {
        return new Document("customerId", customer.getCustomerId())
                .append("firstName", customer.getFirstName())
                .append("lastName", customer.getLastName())
                .append("age", customer.getAge())
                .append("email", customer.getEmail())
                .append("address", customer.getAddress())
                .append("loyaltyPoints", customer.getLoyaltyPoints())
                .append("newsletterSubscribed", customer.getNewsletterSubscribed())
                .append("gender", customer.getGender());
    }

    /**
     * Converts a MongoDB Document to a Customer object.
     *
     * @param doc The MongoDB Document to convert.
     * @return Customer object representation of the document.
     */
    private Customer documentToCustomer(Document doc) {
        return new Customer(
                doc.getInteger("customerId"),
                doc.getString("firstName"),
                doc.getString("lastName"),
                doc.getInteger("age"),
                doc.getString("email"),
                doc.getString("address"),
                doc.getInteger("loyaltyPoints"),
                doc.getString("newsletterSubscribed"),
                doc.getString("gender")
        );
    }

    /**
     * Inserts a new customer into MongoDB.
     *
     * @param customer The Customer object to be inserted.
     */
    public void insertCustomer(Customer customer) {
        try {
            Document doc = customerToDocument(customer);
            collection.insertOne(doc);
            System.out.println("MongoDB: Inserted customer " + customer.getCustomerId());
        } catch (Exception e) {
            System.err.println("MongoDB: Insert failed - " + e.getMessage());
        }
    }

    /**
     * Reads all customers from MongoDB.
     *
     * @return List of all Customer objects from the database.
     */
    public List<Customer> readAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                customers.add(documentToCustomer(doc));
            }
            System.out.println("MongoDB: Retrieved " + customers.size() + " customers");
        } catch (Exception e) {
            System.err.println("MongoDB: Read failed - " + e.getMessage());
        }
        return customers;
    }

    /**
     * Updates an existing customer in MongoDB.
     *
     * @param customer The Customer object with updated information.
     */
    public void updateCustomer(Customer customer) {
        try {
            collection.updateOne(
                    Filters.eq("customerId", customer.getCustomerId()),
                    Updates.combine(
                            Updates.set("firstName", customer.getFirstName()),
                            Updates.set("lastName", customer.getLastName()),
                            Updates.set("age", customer.getAge()),
                            Updates.set("email", customer.getEmail()),
                            Updates.set("address", customer.getAddress()),
                            Updates.set("loyaltyPoints", customer.getLoyaltyPoints()),
                            Updates.set("newsletterSubscribed", customer.getNewsletterSubscribed()),
                            Updates.set("gender", customer.getGender())
                    )
            );
            System.out.println("MongoDB: Updated customer " + customer.getCustomerId());
        } catch (Exception e) {
            System.err.println("MongoDB: Update failed - " + e.getMessage());
        }
    }

    /**
     * Deletes a customer from MongoDB.
     *
     * @param customerId The ID of the customer to be deleted.
     */
    public void deleteCustomer(int customerId) {
        try {
            collection.deleteOne(Filters.eq("customerId", customerId));
            System.out.println("MongoDB: Deleted customer " + customerId);
        } catch (Exception e) {
            System.err.println("MongoDB: Delete failed - " + e.getMessage());
        }
    }

    /**
     * Closes the MongoDB connection.
     */
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB: Connection closed");
        }
    }
}
