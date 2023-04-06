package airlineMapPackage;
import java.util.HashMap;
/**
 * @author Denisse_Loya
 * Person Class parent of Customer and Employee
 */
public class Person 
{
    private String id, firstName, lastName, membership, username, password, dob; // attributes extended to customer and employee
    private String moneyAvailable, flightPurchased;
    private double savings;
    private boolean isEmployee;
    private HashMap <String,Ticket> ticketList = new HashMap<>();

    public Person(){}

    public Person(String firstNameIn){}

    /**
     * @param person
     * Constructor for Person
     */
    public Person(String id, String firstName, String lastName, String dob, String moneyAvailable, String flightPurchased, 
    String membership, String username, String password, Boolean isEmployee)
    { 
        // constructor from array/file
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.moneyAvailable = moneyAvailable;
        this.flightPurchased = flightPurchased;
        this.membership = membership;
        this.username = username;
        this.password = password;
        this.isEmployee = isEmployee;
    }

    //setters
    /**
     * get First Name
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * set First Name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * set Username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get Money Available
     * @return
     */
    public String getMoneyAvailable() {
        return this.moneyAvailable;
    }

    /**
     * set Money Available
     * @param moneyAvailable
     */
    public void setMoneyAvailable(String moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    /**
     * set Flight Purchased
     * @param flightPurchased
     */
    public void setFlightPurchased(String flightPurchased) {
        this.flightPurchased = flightPurchased;
    }

    /**
     * get Ticket List Person
     * @return
     */
    public HashMap<String,Ticket> getTicketList() {
        return this.ticketList;
    }

    /**
     * Set Ticket List Person
     * @param ticketList
     */
    public void setTicketList(HashMap<String,Ticket> ticketList) {
        this.ticketList = ticketList;
    }


    /**
     * Set Flight Purchased
     * @param purchaseIn
     */
    public void setFligthPurchased(String purchaseIn)
    {
        this.flightPurchased = purchaseIn;
    }

    /**
     * get Savings Person
     * @return
     */
    public double getSavings(){
        return this.savings;
    }

    /**
     * @param savings
     * set Savings
     */
    public void setSavings(double savings){
        this.savings += savings;
    }

    /**
     * @return
     * get Flight Purchased
     */
    public String getFlightPurchased()
    {
        return this.flightPurchased;
    }

    /**
     * @param isEmployee
     * set Is employee
     */
    public void setIsEmployee(boolean isEmployee)
    {
        this.isEmployee = isEmployee;
    }

    /**
     * @return
     * get boolean is Employee
     */
    public boolean getIsEmployee()
    {
        return this.isEmployee;
    }
    
    /**
     * @param dobIn
     * set DOB
     */
    public void setDob(String dobIn)
    { 
        this.dob = dobIn;
    }

    /**
     * @param idIn
     * set ID
     */
    public void setId(String idIn)
    { 
        this.id = idIn;
    }

    /**
     * @param nameIn
     * set Name
     */
    public void setName(String nameIn)
    {
        this.firstName = nameIn;
    }

    /**
     * @param lastnameIn
     * set LastName
     */
    public void setLastName(String lastnameIn)
    {
        this.lastName = lastnameIn;
    }

    /**
     * @param memberIn
     * set Membership
     */
    public void setMembership(String memberIn)
    {
        this.membership = memberIn;
    }

    /**
     * @param userIn
     * set User
     */
    public void setUser(String userIn)
    {
        this.username = userIn;
    }

    /**
     * @param passwordIn
     * set Password
     */
    public void setPassword(String passwordIn)
    {
        this.password = passwordIn;
    }
    
    //getters
    /**
     * get DOB
     * @return
     */
    public String getDob()
    {
        return this.dob;
    }

    /**
     * @return
     * get ID
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * @return
     * get Name
     */
    public String getName()
    {
        return this.firstName;
    }

    /**
     * @return
     * get LastName
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * @return
     * get Membership
     */
    public String getMembership()
    {
        return this.membership;
    }

    /**
     * @return
     * get UserName
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * @return
     * get Password
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * when the customer buys a ticket, the ticket gets added to arra
     * @param ticket
     */
    public void setTicket(Ticket ticket)
    {
        this.ticketList.put(ticket.getConfirmation(), ticket);
        setFligthPurchased(String.valueOf(ticketList.size()));
    }
    
    
    /**
     * @param total
     * @return
     * Method to see if money is enough to buy ticket
     */
    public boolean availableMoney(double total)
    {
        // check if customer has money to buy the ticket
        if((Double.parseDouble(getMoneyAvailable())) >= total)
        {
            return true; 
        }
        return false;
    }
    
    /**
     * @param confirmation
     * Cancel ticket and return money, set ticket to 0s
     */
    public void cancelTicket(String confirmation, double totalToReturn)
    {
        if(ticketList.get(confirmation)!=null){
            setMoneyAvailable(String.valueOf((Double.parseDouble(getMoneyAvailable()) + totalToReturn)));
        }
        ticketList.get(confirmation).cancel();
    }
}
