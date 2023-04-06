package airlineMapPackage;
/**
 * @author Denisse_Loya
 * Domestic class child of flight
 */
public class Domestic extends Flight
{
    public Domestic() {}

    /**
     * @param flight
     * Set flight to domestic and super parent
     */
    public Domestic(String id, String flightNum, String originAirport, String originCode, String destAirport, 
    String destCode, String depDate, String depTime, String duration, String distance, String timeZone, String arrDate, 
    String arrTime, String surcharge, String foodServed, String routeCost, String minerPoints, String totalSeats, 
    String firstSeats, String businessSeats, String mainSeats, String firstPrice, String businessPrice, String mainPrice, 
    String originAirportCity, String originAirportState, String originAirportCountry, String originAirportFee, String originAirportLounge, 
    String destinationAirportState, String destinationAirportCity, String destinationAirportCountry, String destinationAirportFee, 
    String destinationAirportLounge) 
    {
        super(id, flightNum, originAirport, originCode, destAirport, destCode, depDate, depTime, duration, distance, timeZone, arrDate, arrTime, surcharge, foodServed, routeCost, minerPoints, totalSeats, firstSeats, businessSeats, mainSeats, firstPrice, businessPrice, mainPrice, originAirportCity, originAirportState, originAirportCountry, originAirportFee, originAirportLounge, destinationAirportState, destinationAirportCity, destinationAirportCountry, destinationAirportFee, destinationAirportLounge);
        setIsInternational(false);
    }

}