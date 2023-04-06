package airlineMapPackage;
import java.io.*;
import java.util.*;
/**
 * @author Denisse_Loya
 * @version 1.0 
 * Write the new csv files and log.txt
 */
public class LogWriter 
{
    private File fileFlights = new File("newFlightSchedule.csv");
    private File filePersons = new File("newCustomerListPA4.csv");

    private airlineMap airline = airlineMap.getInstance();
    private String text =" ";

    LogWriter() {}


    /**
     * @param text
     * write log for txt file
     */
    public void write(String text) 
    {
        try 
        {
          this.text += '\n' + text;
          FileWriter writer = new FileWriter("Log.txt");
          writer.write(this.text);
          writer.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File can't be written.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * write the csv flight
     */
    public void writeCSVFlights()
    {
        try
        {
            File flights = new File("FlightSchedule.csv");
            Scanner sc = new Scanner(flights);
              // writer
            FileWriter writeCSVflight = new FileWriter(fileFlights);
            // list of string arrays to contain data
            List<String[]> data = new ArrayList<String[]>();
            // add headers 
            data.add(new String[] { ",First Class Seats Sold", "Business Class Seats Sold", "Main Cabin Seats Sold"," Total First Class Revenue","Total Business Class Revenue","Total Main Cabin Revenue"});
            int i = 1;
            // first flight
            Flight currentFlight = airline.getMapFlights().get(i);
            // get all flights
            while(currentFlight!= null)
            {
                data.add(new String[] {","+currentFlight.getFirstSold(),currentFlight.getBusinessSold(), currentFlight.getMainSold(), String.valueOf(currentFlight.getTotalCollected().get("first")),String.valueOf(currentFlight.getTotalCollected().get("business")), String.valueOf(currentFlight.getTotalCollected().get("main cabin"))});
                currentFlight = airline.getMapFlights().get(++i);
            }

            // iterate the list and append to file by adding a comma and a new line in each row and column
            for(String[] lines: data)
            {
                StringBuilder rows = new StringBuilder();
                for(int j=0; j<lines.length;j++)
                {
                    rows.append(lines[j]);
                    if(j != lines.length - 1)
                    {
                        rows.append(',');
                    }
                }
                rows.append('\n');
                writeCSVflight.write(sc.nextLine());
                writeCSVflight.write(rows.toString());
            }
            writeCSVflight.close();
        }catch(IOException e)
        {
            System.out.println("File couldn't be transferred...");
        }
    }
    /**
     * write csv persons
     */
    public void writeCSVPersons()
    {
        try
        {
            File customer = new File("CustomerListPA4.csv");
            Scanner sc = new Scanner(customer);
              // writer
            FileWriter writeCSVPerson = new FileWriter(filePersons);
            // list of strings with data
            List<String[]> data = new ArrayList<String[]>();
            // add header
            data.add(new String[] { ",Updated Flights Purchased", "Updated Money Available"});
            Person currentPerson = new Person(); 
            int i = 1;
            // first person 
            currentPerson = airline.getMapPersons().get(i);
            // iterate persons
            while(currentPerson!= null)
            {
                data.add(new String[] {","+currentPerson.getFlightPurchased(), currentPerson.getMoneyAvailable()});
                currentPerson = airline.getMapPersons().get(++i);
            }
            // iterate list and write in file with comma and new line
            for(String[] lines: data)
            {
                StringBuilder rows = new StringBuilder();
                for(int j=0; j<lines.length;j++)
                {
                    rows.append(lines[j]);
                    if(j != lines.length - 1)
                    {
                        rows.append(',');
                    }
                }
                rows.append('\n');
                writeCSVPerson.write(sc.nextLine());
                writeCSVPerson.write(rows.toString());
            }
            writeCSVPerson.close();
        }catch(IOException e)
        {
            System.out.println("File couldn't be transfered...");
        }
    }
}