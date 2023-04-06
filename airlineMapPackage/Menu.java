package airlineMapPackage;
import java.util.Scanner;
/**
 * @author Denisse_Loya
 * All the menus
 */

public class Menu 
{
    // empty string that will contain all the change
    private String text = " "; 
    private airlineMap airline = airlineMap.getInstance();
    Scanner sc = new Scanner(System.in);

    public Menu() {}

    /**
     * @return
     * Main Menu
     */
    public String printMainMenu()
    {
        System.out.println("----------------------------------------\n      Welcome to MinerAirlines     \n----------------------------------------"+"\n 1. Log in to Membership Account \n 2. Log in for Employees  \n or EXIT "); //main menu
        String input = sc.nextLine(); // main menu
        return input;
    }

    /**
     * @return
     * Menu to modify all flight attributes 
     */
    public String FlightSchedule()
    {
        String text ="";
        try
        {
            String inputFlight="exit";
            String input = " ";

            // stay in menu until exit
            while(!(inputFlight.equalsIgnoreCase(input)))
            { 
                System.out.println('\n'+"--- Please enter the ID of the flight or Exit ---");
                input = sc.nextLine(); 
                int inputMenu=0;
                // second menu
                while(inputMenu!=-1)
                { 
                    System.out.flush();  
                    if(airline.getMapFlights().containsKey(Integer.parseInt(input)))
                    {
                        System.out.println("--------------------\n      Menu to modify flight       \n--------------------"+'\n'+"----Set Information----"+'\n'+"1. Origin Airport"+'\n'+
                        "2. Origin Code"+'\n'+"3. Destination Airport"+'\n'+"4. Destination Code"+'\n'+"5. Departure Date"+'\n'+"6. Departure Time"+'\n'+"7. First Class Price"+'\n'+
                        "8. Business Class Price"+'\n'+"9. Main Cabin Price");
                        System.out.println("----Get Information----"+'\n'+"9. Origin Airport"+'\n'+"10. Origin Code"+'\n'+"11. Destination Airport"+'\n'+"12. Destination Code"+
                        '\n'+"13. Departure Date"+'\n'+"14. Departure Time"+'\n'+"15. Arrival Date"+'\n'+"16. Arrival Time"+'\n'+"17. Duration"+'\n'+"18. Distance"+'\n'+"19. Time Zone Difference"+
                        '\n'+"20. First Class Price"+'\n'+"21. Business Class Price"+'\n'+"22. Main Cabin Price"+'\n'+"23. First Class Seats"+'\n'+"24. Bussines Class Seats"+'\n'+"25. Main Cabin Seats"+'\n'+
                        "26. Total Seats"+'\n'+"27. Print Information \n or -1 to EXIT");
                        inputMenu = sc.nextInt(); 
                        text = modifyAttributes(inputMenu, Integer.parseInt(input));
                    }
                }
            }
        }catch(Exception e)
        {
           e.getMessage();
        }
        return text;
    }
    /**
     * @param inputMenu
     * @param id
     * @return
     * switch cases for modifiy menu
     */
    public String modifyAttributes(int inputMenu, int id)
    {
        sc.nextLine();
        String input;
        switch(inputMenu)
        { 
            // different options for the menu
            case 1: 
                System.out.println("---Update Origin Airport---"+'\n'+"Enter new Origin Airport: ");
                input = sc.nextLine();
                // get fligth from the airline.getMapFlights() and use setter
                (airline.getMapFlights().get(id)).setOriginAirport(input); 
                this.text = "Flight ID "+Integer.toString(id)+" updated origin airport to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 2: 
                System.out.println("---Update Origin Code---"+'\n'+"Enter new Origin Code: ");
                input = sc.nextLine();
                airline.getMapFlights().get(id).setOriginCode(input);
                this.text = "Flight ID "+Integer.toString(id)+" updated origin code to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 3: 
                System.out.println("---Update Destination Airport---"+'\n'+"Enter new Destination Airport: ");
                input = sc.nextLine();
                airline.getMapFlights().get(id).setDestAirport(input);
                this.text = "Flight ID "+Integer.toString(id)+" updated destination airport to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 4: 
                System.out.println("---Update Destination Code---"+'\n'+"Enter new Destination Code: ");
                input = sc.nextLine();
                airline.getMapFlights().get(id).setDestCode(input);
                this.text = "Flight ID "+Integer.toString(id)+" updated destination code to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 5: 
                System.out.println("---Update Departure Date---"+'\n'+"Enter new Departure Date: ");
                input = sc.nextLine();
                airline.getMapFlights().get(id).setDepDate(input);
                this.text = "Flight ID "+Integer.toString(id)+" updated departure date to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 6: 
                System.out.println("---Update Departure Time---"+'\n'+"Enter new Departure Time in the form of hh:mm");
                input = sc.nextLine();
                System.out.println("Enter AM or PM:");
                String inputT = sc.nextLine();
                airline.getMapFlights().get(id).setDepTime(input, inputT);
                this.text = "Flight ID "+Integer.toString(id)+" updated departure time to " + input + " "+ inputT;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 7: 
                System.out.println("---Update First Class Price---"+'\n'+"Enter new First Class Price: ");
                input = sc.nextLine();
                airline.getMapFlights().get(id).setFirstClass(input);
                this.text = "Flight ID "+Integer.toString(id)+" updated first class price to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 8: 
                System.out.println("---Update Business Class Price---"+'\n'+"Enter new Business Class Price: ");
                input = sc.nextLine();
                airline.getMapFlights().get(id).setBusinessClass(input);
                this.text = "Flight ID "+Integer.toString(id)+" updated business class price to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 9: 
                System.out.println("---Update Main Cabin Price---"+'\n'+"Enter new Main Cabin Price: ");
                input = sc.nextLine();
                airline.getMapFlights().get(id).setMainCabin(input);
                this.text = "Flight ID "+Integer.toString(id)+" updated main cabin price to " + input;
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 10: 
                System.out.println("---Origin Airport---");
                System.out.println(airline.getMapFlights().get(id).getOriginAirport());
                break;
            case 11: 
                System.out.println("---Origin Code---");
                System.out.println(airline.getMapFlights().get(id).getOriginCode());
                break;
            case 12:
                System.out.println("---Destination Airport---");
                System.out.println(airline.getMapFlights().get(id).getDestAirport());
                System.out.println("Done!");
                break;
            case 13:
                System.out.println("---Destination Code---");
                System.out.println(airline.getMapFlights().get(id).getDestAirport());
                System.out.println("Done!");
                break;
            case 14:
                System.out.println("---Departure Date---");
                System.out.println(airline.getMapFlights().get(id).getDepDate());
                System.out.println("Done!");
                break;
            case 15:
                System.out.println("---Departure Time---");
                System.out.println(airline.getMapFlights().get(id).getDepTime());
                System.out.println("Done!");
                break;
            case 16:
                System.out.println("---Arrival Date---");
                System.out.println(airline.getMapFlights().get(id).getArrDate());
                System.out.println("Done!");
                break;
            case 17:
                System.out.println("---Arrival Time---");
                System.out.println(airline.getMapFlights().get(id).getArrTime());
                System.out.println("Done!");
                break;
            case 18:
                System.out.println("---Duration---");
                System.out.println(airline.getMapFlights().get(id).getDuration());
                System.out.println("Done!");
                break;
            case 19:
                System.out.println("---Time Zone Difference---");
                System.out.println(airline.getMapFlights().get(id).getTimeZone());
                System.out.println("Done!");
                break;
            case 20:
                System.out.println("---First Class Price---");
                System.out.println(airline.getMapFlights().get(id).getFirstPrice());
                System.out.println("Done!");
                break;
            case 21:
                System.out.println("---Business Class Price---");
                System.out.println(airline.getMapFlights().get(id).getBusinessPrice());
                System.out.println("Done!");
                break;
            case 22:
                System.out.println("---Main Cabin Price---");
                System.out.println(airline.getMapFlights().get(id).getMainPrice());
                System.out.println("Done!");
                break;
            case 23:
                System.out.println("---First Class Seats---");
                System.out.println(airline.getMapFlights().get(id).getFirstPrice());
                System.out.println("Done!");
                break;
            case 24:
                System.out.println("---Business Class Seats---");
                System.out.println(airline.getMapFlights().get(id).getBusinessSeats());
                System.out.println("Done!");
                break;
            case 25:
                System.out.println("---Main Cabin Seats---");
                System.out.println(airline.getMapFlights().get(id).getMainSeats());
                System.out.println("Done!");
                break;
            case 26:
                System.out.println("---Total Seats---");
                System.out.println(airline.getMapFlights().get(id).getDepDate());
                System.out.println("Done!");
                break;
            case 27:
                System.out.println("---Flight Information---");
                airline.getMapFlights().get(id).printFlight();
                break;
            default: 
                System.out.println("Invalid input, please enter an option from the menu"); // takes care of invalid input for second menu
            System.out.flush();
        } // end of MENU to modify attributes
        return text; // return string with changes made
    }

    /**
     * @return
     * Menu for employees
     */
    public String menuEmployee()
    {
        String text ="";
            String inputFlight="exit";
            String input = " ";
            // Stay in main Employee Menu until exit
            while(!(inputFlight.equalsIgnoreCase(input)))
            { 
                try{
                System.out.println('\n'+"--- Please enter the ID of the flight or Exit ---");
                input = sc.nextLine(); // read ID 
                int inputMenu=0;
                // second menu
                while(inputMenu!=-1)
                { 
                    System.out.flush();  
                    // check if ID is valid
                    if(airline.getMapFlights().containsKey(Integer.parseInt(input)))
                    {
                        System.out.println("----------------------------------------\n      Menu for employee       \n----------------------------------------"+'\n'+"1. Flight information "+'\n'+
                        "2. Number of Seats remaining "+'\n'+"3. List of customers"+'\n'+"4. Amount collected"+'\n'+"5. Cancel Flight"+'\n'+"6. Modify Attributes"+"\n7. Airport Information"+"\n or -1 Exit");
                        inputMenu = sc.nextInt(); 
                        text = flightFinances(inputMenu, Integer.parseInt(input)); // return text with attributes changed by user
                        if(inputMenu==-1){
                            break;
                        }
                    }
                }
            }catch(Exception e){
                System.out.println("Back to Main Menu...");
            }
        }
        return text;
    }

    /**
     * @param inputMenu
     * @param id
     * @return
     * Return the finances of the flight, such as revenue
     */
    public String flightFinances(int inputMenu, int id)
    {
        sc.nextLine();
        switch(inputMenu)
        {
             // different option for the menu
            case 1: 
                // print flight information
                System.out.println("--- Flight Information ---");
                this.airline.getMapFlights().get(id).printFlight();
                this.text = "Flight ID "+Integer.toString(id)+" information printed successfully.. ";
                System.out.println(text);
                break;
            case 2: 
                //  get number of seats remaining
                System.out.println("--- Number of seats remaining ---");
                System.out.println("Total number of available seats: " + airline.getMapFlights().get(id).getTotalSeats());
                System.out.println("First Class seats remaining: " + airline.getMapFlights().get(id).getFirstSeats());
                System.out.println("Business Class seats remaining: " + airline.getMapFlights().get(id).getBusinessSeats());
                System.out.println("Main Cabin Class seats remaining: " + airline.getMapFlights().get(id).getMainSeats());
                this.text = "Flight ID "+Integer.toString(id)+" seats availability printed successfully..";
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 3: 
                // get customers and information from flight
                System.out.println("--- List of customers on the flight ---");
                System.out.println(airline.getMapFlights().get(id).getTicketList().toString());
                this.text = "Flight ID "+Integer.toString(id)+" customer information printed successfully..";
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 4: 
                // Profit from the flights purchased 
                System.out.println("--- Amount Collected ---");
                System.out.println("First Class: "+ airline.getMapFlights().get(id).getTotalCollected().get("first"));
                System.out.println("Business Class: "+ airline.getMapFlights().get(id).getTotalCollected().get("business"));
                System.out.println("Main Cabin Class: "+ airline.getMapFlights().get(id).getTotalCollected().get("main cabin"));
                System.out.println("Total MinerAirlines Fees: "+ airline.getMapFlights().get(id).getTotalCollected().get("minerAirlines fee"));
                System.out.println("Total Security Fees: "+ airline.getMapFlights().get(id).getTotalCollected().get("security fee"));
                System.out.println("Total Taxes (This amount is not collected): "+ airline.getMapFlights().get(id).getTaxesCollected());
                System.out.println("Total Expected Profit: "+ airline.getMapFlights().get(id).expectedProfit());
                System.out.println("Total Profit: "+ airline.getMapFlights().get(id).getTotalProfit());
                this.text = "Flight ID "+Integer.toString(id)+" amount collected and expected profit printed successfully.. ";
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 5: 
                // cancel this flight
                System.out.println("--- Cancel Flight ---");
                airline.getMapFlights().get(id).cancelFlight();
                this.text = "Flight ID "+Integer.toString(id)+" was canceled successfully ";
                System.out.println(text);
                System.out.println("Done!");
                break;
            case 6:
                // print modify menu
                FlightSchedule();
                break;
            case 7:
                System.out.println("---Airport Codes---\n - "+airline.getMapFlights().get(id).getOriginCode()+"\n - "+airline.getMapFlights().get(id).getDestCode()+"\n Enter the code of the airport you want to select: ");
                String code = sc.nextLine();
                if(code.equalsIgnoreCase(airline.getMapFlights().get(id).getOriginCode()))
                {
                    airline.getMapFlights().get(id).getOrigin().printAirportInformation();
                }
                else if(code.equalsIgnoreCase(airline.getMapFlights().get(id).getDestCode()))
                {
                    airline.getMapFlights().get(id).getDestination().printAirportInformation();
                }
                else{
                    System.out.println("This is not a valid input...");
                }
                break;
            case -1:
                break;
            default: 
                System.out.println("Invalid input, please enter an option from the menu"); 
                // takes care of invalid input for second menu
            System.out.flush();
        } 
        // end of MENU to modify attributes
        return text; // return string with changes made
    }

}
