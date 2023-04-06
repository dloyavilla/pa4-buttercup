package airlineMapPackage;
/**
 * @author Denisse_Loya
 * Employee class child of Person
 */
public class Employee extends Person 
{
    /**
     * Cpnstructor to give access to employees
     */
    public Employee() 
    {
        setIsEmployee(true);
    }

    /**
     * Constructor
     * @param id
     * @param firstName
     * @param lastName
     * @param dob
     * @param moneyAvailable
     * @param flightPurchased
     * @param membership
     * @param username
     * @param password
     * @param isEmployee
     */
    public Employee(String id, String firstName, String lastName, String dob, String moneyAvailable, String flightPurchased, 
    String membership, String username, String password, boolean isEmployee)
    {
        super(id, firstName, lastName, dob, moneyAvailable, flightPurchased, membership, username, password, isEmployee);
        setIsEmployee(true);
    }
}