package airlineMapPackage;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Denisse_Loya
 * Autopurchase to generate the three versions of csv files
 */

public class Autopurchase
{
    private static airlineMap airline = airlineMap.getInstance();

    /**
     * generate the name for the autopurchase
     * @param type
     */
    public static void generateAutopurchase(String type)
    {
        if(type.equals("1")){
            type = "AutoPurchaser10K.csv";
            readPurchases(type);
        }
        else if (type.equals("2"))
        {
            type = "AutoPurchaser100K.csv";
            readPurchases(type);
        }
        else
        {
            type = "AutoPurchaser400K.csv";
            readPurchases(type);
        }
    }

    // First Name,Last Name,Action,Flight ID,Origin Airport,Destination Airport,Ticket Type,Ticket Quantity

    /**
     * read the autopurchase file
     * @param fileName
     */
    public static void readPurchases(String fileName)
    {
        try
        {
            Scanner sc = new Scanner(new File(fileName));
            String [] header = sc.nextLine().split(",");
            HashMap <String, Integer> temp = new HashMap <>();
            Transaction transaction = new Transaction();
            for(int i=0; i<header.length; i++)
            {
                temp.put(header[i], i);
            }

            while(sc.hasNextLine())
            {
                String [] line = sc.nextLine().split(",");
                int key = getKey(line[temp.get("First Name")], line[temp.get("Last Name")]);
                Person customer = airline.getMapPersons().get(key);
                int type = getTypeSeats(line[temp.get("Ticket Type")]);
                int quantity = Integer.parseInt(line[temp.get("Ticket Quantity")]);
                String id = line[temp.get("Flight ID")];
                transaction.createTicketAutomatic(type, quantity, customer, id);
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("File not found :( ");
        } 
    }

    /**
     * find customer key
     * @param Name
     * @param Lastname
     * @return
     */
    public static int getKey(String Name, String Lastname)
    {
        for(int key:airline.getMapPersons().keySet())
        {
            String tempName = airline.getMapPersons().get(key).getName();
            String tempLastname = airline.getMapPersons().get(key).getLastName();
            if(tempLastname.equals(Lastname) && tempName.equals(Name)){
                return key;
            }
        }
        return 0;
    }

    /**
     * return int for the type of seats
     * @param type
     * @return
     */
    public static int getTypeSeats(String type){
        if(type.equalsIgnoreCase("First Class"))
        {
            return 1;
        }
        else if(type.equalsIgnoreCase("Business Class")){
            return 2;
        }
        return 3;
    }

    public static void writeElectronicTicketSummary(String Name, String Lastname)
    {
        int key = getKey(Name, Lastname);
        airline.getMapPersons().get(key).getTicketList();
    }

}