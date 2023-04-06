// Denisse Loya Villalobos, 80717246
// 01/29/2023 CS 3331 CRN 21219 Dr. Mejia
// CASS EXTENDED DEADLINE
// Programming Assignment 3 
// An airline company, MinerAir hires you organize the flights between an origin and destination
// using a class Flight, create methods to manipulate and return the attributes, use the proper data structure 
// and make a user friendly menu to search each flight by ID.
// Academic Honesty Certification:
// “I certify that this project is entirely my own work. I wrote, debugged, and tested the code being presented, performed the experiments, 
// and wrote the report. I also certify that I did not share my code or report or provided inappropriate assistance to any student in the class.”
// Signature: Denisse Loya Villalobos
package airlineMapPackage;
import java.util.Scanner;

/**
 * @author Denisse_Loya
 * Main Method 
 */

public class RunFlight
{
    /**
     * @param args argument taken into the main
     * This is the main method for the execution of the PA 2
     */
    public static void main(String args[])
    {
        // empty string that will contain all the changes     
        LogWriter writer = new LogWriter();
        String text = " "; 
        // class will read the contents of the csv file and store them in a singleton. 
        readFiles read = new readFiles();
        read.setFlightsFile("FlightSchedule.csv");
        read.setPersonsFile("CustomerListPA4.csv");
        // instance of singleton
        airlineMap airline = airlineMap.getInstance();
        //scanner to get input from user
        Scanner scan = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        String option = " ";
        // while loop to repeat main menu until exit
        while(!(option.equalsIgnoreCase("exit")))
        { 
            // class displays the correct menu
            Menu mainMenu = new Menu();
            // set option with the return value of method main menu
            option = mainMenu.printMainMenu();
            // if option is 1, then customer, if 2 is an employee
            if(option.equalsIgnoreCase("1"))
            { 
                // log in menu
                System.out.println("Are you an individual customer? yes/no "); 
                String input = scan.nextLine();
                // we don't support multiple customers,
                if(input.equalsIgnoreCase("yes"))
                { 
                    // ask for user information
                    System.out.println("Enter your First Name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter your Last Name: ");
                    String lastname = scan.nextLine();
                    System.out.print("--- Log In ---"+'\n'+"Username:"); // log in 
                    String user = scan.nextLine();
                    System.out.print("Password:");
                    String password = scan.nextLine();
                    // check if it's a valid user, remember employees can also buy flights 
                    if(isValidUser(user) && isValidPassword(password))
                    {   
                        try
                        {   // boolean to exit customer menu
                            boolean exitCustomer = false;
                            // flag to exit customer menu
                            while(!exitCustomer)
                            {
                                // menu to buy or cancel a flight
                                System.out.println("----------------------------------------\n      Menu for customer      \n----------------------------------------\n"+"1. Buy a Ticket\n2. Cancel a Ticket\n3. View your Account\n4. View your Tickets\n5. Back to main menu");
                                int in = scan.nextInt();
                                scan.nextLine();
                                // buy ticket
                                if(in == 1)
                                {
                                    // String to write in file
                                    // method to continue with transaction
                                    text = logIn(user); 
                                    System.out.println("Back to customer menu...");
                                }
                                // cancel a ticket
                                else if(in == 2)
                                {
                                    System.out.println("Enter the ID of your flight");
                                    in = scan.nextInt();
                                    System.out.println("Enter the confirmation number of your Ticket: ");
                                    scan.nextLine();
                                    String confirmation = scan.nextLine();
                                    // cancel ticket if it exists
                                    try
                                    {
                                    airline.getMapFlights().get(in).cancelTicket(confirmation);
                                    text = "Customer cancelled ticket with confirmation number "+ confirmation;
                                    writer.write(text);
                                    System.out.println("Back to customer menu..");
                                    }
                                    catch (Exception e){
                                        System.out.println("This is not a valid id or confirmation number");
                                    }  
                                }else if(in==3){
                                    int key = getKey(user);
                                    System.out.println("Money Available: "+airline.getMapPersons().get(key).getMoneyAvailable());
                                    System.out.println("Savings: "+airline.getMapPersons().get(key).getSavings());
                                    System.out.println("Number of Tickets: "+airline.getMapPersons().get(key).getTicketList().size());
                                    text = "Customer viewed account ";
                                    writer.write(text);
                                }else if(in==4){
                                    int userKey = getKey(user);
                                    for(String key : airline.getMapPersons().get(userKey).getTicketList().keySet()){
                                        System.out.println(airline.getMapPersons().get(userKey).getTicketList().get(key).toString());
                                    }
                                    text = "Customer viewed Tickets ";
                                    writer.write(text);
                                }
                                // exit customer menu, back to main menu
                                else if(in==5)
                                {
                                    exitCustomer = true;
                                }
                                else
                                {
                                    System.out.println("This is not a valid option");
                                }
                                writer.write(text); // write text 
                            } 
                            System.out.println("Back to Main Menu");
                        }
                        catch(Exception e)
                        {
                        System.out.println("This is not an option from the menu");
                        }
                    }
                    else
                    {
                        System.out.println("Log In error"); 
                    }
                }
                else
                {
                    System.out.println("At the moment we only take individual customers, Thank you!");// we haven't implemented multiple customers
                }
            }
            // log in for employee
            else if(option.equalsIgnoreCase("2"))
            {
                System.out.print("--- Employee Log in --- \n"+"Username: ");
                String user = scan.nextLine();
                System.out.print("Password: ");
                String password = scan.nextLine();
                // if information is valid and has employee access
                String optionEmployee = " ";
                if((isValidUser(user) && isValidPassword(password))&& isValidEmployee(user))
                { 
                    boolean exit = false;
                    while(!exit)
                    {
                        System.out.println("--- Welcome MinerAirlines Employee ---\n 1) View Flight by ID \n 2) View All Flights\n 3) Generate Autopurchase\nor enter EXIT ");
                        optionEmployee = s.nextLine();
                        if(optionEmployee.equalsIgnoreCase("1"))
                        {
                            text = mainMenu.menuEmployee();
                        }
                        else if(optionEmployee.equalsIgnoreCase("2"))
                        {
                            menu();
                            text = mainMenu.menuEmployee();
                        } 
                        else if (optionEmployee.equalsIgnoreCase("3"))
                        {
                            System.out.println("--- Autopurchase Menu ---\n"+" 1) AutoPurchaser 10K\n 2) AutoPurchaser 100K \n 3) AutoPurchaser 400K \nor enter EXIT");
                            optionEmployee = s.nextLine().toLowerCase();
                            switch(optionEmployee)
                            {
                                case "1":
                                case "2":
                                case "3":
                                {
                                    Autopurchase.generateAutopurchase(optionEmployee);
                                    System.out.println("Autopurchase was successful...");
                                    break;
                                }
                                case "exit":
                                    break;
                                default:
                                    System.out.println("Invalid input...");
                                    break;
                            }
                        } 
                        else if (optionEmployee.equalsIgnoreCase("exit")){
                            exit = true;
                        }
                        else
                        {
                            System.out.println("Invalid input...");
                        }
                    }
                } 
                else 
                {
                    System.out.println("You are not an Employee, bye...");
                }
                writer.write(text); // write text
            }
        }
        // writer for the csv file
        LogWriter log = new LogWriter();
        log.writeCSVFlights();
        log.writeCSVPersons();

    }  


    /**
     * @param user
     * @return
     * This is a method to start the transaction and call all the methods for a customer buying a ticket.
     */
    public static String logIn(String user){
        // singleton instance
        airlineMap airline = airlineMap.getInstance();
        Scanner scan = new Scanner(System.in); // log in menu 
        Scanner sc = new Scanner(System.in); // log in menu 
        String text = " ";
        String end = " "; 
        int id = 0;
        String inSearch = " ";
        while(!("exit".equalsIgnoreCase(end)))
        {
            try
            {
                System.out.println("---Shop for flights--- " + '\n' + "In this transaction you are only allowed to purchase tickets 1-8 of the same type for one flight. "+ '\n');
                int countSearch = 0;
                while(countSearch == 0){
                    System.out.println("---Do you want to filter your search by \n - ID \n - Departure date \n - Origin (airport code) \n - Destination (airport code) \n - All (Depature Date, Origin Code, Destinayion Code)\n or 0 to view all flights available");
                    inSearch = scan.nextLine();
                    SearchFlight search = new SearchFlight();
                    if(inSearch.equalsIgnoreCase("0"))
                    {
                        menu();

                    } 
                    else if(inSearch.equalsIgnoreCase("origin"))
                    {
                        System.out.println("Enter the origin code:");
                        String origin = scan.nextLine();
                        countSearch = search.searchByOrigin(origin);
                        
                    } 
                    else if(inSearch.equalsIgnoreCase("destination"))
                    {
                        System.out.println("Enter the destination code: ");
                        String destination = scan.nextLine();
                        countSearch = search.searchByDestination(destination);

                    } 
                    else if(inSearch.equalsIgnoreCase("departure date"))
                    {
                        System.out.println("Enter number of month (1-12): ");
                        String departure = scan.nextLine();
                        System.out.println("Enter number of day (1-31): ");
                        departure += "/"+scan.nextLine();
                        System.out.println("Enter number of year as YYYY: ");
                        departure += "/"+scan.nextLine();
                        countSearch = search.searchByDeparture(departure);
                    }
                    else if(inSearch.equalsIgnoreCase("ID"))
                    {
                        countSearch = 1;
                    }
                    else if(inSearch.equalsIgnoreCase("All"))
                    {
                        System.out.println("Enter the origin code:");
                        String origin = scan.nextLine();
                        System.out.println("Enter the destination code: ");
                        String destination = scan.nextLine();
                        System.out.println("Enter number of month (1-12): ");
                        String departure = scan.nextLine();
                        System.out.println("Enter number of day (1-31): ");
                        departure += "/"+scan.nextLine();
                        System.out.println("Enter number of year as YYYY: ");
                        departure += "/"+scan.nextLine();
                        countSearch = search.searchByAllFilters(origin, destination, departure);
                    }
                }
                System.out.println("---Enter the ID of the flight you want to purchase");
                id = sc.nextInt(); 
                // get information from hashmap for flight 
                airline.getMapFlights().get(id).printSeatsInfo();
                System.out.println("* * Remember you only can buy one type of ticket per transaction"+"\n What type of ticket do you want to purchase? ");
                int type = sc.nextInt();
                System.out.println("Enter quantity of Tickets: ");
                int numTicket = sc.nextInt();
                text = buyTickets(id,type,numTicket,user);
                System.out.println("THANK YOU! enter EXIT, or any key for new transaction");
                end = scan.nextLine();
            }
            catch(NullPointerException e)
            {
                System.out.println("This is not a valid flight ID");
            }
            catch(Exception e)
            {
                System.out.println("This is an invalid input");
                end = "exit";
            }
        }
        // return ticket to write
        return text; 
    }

    /**
     * @param id
     * @param typeIn
     * @param ticketIn
     * @param user
     * @return
     * This is a method to create a ticket for the customer and flight, if they confirm the transaction.
     */
    public static String buyTickets(int id, int typeIn, int ticketIn, String user)
    {
        // singleton instance
        airlineMap airline = airlineMap.getInstance();
        String text = "";
        // if quantity of tickets is between the range
        if((ticketIn<=8)&&(ticketIn>0))
        { 
            // check if flight can be purchased 
            if(isFlightAvailable(id, typeIn))
            {
                // get the key of the customer hashmap
                int key = getKey(user);
                // create the same ticket for the customer and flight that are inside the singleton hashmaps
                text = airline.getMapFlights().get(id).createTicket(typeIn, ticketIn,airline.getMapPersons().get(key));  //create ticket
            }
            else
            {
                System.out.println("Ticket type not found or none available seats.");
            }
        }
        else
        {
            System.out.println("You can only buy a max of 8 tickets");
        }
        return text;
    }

    /**
     * @param id
     * @param type
     * @return
     * Method that checks if flight has enough seats to buy a ticket.
     */
    public static boolean isFlightAvailable(int id, int type){ 
        // singleton instance
        airlineMap airline = airlineMap.getInstance();
        // check type of ticket and if seats are available
        if((type == 1)&&(Integer.parseInt(airline.getMapFlights().get(id).getFirstSeats()))>0)
        {
            return true;
        }
        else if((type == 2)&&(Integer.parseInt(airline.getMapFlights().get(id).getBusinessSeats()))>0)
        {
            return true;
        }
        else if((type == 3)&&(Integer.parseInt(airline.getMapFlights().get(id).getMainSeats()))>0)
        {
            return true;
        }
        return false;
    }

    /**
     * Menu to print all flights with flight informtion
     */
    public static void menu()
    { 
        // singleton instance
        airlineMap airline = airlineMap.getInstance();
        System.out.println("----- Welcome to MinerAir ------"+'\n'+"---- Flight Schedule ----"+'\n'); 
        for(int i=0; i<airline.getMapFlights().size(); i++)
        {
         System.out.println('\n'+"--Option "+(i+1)+": "+'\n');
         airline.getMapFlights().get(i+1).printFlight();; // print menu with flights and IDs
        }
    }
    /**
     * @param user
     * @return
     * Method to get key for customer
     */
    public static int getKey(String user)
    { // return key in hashmap
        airlineMap airline = airlineMap.getInstance();
        for(int key:airline.getMapPersons().keySet())
        {
            if((airline.getMapPersons().get(key)).getUsername().equalsIgnoreCase(user))
            {
                return key;
            }
        }
        return 0;
    }
    /**
     * @param password
     * @return
     * method to check password
     */
    public static boolean isValidPassword(String password)
    { 
        airlineMap airline = airlineMap.getInstance();
        for(int key : airline.getMapPersons().keySet())
        {
            if(airline.getMapPersons().get(key).getPassword().equals(password))
            {
             return true;
            }
         }
        return false;
    }

    /**
     * @param user
     * @return
     * method to check if user is employees 
     */
    public static boolean isValidEmployee(String user)
    {
        airlineMap airline = airlineMap.getInstance();
        int i = getKey(user);
        return airline.getMapPersons().get(i).getIsEmployee();
    }

    /**
     * @param user
     * @return
     * method to check if user it is a valid user
     */
    public static boolean isValidUser(String user)
    { 
        airlineMap airline = airlineMap.getInstance();
        for(int key: airline.getMapPersons().keySet())
        {
           if((airline.getMapPersons().get(key)).getUsername().equalsIgnoreCase(user))
           {
            return true;
           }
        }
        return false;
    }
}