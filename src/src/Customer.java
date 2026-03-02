/** Project: Lab3 - Customer Database Operations
 * Purpose Details: Defines Customer entity for retail shopping store
 * Course: IST 242
 * Author: Edward Saldivar
 * Date Developed: 2/27/26
 * Last Date Changed: 3/1/26
 */

public class Customer {
    /**
     * The unique identifier for the customer.
     */
    private int customerId;

    /**
     * The first name of the customer.
     */
    private String firstName;

    /**
     * The last name of the customer.
     */
    private String lastName;

    /**
     * The age of the customer.
     */
    private int age;

    /**
     * The email address of the customer.
     */
    private String email;

    /**
     * The street address of the customer.
     */
    private String address;

    /**
     * The loyalty points accumulated by the customer.
     */
    private int loyaltyPoints;

    /**
     * Indicates whether the customer is subscribed to the newsletter.
     */
    private String newsletterSubscribed;

    /**
     * The gender of the customer.
     */
    private String gender;

    /**
     * Default constructor for Customer class.
     */
    public Customer() {
    }

    /**
     * Parameterized constructor for Customer class.
     *
     * @param customerId The unique identifier for the customer.
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param age The age of the customer.
     * @param email The email address of the customer.
     * @param address The street address of the customer.
     * @param loyaltyPoints The loyalty points accumulated by the customer.
     * @param newsletterSubscribed Newsletter subscription status.
     * @param gender The gender of the customer.
     */
    public Customer(int customerId, String firstName, String lastName, int age,
                    String email, String address, int loyaltyPoints,
                    String newsletterSubscribed, String gender) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address = address;
        this.loyaltyPoints = loyaltyPoints;
        this.newsletterSubscribed = newsletterSubscribed;
        this.gender = gender;
    }

    /**
     * Gets the customer ID.
     *
     * @return The customer ID.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the age.
     *
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age The age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the email.
     *
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the address.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the loyalty points.
     *
     * @return The loyalty points.
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the loyalty points.
     *
     * @param loyaltyPoints The loyalty points to set.
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    /**
     * Gets the newsletter subscription status.
     *
     * @return The newsletter subscription status.
     */
    public String getNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    /**
     * Sets the newsletter subscription status.
     *
     * @param newsletterSubscribed The newsletter status to set.
     */
    public void setNewsletterSubscribed(String newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    /**
     * Gets the gender.
     *
     * @return The gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender The gender to set.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns a string representation of the Customer object.
     *
     * @return String representation of the customer.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", newsletterSubscribed='" + newsletterSubscribed + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

