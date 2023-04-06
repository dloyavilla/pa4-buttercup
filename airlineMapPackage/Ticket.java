package airlineMapPackage;
/**
 * @author Denisse_Loya
 * Ticket to provide after transaction
 */
public class Ticket {

    // attributes of ticket
    private String type, quantity, totalPrice, confirmation;
    private double subtotal, minerAirlinesFee, securityFee, taxesCharged, savings;
    private Person customer;
    private Flight flight;

    public Ticket() {}

    /**
     * @param type
     * @param quantity
     * @param totalPrice
     * @param confirmation
     * @param customer
     * Constructor
     */
    public Ticket(String type, String quantity, String totalPrice, String confirmation, Person customer, Flight flight) 
    {
        this.type = type;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.confirmation = confirmation;
        this.customer = customer;
        this.flight = flight;
    }


    public Ticket(String type, String quantity, String totalPrice, String confirmation, double subtotal, double minerAirlinesFee, double securityFee, double taxesCharged, double savings, Person customer, Flight flight) {
        this.type = type;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.confirmation = confirmation;
        this.subtotal = subtotal;
        this.minerAirlinesFee = minerAirlinesFee;
        this.securityFee = securityFee;
        this.taxesCharged = taxesCharged;
        this.savings = savings;
        this.customer = customer;
        this.flight = flight;
    }
    /**
     * Set Ticket Type of ticket (first, business, main)
     * @param type
     */
    public void setType(String type)
    {
        this.type = type;

    }


    /**
     * get Subtotal from ticket
     * @return
     */
    public double getSubtotal() {
        return this.subtotal;
    }

    /**
     * set Subtotal ticket
     * @param subtotal
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * get MinerAirlinesFee Ticket
     * @return
     */
    public double getMinerAirlinesFee() {
        return this.minerAirlinesFee;
    }

    /**
     * set MinerAirlines Fee Ticket
     * @param minerAirlinesFee
     */
    public void setMinerAirlinesFee(double minerAirlinesFee) {
        this.minerAirlinesFee = minerAirlinesFee;
    }

    /**
     * get Security Fee Ticket
     * @return
     */
    public double getSecurityFee() {
        return this.securityFee;
    }

    /**
     * set Security fee ticket
     * @param securityFee
     */
    public void setSecurityFee(double securityFee) {
        this.securityFee = securityFee;
    }

    /**
     * get Taxes charged ticket
     * @return
     */
    public double getTaxesCharged() {
        return this.taxesCharged;
    }

    /**
     * set Taxes Charged Ticket
     * @param taxesCharged
     */
    public void setTaxesCharged(double taxesCharged) {
        this.taxesCharged = taxesCharged;
    }

    /**
     * get Savings Ticket
     * @return
     */
    public double getSavings() {
        return this.savings;
    }

    /**
     * set Savings Ticket
     * @param savings
     */
    public void setSavings(double savings) {
        this.savings = savings;
    }

   /**
    * get Custoemer Ticket
     * @return
     */
     public Person getCustomer() {
        return this.customer;
    }

   /**
    * set Customer Ticket
     * @param customer
     */
     public void setCustomer(Person customer) {
        this.customer = customer;
    }

    /**
     * get Type Ticket
     * @return
     */
    public String getType() 
    {
        return this.type;
    }

    // number of tickets
    /**
     * get uantity of tickets
     * @return
     */
    public String getQuantity() 
    {
        return this.quantity;
    }

   /**
    * set Quantity of Tickets
     * @param quantity
     */
     public void setQuantity(String quantity) 
    {
        this.quantity = quantity;
    }

    /**
     * get price the customer paid
     * @return
     */
    public String getTotalPrice() 
    {
        return this.totalPrice;
    }

    /**
     * set price the customer paid
     * @param totalPrice
     */
    public void setTotalPrice(String totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    
    /**
     * get confirmation number
     * @return
     */
    public String getConfirmation()
    {
        return this.confirmation;
    }

    /**
     * set confirmation number
     * @param confirmation
     */
    public void setConfirmation(String confirmation) 
    {
        this.confirmation = confirmation;
    }

  
    /**
     * Cancel ticket, set to 0s
     */
    public void cancel() 
    {
        this.type = "TICKET CANCELLED";
        this.quantity = "0";
        this.totalPrice = "0";
        this.confirmation = "0";
        this.customer.setSavings(-savings);

    }

    /**
     * toString method ticket
     */
    @Override
    public String toString() 
    { 
        return "---  TICKET ' \t" +
                " Name='" + this.customer.getName() + " " + this.customer.getLastName() +
                "\t Type='" + getType() + "'" +
                "\t Number of seats='" + getQuantity() + "'" +
                "\t Total Price ='" + getTotalPrice() + "'" + "\t Confirmation='" + getConfirmation() + "  ---'\n";
    }
}