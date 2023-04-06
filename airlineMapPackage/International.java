package airlineMapPackage;
public class International extends Flight {
    /**
     * @author Denisse_Loya
     * Child international of Airport
     */
    public International() {}

    /**
     * @param flight
     * super and set flight international to true
     */
    public International(String id, String flightNum, String originAirport, String originCode, String destAirport, 
    String destCode, String depDate, String depTime, String duration, String distance, String timeZone, String arrDate, 
    String arrTime, String surcharge, String foodServed, String routeCost, String minerPoints, String totalSeats, 
    String firstSeats, String businessSeats, String mainSeats, String firstPrice, String businessPrice, String mainPrice,
    String originAirportCity, String originAirportState, String originAirportCountry, String originAirportFee, String originAirportLounge, 
    String destinationAirportState, String destinationAirportCity, String destinationAirportCountry, String destinationAirportFee, 
    String destinationAirportLounge) 
    {
        super(id, flightNum, originAirport, originCode, destAirport, destCode, depDate, depTime, duration, distance, timeZone, arrDate, arrTime, surcharge, foodServed, routeCost, minerPoints, totalSeats, firstSeats, businessSeats, mainSeats, firstPrice, businessPrice, mainPrice, originAirportCity, originAirportState, originAirportCountry, originAirportFee, originAirportLounge, destinationAirportState, destinationAirportCity, destinationAirportCountry, destinationAirportFee, destinationAirportLounge);
        setIsInternational(true);
    }   
}