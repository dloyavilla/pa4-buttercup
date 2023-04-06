package airlineMapPackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * @author Denisse_Loya
 * Class to Perform Transaction
 */
public class Transaction
{
    private double taxesCollected, savings;
    private double totalSecurityFee, taxCharged;
    private double minerAirlinesFee = 9.15;
    private airlineMap airline = airlineMap.getInstance();
    private int id;

    public Transaction() {
    }
    

    /**
     * @param id
     * Constructor
     */
    public Transaction(String id) {
        this.id = Integer.parseInt(id);
    }

    /**
     * get MinerAirlines Fee to apply  Transaction
     * @return
     */
    public double getMinerAirlinesFee() {
        return this.minerAirlinesFee;
    }

    /**
     * set MinerAirlines Fee in Transaction
     * @param minerAirlinesFee
     */
    public void setMinerAirlinesFee(double minerAirlinesFee) {
        this.minerAirlinesFee = minerAirlinesFee;
    }

    /**
     * get Tax Charged in Transaction
     * @return
     */
    public double getTaxCharged() {
        return this.taxCharged;
    }

    /**
     * get AirlineMap
     * @return
     */
    public airlineMap getAirline() {
        return this.airline;
    }

    /**
     * set AirlineMap
     * @param airline
     */
    public void setAirline(airlineMap airline) {
        this.airline = airline;
    }

    /**
     * set Taxes Charged in Transaction
     * @param taxCharged
     */
    public void setTaxCharged(double taxCharged) {
        this.taxCharged = taxCharged;
    }
    
    /**
     * @param type
     * @param quantity
     * @param customer
     * @return
     * create a ticket per flight, and add it to the map of tickets
     */
    public String createTicket(int type, int quantity, Person customer, String id)
    {
        Scanner sc = new Scanner(System.in);
        double totalPrice = checkSeats(type, quantity, false);
        String typeSeat = returnType(type);
        double totalPriceWithFees = getTotalWithFees(typeSeat, quantity, customer, totalPrice, 9.15, 5.60);
        totalPriceWithFees = getTotalWithTaxes(totalPriceWithFees);
        String text = ""; 
        // check if customer has enough money, seats are available, and if flight is not canceled
        if((makePurchase(customer, totalPriceWithFees, false)) && airline.getMapFlights().get(Integer.parseInt(id)).getIsValidFlight())
        { 
            String price = Double.toString(totalPriceWithFees);
            // confirm or cancel transaction
            System.out.println("--------------------\nSUBTOTAL PRICE: $"+ totalPrice + "\nMINER AIRLINESS FEE: $"+this.minerAirlinesFee+"\nTOTAL SECURITY FEE: $"+this.totalSecurityFee+"\nDESTINATION AIRPORT FEE: $"+airline.getMapFlights().get(Integer.parseInt(id)).getDestinationAirportFee()+"\nORIGIN AIRPORT FEE: $"+ airline.getMapFlights().get(Integer.parseInt(id)).getOriginAirportFee()+"\nTAXES: $"+this.taxCharged+"\nDISCOUNT: -$"+this.savings+"\nTOTAL PRICE: $"+totalPriceWithFees+"\n\nConfirm your purchase Yes/No");
            String confirmPurchase = sc.nextLine();
            // confirm 
            if(confirmPurchase.equalsIgnoreCase("yes"))
            {
                String numSeats = Integer.toString(quantity);
                String confirmation = getConfirmation();
                Flight flight = airline.getMapFlights().get(Integer.parseInt(id));
                // the confirmation will be the index of the ticket in the map, so the user can later look up for their ticket inside the array
                // create ticket
                Ticket ticket = new Ticket(typeSeat, numSeats, price, confirmation, totalPrice, this.minerAirlinesFee, this.totalSecurityFee, this.taxCharged, this.savings, customer, flight);
                // set ticket in customer
                customer.setTicket(ticket); 
                customer.setSavings(this.savings);
                airline.getMapFlights().get(Integer.parseInt(id)).getTicketList().put(ticket.getConfirmation(), ticket);
                System.out.println("THANK YOU, for purchasing a ticket to "+ (airline.getMapFlights().get(Integer.parseInt(id)).getDestAirport()));
                System.out.println(ticket.toString());
                // print ticket for user to see
                text = ticket.toString();
            // transaction canceled
            } 
            else 
            {
                System.out.println("Transaction cancelled...");
                returnSeats(returnType(type), String.valueOf(quantity));
                updateAmount(typeSeat, -totalPriceWithFees);
                return "";
            }
        // flight canceled
        }
        else if(!airline.getMapFlights().get(Integer.parseInt(id)).getIsValidFlight())
        {
            System.out.println("Flight has been canceled..");
            returnSeats(returnType(type), String.valueOf(quantity));
        }
        return text; // return purchased ticket to write changes in file
    }

    public String createTicketAutomatic(int type, int quantity, Person customer, String id)
    {
        this.id = Integer.parseInt(id);
        double totalPrice = checkSeats(type, quantity, true);
        String typeSeat = returnType(type);
        double totalPriceWithFees = getTotalWithFees(typeSeat, quantity, customer, totalPrice, 9.15, 5.60);
        totalPriceWithFees = getTotalWithTaxes(totalPriceWithFees);
        String text = ""; 
        // check if customer has enough money, seats are available, and if flight is not canceled
        if((makePurchase(customer, totalPriceWithFees, true)) && airline.getMapFlights().get(Integer.parseInt(id)).getIsValidFlight())
        { 
            String price = Double.toString(totalPriceWithFees);
            // confirm 
            String numSeats = Integer.toString(quantity);
            String confirmation = getConfirmation();
            // the confirmation will be the index of the ticket in the map, so the user can later look up for their ticket inside the array
            // create ticket
            Ticket ticket = new Ticket(typeSeat, numSeats, price, confirmation, totalPrice, this.minerAirlinesFee, this.totalSecurityFee, this.taxCharged, this.savings, customer, airline.getMapFlights().get(Integer.parseInt(id)));
            // set ticket in customer
            customer.setTicket(ticket); 
            customer.setSavings(this.savings);
            airline.getMapFlights().get(Integer.parseInt(id)).getTicketList().put(ticket.getConfirmation(), ticket);
                // print ticket for user to see
            text = ticket.toString();
            // transaction canceled
        } 
        else 
        {
            returnSeats(returnType(type), String.valueOf(quantity));
            updateAmount(typeSeat, -totalPriceWithFees);
            return "";
        }

        return text; // return purchased ticket to write changes in file
    }

    /**
     * create Confirmation Number
     * @return
     */
    public String getConfirmation(){
        List<Integer> numbers = new ArrayList<>();
        for(int i=1000; i<=9999; i++){
            numbers.add(i);
        }
        Random rand = new Random();
        int num = numbers.get(numbers.indexOf(rand.nextInt(1000,9999)));
        numbers.remove(numbers.indexOf(num));
        String confirmation = String.valueOf(num) + "ID"+this.id + "MINER";
        return confirmation;
    }

    /**
     * @param type
     * @param totalPrice
     * update amount collected per class type
     */
    public void updateAmount(String type, double totalPrice)
    {
        type = type.toLowerCase();
        totalPrice += airline.getMapFlights().get(this.id).getTotalCollected().get(type) + totalPrice;
        double minerairlinesFeeCollected = airline.getMapFlights().get(this.id).getTotalCollected().get("minerAirlines fee") + this.minerAirlinesFee;
        double securityFeeCollected = airline.getMapFlights().get(this.id).getTotalCollected().get("security fee") + this.totalSecurityFee;
        airline.getMapFlights().get(this.id).getTotalCollected().put(type, totalPrice);
        airline.getMapFlights().get(this.id).getTotalCollected().put("minerAirlines fee", minerairlinesFeeCollected);
        airline.getMapFlights().get(this.id).getTotalCollected().put("security fee", securityFeeCollected);
        airline.getMapFlights().get(this.id).updateTotalProfit();
        double destFee = Double.parseDouble(airline.getMapFlights().get(this.id).getDestination().getFee());
        double originFee = Double.parseDouble(airline.getMapFlights().get(this.id).getOrigin().getFee());
        airline.getMapFlights().get(this.id).getOrigin().setTotalFees(originFee);
        airline.getMapFlights().get(this.id).getDestination().setTotalFees(destFee);
    }

    /**
     * @param type
     * @param quantity
     * @return
     * check seats and substract quantity of seats
     */
    public double checkSeats(int type, int quantity, boolean isAutopurchase)
    {
        double totalPrice = 0;
        // first class
        if(type==1)
        { 
            // compute total Price
            totalPrice = quantity * (Double.parseDouble(airline.getMapFlights().get(this.id).getFirstPrice())) + (Double.parseDouble(airline.getMapFlights().get(this.id).getSurcharge()));
            // send to savailable seats
            if(availableSeats(quantity, Integer.parseInt(airline.getMapFlights().get(this.id).getFirstSeats())))
            {
                airline.getMapFlights().get(this.id).setFirstSeats(String.valueOf(updateSeats(quantity, Integer.parseInt(airline.getMapFlights().get(this.id).getFirstSeats()))));
            }
            else if(!isAutopurchase)
            {
                System.out.println("SOLD OUT");
            }
        // bussines class
        }else if(type==2)
        {
            totalPrice = quantity * (Double.parseDouble(airline.getMapFlights().get(this.id).getBusinessPrice())) + (Double.parseDouble(airline.getMapFlights().get(this.id).getSurcharge()));
            if(availableSeats(quantity, Integer.parseInt(airline.getMapFlights().get(this.id).getBusinessSeats())))
            {
                airline.getMapFlights().get(this.id).setBusinessSeats(String.valueOf(updateSeats(quantity, Integer.parseInt(airline.getMapFlights().get(this.id).getBusinessSeats()))));
            }
            else if(!isAutopurchase)            
            {
                System.out.println("SOLD OUT");
            }
        // main cabin class
        }
        else
        { 
            totalPrice = quantity * (Double.parseDouble(airline.getMapFlights().get(this.id).getMainPrice())) + (Double.parseDouble(airline.getMapFlights().get(this.id).getSurcharge()));
            if(availableSeats(quantity, Integer.parseInt(airline.getMapFlights().get(this.id).getMainSeats())))
            {
                airline.getMapFlights().get(this.id).setMainSeats(String.valueOf(updateSeats(quantity, Integer.parseInt(airline.getMapFlights().get(this.id).getMainSeats()))));
            }
            else if(!isAutopurchase)
            {
                System.out.println("SOLD OUT");
            }
        }
        double totalP = (double)totalPrice;
        String typeFlight = returnType(type);
        // send total to pay to update Amount
        updateAmount(typeFlight, totalP);
        // total price to pay
        return totalPrice; 
    }

    /**
     * @param type
     * @return
     * return type of class
     */
    public String returnType(int type)
    { 
        String typeSeat = "";
        if(type==1){
            typeSeat = "First";
        } 
        else if(type==2){
            typeSeat = "Business";
        }
        else{
            typeSeat = "Main Cabin";    
        }
        return typeSeat;
    }

    /**
     * @param customer
     * @param totalPrice
     * @return
     * remove total to pay from the money of the user
     */
    public boolean makePurchase(Person customer, double totalPrice, boolean isAutopurchase)
    { 
        // check if customer has enough money
        if(customer.availableMoney(totalPrice)==true)
        { 
            // make transaction
            double transaction = (Double.parseDouble(customer.getMoneyAvailable())) - totalPrice;
            //set new money 
            customer.setMoneyAvailable(Double.toString(transaction));
            return true;
        }
        else if(!isAutopurchase)
        {
            System.out.println("You don't have founds to make this purchase"); 
            return false; 
        }
        return false;
    }

    /**
     * @param quantity
     * @param classSeats
     * @return
     * check if class has enough seats
     */
    public boolean availableSeats(int quantity, int classSeats)
    { 
        if(classSeats>=quantity)
        {
            return true;
        }
        return false;
    }

    /**
     * @param quantity
     * @param classSeats
     * @return
     * update seats from class and total
     */
    public int updateSeats(int quantity, int classSeats)
    { 
        int newSeats = 0;
        // substract quantity to seats available 
        newSeats = classSeats - quantity;  
        // set total seats
        airline.getMapFlights().get(this.id).setTotalSeats(String.valueOf((Integer.parseInt(airline.getMapFlights().get(this.id).getTotalSeats()))-quantity));
        return newSeats; 
    }

    /**
     * @param confirmation
     * cancel Ticket from flight and customer
     */
    public void cancelTicket(String confirmation)
    {
        // check if confirmation number exists
        if(airline.getMapFlights().get(this.id).getTicketList().get(confirmation) != null &&(airline.getMapFlights().get(this.id).getIsValidFlight()==false))
        {
            // get type, quantity, and price
            String type = airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getType();
            String quantity = airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getQuantity();
            double totalPrice = Double.parseDouble(airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getTotalPrice());
            Person customer = airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getCustomer();
            // return seats and money collected
            returnSeats(type, quantity);
            returnTaxes(type, -totalPrice);
            returnFees();
            // cancel ticketo to set all to 0s
            customer.cancelTicket(confirmation, totalPrice);
            airline.getMapFlights().get(this.id).getTicketList().get(confirmation).cancel();
            airline.getMapFlights().get(this.id).getTicketList().get(confirmation).setType("FLIGHT CANCELLED");
        }
        else if(airline.getMapFlights().get(this.id).getTicketList().get(confirmation) != null &&(airline.getMapFlights().get(this.id).getIsValidFlight()==true))
        {
             // get type, quantity, and price
             String type = airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getType();
             String quantity = airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getQuantity();
             double totalPrice = airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getSubtotal() + airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getTaxesCharged();
             Person customer = airline.getMapFlights().get(this.id).getTicketList().get(confirmation).getCustomer();

             // return seats and money collected
             returnSeats(type, quantity);
             returnTaxes(type, -totalPrice);
             customer.cancelTicket(confirmation, totalPrice);
             // cancel ticketo to set all to 0s
             airline.getMapFlights().get(this.id).getTicketList().get(confirmation).cancel();
        }
        else
        {
           return;
        }
    }

    /**
     * @param type
     * @param quantity
     * return seats when ticket is canceled
     */
    public void returnSeats(String type, String quantity)
    {   // check type of the class
        if(type.equalsIgnoreCase("First"))
        {
            airline.getMapFlights().get(this.id).setFirstSeats(String.valueOf(Integer.parseInt(airline.getMapFlights().get(this.id).getFirstSeats())+ Integer.parseInt(quantity))); 
            airline.getMapFlights().get(this.id).setTotalSeats(String.valueOf(Integer.parseInt(airline.getMapFlights().get(this.id).getTotalSeats())+ Integer.parseInt(quantity))); 
        }
        else if(type.equalsIgnoreCase("Business"))
        {
            airline.getMapFlights().get(this.id).setBusinessSeats(String.valueOf(Integer.parseInt(airline.getMapFlights().get(this.id).getBusinessSeats())+ Integer.parseInt(quantity))); 
            airline.getMapFlights().get(this.id).setTotalSeats(String.valueOf(Integer.parseInt(airline.getMapFlights().get(this.id).getTotalSeats())+ Integer.parseInt(quantity))); 
        }
        else
        {
            airline.getMapFlights().get(this.id).setMainSeats(String.valueOf(Integer.parseInt(airline.getMapFlights().get(this.id).getMainSeats())+ Integer.parseInt(quantity)));
            airline.getMapFlights().get(this.id).setTotalSeats(String.valueOf(Integer.parseInt(airline.getMapFlights().get(this.id).getTotalSeats())+ Integer.parseInt(quantity))); 
        }
    }

    /**
     * cancel all tickets in a flight
     */
    public void cancelFlight(String id)
    {
        this.id = Integer.parseInt(id);
        airline.getMapFlights().get(this.id).setIsValidFlight(false);
        for(String key : airline.getMapFlights().get(this.id).getTicketList().keySet())
        {
            cancelTicket(key);
        }
    }

    /**
     * Get Total to pay after Fees
     * @param type
     * @param quantity
     * @param customer
     * @param totalPrice
     * @param minerAirlinesFee
     * @param securityFee
     * @return
     */
    public double getTotalWithFees(String type, int quantity, Person customer, double totalPrice, double minerAirlinesFee, double securityFee) 
    {
        if(customer.getMembership().equalsIgnoreCase("TRUE"))
        {
            this.savings = totalPrice * .05;
            totalPrice = totalPrice - savings;
        }
        if(customer.getIsEmployee() == true && type.equalsIgnoreCase("First")) 
        {
            this.savings = totalPrice * .5;
            totalPrice = totalPrice - savings;  
        }
        else if (customer.getIsEmployee() == true)
        {
            this.savings = totalPrice * .75;
            totalPrice = totalPrice - savings;  
        } 

        this.totalSecurityFee = quantity * securityFee;
        totalPrice +=  minerAirlinesFee + this.totalSecurityFee;
        return totalPrice;
    }

    /**
     * get Total to Pay after Taxes
     * @param totalPrice
     * @return
     */
    public double getTotalWithTaxes(double totalPrice)
    {
        this.taxCharged =  totalPrice *.0825;
        this.taxesCollected += this.taxCharged;
        totalPrice *= 1.0825;
        return totalPrice;
    }

    /**
     * get Taxes Collected
     * @return
     */
    public double getTaxesCollected() 
    {
        return this.taxesCollected;
    }

   /**
    * set Taxes Collected
     * @param taxesCollected
     */
     public void setTaxesCollected(double taxesCollected) 
    {
        this.taxesCollected += taxesCollected;
    }

    /**
     * get Total Security for all seats
     * @return
     */
    public double getTotalSecurityFee() 
    {
        return this.totalSecurityFee;
    }

    /**
     * set Total Security fee
     * @param totalSecurityFee
     */
    public void setTotalSecurityFee(double totalSecurityFee) 
    {
        this.totalSecurityFee = totalSecurityFee;
    }

    /**
     * Print fees and taxes in transaction
     */
    public void printFeesAndTaxes()
    {
        System.out.println("MinerAirlines Fee: $"+ this.minerAirlinesFee + "\nSecurity Fee per Seat: $5.60\nTaxes: 8.25%");
    }

    /**
     * return taxes if ticket is cancelled
     * @param type
     * @param totalPrice
     */
    public void returnTaxes(String type, double totalPrice)
    {
        type = type.toLowerCase();
        totalPrice += airline.getMapFlights().get(this.id).getTotalCollected().get(type) + totalPrice;
        airline.getMapFlights().get(this.id).getTotalCollected().put(type, totalPrice);
        airline.getMapFlights().get(this.id).updateTotalProfit();
        this.taxesCollected -= this.taxCharged;
    }

    /**
     * return fees if flight is cancelled
     */
    public void returnFees()
    {
        double minerairlinesFeeCollected = airline.getMapFlights().get(this.id).getTotalCollected().get("minerAirlines fee") - this.minerAirlinesFee;
        double securityFeeCollected = airline.getMapFlights().get(this.id).getTotalCollected().get("security fee") - this.totalSecurityFee;
        airline.getMapFlights().get(this.id).getTotalCollected().put("minerAirlines fee", minerairlinesFeeCollected);
        airline.getMapFlights().get(this.id).getTotalCollected().put("security fee", securityFeeCollected);
        double destFee = Double.parseDouble(airline.getMapFlights().get(this.id).getDestinationAirportFee());
        double originFee = Double.parseDouble(airline.getMapFlights().get(this.id).getOriginAirportFee());
        airline.getMapFlights().get(this.id).getOrigin().setTotalFees(-originFee);
        airline.getMapFlights().get(this.id).getDestination().setTotalFees(-destFee);
    }
}