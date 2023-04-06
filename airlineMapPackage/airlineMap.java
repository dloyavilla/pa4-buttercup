package airlineMapPackage;
import java.util.HashMap;
/**
 * @author Denisse_Loya
 * Singleton class with the hashmaps used in most of the methods
 * that store the <id, flight> and <id, person>.
 */
public class airlineMap
{
    private static HashMap<Integer, Flight> mapFlights= new HashMap<>();
    private static HashMap<Integer, Person> mapPersons = new HashMap<>();
    private static airlineMap airline; //the object is accessible from everywhere

    /**
     * constructor airlineMap
     */
    private airlineMap(){}

    /**
     * you only have a single instance for the whole program
     * @return
     */
    public static airlineMap getInstance()
    {
        if(airline == null){
            airline = new airlineMap();
        }
        return airline;
    }
    
    /**
     * get Map Flights
     * @return
     */
    public HashMap<Integer, Flight> getMapFlights()
    {
        return airlineMap.mapFlights;
    }

    /**
     * Set Map Flights
     * @param mapFlights
     */
    public void setMapFlights(HashMap<Integer, Flight> mapFlights)
    {
        airlineMap.mapFlights = mapFlights;
    }

    /**
     * set Key flights
     * @param key
     * @param flight
     */
    public void setKeyFlights(int key, Flight flight)
    {
        airlineMap.mapFlights.put(key,flight);
    }

    /**
     * get Map Person
     * @return
     */
    public HashMap<Integer, Person> getMapPersons()
    {
        return airlineMap.mapPersons;
    }

    /**
     * set Map Person
     * @param mapPersons
     */
    public void setMapPersons(HashMap<Integer, Person> mapPersons)
    {
        airlineMap.mapPersons = mapPersons;
    }

    /**
     * add Key to map 
     * @param key
     * @param person
     */
    public void setKeyPersons(int key, Person person)
    {
        airlineMap.mapPersons.put(key, person);
    }
}
