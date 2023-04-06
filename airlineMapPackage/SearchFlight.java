package airlineMapPackage;

/**
 *  Class to search flight by attributes
 */
public class SearchFlight 
{
    private airlineMap airline = airlineMap.getInstance();

    public SearchFlight() {}

    /**
     * Method to search flight by origin
     * @param origin
     */
    public int searchByOrigin(String origin)
    {
        int count = 0;
       for(Integer key: airline.getMapFlights().keySet()){
        if(airline.getMapFlights().get(key).getOriginCode().equalsIgnoreCase(origin)){
            airline.getMapFlights().get(key).printAirport();
            count ++ ;
        }
       }
       if(count==0){
        System.out.println("Sorry we don't have any flights that match your input :(");
        return 0;
       }
       return 1;
    }

    /**
     * Method to search flight by destination
     * @param Destination
     */
    public int searchByDestination(String Destination)
    {
        int count = 0;
        for(Integer key: airline.getMapFlights().keySet()){
            if(airline.getMapFlights().get(key).getDestCode().equalsIgnoreCase(Destination)){
                airline.getMapFlights().get(key).printAirport();
                count ++;
            }
        }
        if(count==0){
            System.out.println("Sorry we don't have any flights that match your input :(");
            return 0;
        }
        return 1;
    }

    /**
     * Method to search flight by Departure
     * @param Departure
     */
    public int searchByDeparture(String Departure)
    {
        int count = 0;
        for(Integer key: airline.getMapFlights().keySet()){
            if(airline.getMapFlights().get(key).getDepDate().equalsIgnoreCase(Departure)){
                airline.getMapFlights().get(key).printAirport();
                count ++;
            }
        }   
        if(count==0){
            System.out.println("Sorry we don't have any flights that match your input :(");
            return 0;
        }
        return 1;
    }

    public int searchByAllFilters(String origin, String Destination, String Departure)
    {
        int count = 0;
        for(Integer key: airline.getMapFlights().keySet()){
            if(airline.getMapFlights().get(key).getOriginCode().equalsIgnoreCase(origin)&&(airline.getMapFlights().get(key).getDestCode().equalsIgnoreCase(Destination))
             && airline.getMapFlights().get(key).getDepDate().equalsIgnoreCase(Departure)){
                airline.getMapFlights().get(key).printAirport();
                count ++;
            }
        }  
        return 0;
    }
}
