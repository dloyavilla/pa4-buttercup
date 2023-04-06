package airlineMapPackage;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
/**
 * @author Denisse_Loya
 * Read CSV files
 */
public class readFiles {

    // singleton instance
    airlineMap airline = airlineMap.getInstance();

    public readFiles() {}

    /**
     * @param flightsFile
     * modify singleton instance and read file for flights
     */

    public void setFlightsFile(String flightsFile) 
    {
        try
        {
            Scanner sc = new Scanner(new File(flightsFile));
            String [] tempHeader = sc.nextLine().split(",");
            HashMap <String, Integer> header = new HashMap<>();

            for(int i=0; i<tempHeader.length; i++){
                header.put(tempHeader[i], i);
            }

            String currFlight = " ";
            HashMap <Integer, Flight> tempMap = new HashMap<>();
            while(sc.hasNext())
            { 
                currFlight = sc.nextLine();
                // split rows 
                String[] temp = currFlight.split(","); 
                // check type flight
                Flight flight = Factory.getFlights(temp, header);
                tempMap.put(Integer.parseInt(temp[header.get("ID")]), flight);
                airline.setMapFlights(tempMap);
            }
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    /**
     * @param personsFile
     * modify singleton instance and read file for persons
     */
    public void setPersonsFile(String personsFile) 
    {
        try
        {
            Scanner scn = new Scanner(new File(personsFile));
            String[] tempHeader = scn.nextLine().split(",");
            HashMap <String, Integer> header = new HashMap<>();
            for(int i=0; i<tempHeader.length; i++){
                header.put(tempHeader[i], i);
            }
            String currCustomer = " ";
            HashMap <Integer, Person> tempMap = new HashMap<>();
            while(scn.hasNext())
            {
                // read customerlist and create object
                currCustomer = scn.nextLine(); 
                String[] temp = currCustomer.split(","); 
                // check the type of Person
                Person person = Factory.getPerson(temp, header);
                tempMap.put(Integer.parseInt(temp[header.get("ID")]), person);
            }
            airline.setMapPersons(tempMap);
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}


