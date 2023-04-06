package airlineMapPackage;
/**
 * @author Denisse_Loya
 * Customer class child of Person
 */
public class Customer extends Person 
{
    // the customer will have a list of the purchased tickets
    public Customer() {}

    /**
     * @param nameIn
     * create customer and set employee to false and super Person
     */
    public Customer(String id, String firstName, String lastName, String dob, String moneyAvailable, String flightPurchased, 
    String membership, String username, String password, boolean isEmployee)
    {
        super(id, firstName, lastName, dob, moneyAvailable, flightPurchased, membership, username, password, isEmployee);
        // extending person constructor
    }

}