package airlineMapPackage;
import java.util.HashMap;

/**
 * @author Denisse_Loya
 * Flight Class, parent of domestic and international
 */

public abstract class Flight
{
    // attributes 
    private String id, flightNum, depDate, originAirport, destAirport, destCode, originCode, depTime, arrDate, arrTime, duration, timeZone, firstSeats,
    businessSeats, mainSeats, totalSeats, distance, firstPrice, businessPrice, mainPrice, surcharge, firstTotalSeats, businessTotalSeats, mainTotalSeats,
    originAirportCountry, originAirportFee, originAirportLounge, destinationAirportState, destinationAirportCity, destinationAirportCountry, destinationAirportFee, destinationAirportLounge;
    private boolean isInternational;
    private double minerAirlinesFee = 9.15;
    private double securityFee = 5.60;
    private String foodServed, routeCost, minerPoints, firstSold, businessSold, mainSold;
    // boolean to check if flight has been canceled
    private boolean isValidFlight;
    // list of tickets 
    private HashMap <String,Ticket> ticketList = new HashMap<>();
    // money collected per class
    private HashMap <String, Double> totalCollected = new HashMap<>();
    private double totalProfit;
    private double discounted; 
    private Transaction transaction;
    private Airport destination;
    private Airport origin;

    public Flight(){}

    /**
     * Constructor for Flight
     * @param id
     * @param flightNum
     * @param originAirport
     * @param originCode
     * @param destAirport
     * @param destCode
     * @param depDate
     * @param depTime
     * @param duration
     * @param distance
     * @param timeZone
     * @param arrDate
     * @param arrTime
     * @param surcharge
     * @param foodServed
     * @param routeCost
     * @param minerPoints
     * @param totalSeats
     * @param firstSeats
     * @param businessSeats
     * @param mainSeats
     * @param firstPrice
     * @param businessPrice
     * @param mainPrice
     * @param originAirportCity
     * @param originAirportState
     * @param originAirportCountry
     * @param originAirportFee
     * @param originAirportLounge
     * @param destinationAirportState
     * @param destinationAirportCity
     * @param destinationAirportCountry
     * @param destinationAirportFee
     * @param destinationAirportLounge
     */
    public Flight(String id, String flightNum, String originAirport, String originCode, String destAirport, 
    String destCode, String depDate, String depTime, String duration, String distance, String timeZone, String arrDate, 
    String arrTime, String surcharge, String foodServed, String routeCost, String minerPoints, String totalSeats, 
    String firstSeats, String businessSeats, String mainSeats, String firstPrice, String businessPrice, String mainPrice,
    String originAirportCity, String originAirportState, String originAirportCountry, String originAirportFee, String originAirportLounge, 
    String destinationAirportState, String destinationAirportCity, String destinationAirportCountry, String destinationAirportFee, 
    String destinationAirportLounge)
    { 
        this.id = id;
        this.flightNum = flightNum;
        this.originAirport = originAirport;
        this.originCode = originCode;
        this.destAirport = destAirport;
        this.destCode = destCode;
        this.depDate = depDate;
        this.depTime = depTime;
        this.duration = duration;
        this.distance = distance;
        this.timeZone = timeZone;
        this.arrDate = arrDate;
        this.arrTime = arrTime;
        this.surcharge = surcharge;
        this.foodServed = foodServed;
        this.routeCost = routeCost;
        this.minerPoints = minerPoints;
        this.totalSeats = totalSeats;
        this.firstSeats = firstSeats;
        this.businessSeats = businessSeats;
        this.mainSeats = mainSeats;
        this.firstPrice = firstPrice;
        this.businessPrice = businessPrice;
        this.mainPrice = mainPrice;   
        this.destinationAirportFee = destinationAirportFee;
        this.originAirportFee = originAirportFee;
        // no flights had been bought
        totalCollected.put("first", 0.0); 
        totalCollected.put("business", 0.0);
        totalCollected.put("main cabin", 0.0);
        totalCollected.put("minerAirlines fee", 0.0);
        totalCollected.put("security fee",0.0);
        
        isValidFlight = true;       
        this.firstTotalSeats = firstSeats;
        this.businessTotalSeats = businessSeats;
        this.mainTotalSeats = totalSeats;

        this.destination = new Airport(destCode, destAirport, destinationAirportCity, destinationAirportState, destinationAirportCountry, destinationAirportFee, destinationAirportLounge, 0);
        this.origin = new Airport(originCode,originAirport, originAirportCity, originAirportState, originAirportCountry, originAirportFee, originAirportLounge, 0);

        this.transaction = new Transaction(id);

    }
    
    /**
     * get Food Served Flight class
     * @return
     */
    public String getFoodServed() 
    {
        return this.foodServed;
    }    
    
    /**
     * set Discounted per flight
     * @param savdiscountedings
     */
    public void setDiscounted(double savdiscountedings) {
        this.discounted += discounted;
    }


    /**
     * get Discounted per flight
     * @return
     */
    public double getDiscounted() {
        return this.discounted;
    }


    /**
     * set First Class seats sold
     * @param seats
     */
    public void setFirstSold(String seats)
    {
        this.firstSold = seats;
    }

    /**
     * set Business Class setas sold
     * @param seats
     */
    public void setBusinessSold(String seats)
    {
        this.businessSold = seats;
    }

    /**
     * set Main Class Seats Sold
     * @param seats
     */
    public void setMainSold(String seats)
    {
        this.mainSold = seats;
    }

    /**
     * get Transaction for flight
     * @return
     */
    public Transaction getTransaction() {
        return this.transaction;
    }

    /**
     * get ticket List per Flight
     * @return
     */
    public HashMap<String,Ticket> getTicketList() {
        return this.ticketList;
    }

    /**
     * set Ticket List Flight
     * @param ticketList
     */
    public void setTicketList(HashMap<String,Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    /**
     * get Destination Flight
     * @return
     */
    public Airport getDestination() {
        return this.destination;
    }

    /**
     * set Destination Flight
     * @param destination
     */
    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    /**
     * get Origin Flight
     * @return
     */
    public Airport getOrigin() {
        return this.origin;
    }

    /**
     * set Origin Flight
     * @param origin
     */
    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    /**
     * set Transaction Flight
     * @param transaction
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * @return
     * get number of seats sold by each class
     */
    public String getFirstSold()
    {

        this.firstSold = String.valueOf(Integer.parseInt(this.firstTotalSeats)-Integer.parseInt(this.firstSeats));
        return this.firstSold;
    }
    
    /**
     * get Business Seats Sold
     * @return
     */
    public String getBusinessSold()
    {
        this.businessSold = String.valueOf(Integer.parseInt(this.businessTotalSeats)-Integer.parseInt(this.businessSeats));
        return this.businessSold;
    }

    /**
     * get Main Seats Sold
     * @return
     */
    public String getMainSold()
    {
        this.mainSold = String.valueOf(Integer.parseInt(this.mainTotalSeats)-Integer.parseInt(this.mainSeats));
        return this.mainSold;
    }

    /**
     * get Total Profit Flight
     * @return
     */
    public double getTotalProfit()
    {
        return this.totalProfit;
    }

    // save total money collected
    /**
     * set Total Profit Flight 
     * @param totalProfit
     */
    public void setTotalProfit(double totalProfit)
    {
        this.totalProfit += totalProfit;
    }

    // save money per class collected
    /**
     * get Total Collected per Class
     * @return
     */
    public HashMap<String, Double> getTotalCollected()
    {
        return this.totalCollected;
    }


    /**
     * sum the money from all the types of flights
     */
    public void updateTotalProfit()
    {
        double collected = totalCollected.get("first") + totalCollected.get("business") + totalCollected.get("main cabin");
        this.totalProfit = collected - expectedProfit();
    }

    /**
     * calculate expected profit
     * @return
     */
    public double expectedProfit()
    {
        return (Double.parseDouble(this.firstPrice) * Integer.parseInt(this.firstTotalSeats) + Double.parseDouble(this.businessPrice) * Integer.parseInt(this.businessTotalSeats) + Double.parseDouble(this.mainPrice) * Integer.parseInt(this.mainTotalSeats));
    }

    /**
     * set Food Served
     * @param foodServed
     */
    public void setFoodServed(String foodServed) 
    {
        this.foodServed = foodServed;
    }

    /**
     * get Route Cost
     * @return
     */
    public String getRouteCost() 
    {
        return this.routeCost;
    }

    /**
     * set Route Cost
     * @param routeCost
     */
    public void setRouteCost(String routeCost) 
    {
        this.routeCost = routeCost;
    }

    /**
     * get Miner Points
     * @return
     */
    public String getMinerPoints() 
    {
        return this.minerPoints;
    }

   /**
    * Set Miner Points
     * @param minerPoints
     */
     public void setMinerPoints(String minerPoints) 
    {
        this.minerPoints = minerPoints;
    }

   /**
    * Set Departure Date
     * @param depDateIn
     */
     public void setDepDate(String depDateIn)
    {
        this.depDate = depDateIn;
        this.arrDate = depDateIn;
    }

    /**
     * set Departure Time
     * @param depTimeIn
     * @param clockIn
     */
    public void setDepTime(String depTimeIn, String clockIn)
    {

        String[] time = depTimeIn.split(":"); // split input into string array
        int[] timeInt = new int[time.length]; 
        for(int i=0; i<time.length; i++ ){
            timeInt[i] = Integer.parseInt(time[i]); // string to int
        }
        int hrs = timeInt[0] * 60; // hrs to minutes
        int dString = Integer.parseInt(duration); // sTring to int
        int minutes = hrs + timeInt[1] + dString; // total sum of minutes
        int totalHrs = minutes/60; // get new hours
        int totalMinutes = minutes % 60; // get new minutes
        String clock = "AM"; // set to am since is a 12 hr clock
        if((totalHrs > 12)&&(clockIn.equalsIgnoreCase("AM"))){
            totalHrs = totalHrs % 12;
            clock = "PM"; // change to pm 
        }
        if((totalHrs > 12)&&(clockIn.equalsIgnoreCase("PM"))){
            totalHrs = totalHrs % 12;
            clock = "AM"; // change to am 
        }
        String arrTimeIn = Integer.toString(totalHrs) + ":" + Integer.toString(totalMinutes) + " "+ clock; 
        this.depTime = depTimeIn+" "+clockIn;    
        this.arrTime = arrTimeIn;
    }

    /**
     * set First Class
     * @param priceIn
     */
    public void setFirstClass(String priceIn)
    {
        this.firstPrice = priceIn;
    }

    /**
     * set Business Class
     * @param priceIn
     */
    public void setBusinessClass(String priceIn)
    {
        this.businessPrice = priceIn;
    }

    /**
     * set Main Cabin
     * @param priceIn
     */
    public void setMainCabin(String priceIn)
    {
        this.mainPrice = priceIn;
    }

    /**
     * get Departure Date
     * @return
     */
    public String getDepDate()
    {
        return this.depDate;
    }
    
    /**
     * get Departure Time
     * @return
     */
    public String getDepTime()
    {
        return this.depTime;
    }

    /**
     * get Arrival Date
     * @return
     */
    public String getArrDate()
    {
        return this.arrDate;
    }
    
    /**
     * get Arrival Time
     * @return
     */
    public String getArrTime()
    {
        return this.arrTime;
    }
    
    /**
     * set Arrival Date
     * @param arrDate
     */
    public void setArrDate(String arrDate) 
    {
        this.arrDate = arrDate;
    }

    /**
     * set Arrival Time
     * @param arrTime
     */
    public void setArrTime(String arrTime) 
    {
        this.arrTime = arrTime;
    }

    /**
     * set Duration 
     * @param duration
     */
    public void setDuration(String duration) 
    {
        this.duration = duration;
    }

    /**
     * set Time Zone
     * @param timeZone
     */
    public void setTimeZone(String timeZone) 
    {
        this.timeZone = timeZone;
    }

    /**
     * set First Class Seats
     * @param firstSeats
     */
    public void setFirstSeats(String firstSeats) 
    {
        this.firstSeats = firstSeats;
    }

    /**
     * set Bussiness Class Seats Total
     * @param businessSeats
     */
    public void setBusinessSeats(String businessSeats) 
    {
        this.businessSeats = businessSeats;
    }

    /**
     * set Main Seats Total
     * @param mainSeats
     */
    public void setMainSeats(String mainSeats) 
    {
        this.mainSeats = mainSeats;
    }

    /**
     * Set Total Number of Setas
     * @param totalSeats
     */
    public void setTotalSeats(String totalSeats) 
    {
        this.totalSeats = totalSeats;
    }

    /**
     * set Ditance
     * @param distance
     */
    public void setDistance(String distance) 
    {
        this.distance = distance;
    }

    /**
     * set boolean to check if it is International
     * @param isInternational
     */
    public void setIsInternational(boolean isInternational)
    {
        this.isInternational = isInternational;
    }

    /**
     * Set Origin Code
     * @param originCode
     */
    public void setOriginCode(String originCode) 
    {
        this.originCode = originCode;
    }

    /**
     * Set Destiny Code
     * @param destCode
     */
    public void setDestCode(String destCode) 
    {
        this.destCode = destCode;
    }

   /**
    * set Origin Airport
     * @param originAirport
     */
     public void setOriginAirport(String originAirport) 
    {
        this.originAirport = originAirport;
    }

    /**
     * set Destiny Airport
     * @param destAirport
     */
    public void setDestAirport(String destAirport) 
    {
        this.destAirport = destAirport;
    }

    /**
     * get Is International
     * @return
     */
    public boolean getIsInternational()
    {
        return this.isInternational;
    }

    /**
     * get Duration
     * @return
     */
    public String getDuration()
    {
        return this.duration;
    }

    /**
     * get Distance
     * @return
     */
    public String getDistance()
    {
        return this.distance;
    }
    
    /**
     * get Time Zone
     * @return
     */
    public String getTimeZone()
    {
        return this.timeZone;
    }
    
    /**
     * get First Class Price
     * @return
     */
    public String getFirstPrice()
    {
        return this.firstPrice;
    }
    
    /**
     * get Main Cabin Price
     * @return
     */
    public String getMainPrice()
    {
        return this.mainPrice;
    }

    /**
     * get ID Flight
     * @return
     */
    public String getId() 
    {
        return this.id;
    }

    /**
     * get Flight Number
     * @return
     */
    public String getFlightNum() 
    {
        return this.flightNum;
    }

    /**
     * get Business Seats
     * @return
     */
    public String getBusinessSeats() 
    {
        return this.businessSeats;
    }

    /**
     * get Main Cabin Seats
     * @return
     */
    public String getMainSeats() 
    {
        return this.mainSeats;
    }


    /**
     * get First Class Seats
     * @return
     */
    public String getFirstSeats()
    {
        return this.firstSeats;
    }

    /**
     * get Total Class Seats
     * @return
     */
    public String getTotalSeats()
    {
        return this.totalSeats;
    }
    
    /**
     * get Destiny Airport
     * @return
     */
    public String getDestAirport()
    {
        return this.destAirport;
    }

   /**
    * get Origin Airport
     * @return
     */
     public String getOriginAirport()
    {
        return this.originCode;
    }

    /**
     * get Destiny Code
     * @return
     */
    public String getDestCode()
    {
        return this.destCode;
    }

   /**
    * get Origin Code
     * @return
     */
     public String getOriginCode()
    {
        return this.originCode;
    }

   /**
    * set ID flight
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set Flight Number
     * @param flightNum
     */
    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    /**
     * Set First Class Price
     * @param firstPrice
     */
    public void setFirstPrice(String firstPrice) {
        this.firstPrice = firstPrice;
    }

    /**
     * get Business Class Price
     * @return
     */
    public String getBusinessPrice() {
        return this.businessPrice;
    }

    /**
     * Set Business Class Price
     * @param businessPrice
     */
      public void setBusinessPrice(String businessPrice) {
        this.businessPrice = businessPrice;
    }

    /**
     * Set Main Class Price
     * @param mainPrice
     */
    public void setMainPrice(String mainPrice) {
        this.mainPrice = mainPrice;
    }

    /**
     * get Surcharge
     * @return
     */
    public String getSurcharge() {
        return this.surcharge;
    }

    /**
     * set Surcharge
     * @param surcharge
     */
    public void setSurcharge(String surcharge) {
        this.surcharge = surcharge;
    }

    /**
     * get First Class Total Seats
     * @return
     */
    public String getFirstTotalSeats() {
        return this.firstTotalSeats;
    }

    /**
     * set First Total Seats
     * @param firstTotalSeats
     */
    public void setFirstTotalSeats(String firstTotalSeats) {
        this.firstTotalSeats = firstTotalSeats;
    }

    /**
     * get Business Total Seats
     * @return
     */
    public String getBusinessTotalSeats() {
        return this.businessTotalSeats;
    }

    /**
     * Set Business Total Seats
     * @param businessTotalSeats
     */
    public void setBusinessTotalSeats(String businessTotalSeats) {
        this.businessTotalSeats = businessTotalSeats;
    }

    /**
     * get Main Total Seats
     * @return
     */
    public String getMainTotalSeats() {
        return this.mainTotalSeats;
    }

    /**
     * set Main Total Seats
     * @param mainTotalSeats
     */
    public void setMainTotalSeats(String mainTotalSeats) {
        this.mainTotalSeats = mainTotalSeats;
    }

    /**
     * get Origin Airport Country
     * @return
     */
    public String getOriginAirportCountry() {
        return this.originAirportCountry;
    }

    /**
     * set Origin airport Country
     * @param originAirportCountry
     */
    public void setOriginAirportCountry(String originAirportCountry) {
        this.originAirportCountry = originAirportCountry;
    }

    /**
     * get Origin Airport Fee
     * @return
     */
    public String getOriginAirportFee() {
        return this.originAirportFee;
    }

    /**
     * set Origin Airport Fee
     * @param originAirportFee
     */
    public void setOriginAirportFee(String originAirportFee) {
        this.originAirportFee = originAirportFee;
    }

    /**
     * get Origin Airport Lounge
     * @return
     */
    public String getOriginAirportLounge() {
        return this.originAirportLounge;
    }

    /**
     * set Origin Airport Lounge
     * @param originAirportLounge
     */
    public void setOriginAirportLounge(String originAirportLounge) {
        this.originAirportLounge = originAirportLounge;
    }

    /**
     * get Destination Airport
     * @return
     */
    public String getDestinationAirportState() {
        return this.destinationAirportState;
    }

    /**
     * Set Destination Airport
     * @param destinationAirportState
     */
    public void setDestinationAirportState(String destinationAirportState) {
        this.destinationAirportState = destinationAirportState;
    }

    /**
     * get Destianation Airport City
     * @return
     */
    public String getDestinationAirportCity() {
        return this.destinationAirportCity;
    }

    /**
     * set Destination Airport City
     * @param destinationAirportCity
     */
    public void setDestinationAirportCity(String destinationAirportCity) {
        this.destinationAirportCity = destinationAirportCity;
    }

    /**
     * get Destination Airport Country
     * @return
     */
    public String getDestinationAirportCountry() {
        return this.destinationAirportCountry;
    }

    /**
     * set Destination Airport Country
     * @param destinationAirportCountry
     */
    public void setDestinationAirportCountry(String destinationAirportCountry) {
        this.destinationAirportCountry = destinationAirportCountry;
    }

    /**
     * get Destination Fee
     * @return
     */
    public String getDestinationAirportFee() {
        return this.destinationAirportFee;
    }

    /**
     * Set Airport Fee
     * @param destinationAirportFee
     */
    public void setDestinationAirportFee(String destinationAirportFee) {
        this.destinationAirportFee = destinationAirportFee;
    }

    /**
     * get Destination Lounge
     * @return
     */
    public String getDestinationAirportLounge() {
        return this.destinationAirportLounge;
    }

    /**
     * set Destination Lounge
     * @param destinationAirportLounge
     */
    public void setDestinationAirportLounge(String destinationAirportLounge) {
        this.destinationAirportLounge = destinationAirportLounge;
    }

    /**
     * get MinerAirliness Fee
     * @return
     */
    public double getMinerAirlinesFee() {
        return this.minerAirlinesFee;
    }

    /**
     * set Miner Airliness Fee
     * @param minerAirlinesFee
     */
    public void setMinerAirlinesFee(double minerAirlinesFee) {
        this.minerAirlinesFee = minerAirlinesFee;
    }

    /**
     * get Security Fee
     * @return
     */
    public double getSecurityFee() {
        return this.securityFee;
    }

    /**
     * get Security Fee
     * @param securityFee
     */
    public void setSecurityFee(double securityFee) {
        this.securityFee = securityFee;
    }

    /**
     * get if Flight is Valid
     * @return
     */
    public boolean getIsValidFlight() {
        return this.isValidFlight;
    }

    /**
     * Set if Flight is Valid
     * @param isValidFlight
     */
    public void setIsValidFlight(boolean isValidFlight) {
        this.isValidFlight = isValidFlight;
    }

    /**
     * set Hashmap with total collected per class
     * @param totalCollected
     */
    public void setTotalCollected(HashMap<String,Double> totalCollected) {
        this.totalCollected = totalCollected;
    }

    /**
     * print Flght seats information
     */
    public void printSeatsInfo()
    {
        System.out.println("1) First Class       --- "+"\t"+"Price: $"+this.firstPrice+"\t Available seats: "+this.firstSeats);
        System.out.println("2) Business Class    --- "+"\t"+"Price: $"+this.businessPrice+"\t Available seats: "+this.businessSeats);
        System.out.println("3) Main Cabin Class  --- "+"\t"+"Price: $"+this.mainPrice+"\t Available seats: "+this.mainSeats);
        this.transaction.printFeesAndTaxes();
        if(this.isInternational)
        {
            System.out.println("This is an International Flight, it has a Surcharge: $"+ this.surcharge);
        }
    }

    /**
     * print Flight Information
     */
    public void printFlight()
    {
        System.out.println("Flight ID: "+ this.id +"\nOrigin Airport: "+ this.originAirport+'\n'+"Origin Code: "+ this.originCode+'\n'+"Destination Airport: "+ this.destAirport+'\n'+
        "Destination Code: "+ this.destCode+'\n'+"Departure Date: "+this.depDate+'\n'+"Departure Time: "+this.depTime+'\n'+"Arrival Date: "+this.arrDate+'\n'+
        "Arrival Time: "+ this.arrTime+'\n'+"Duration: "+this.duration+'\n'+"Distance: "+this.distance+'\n'+"Time Zone: "+ this.timeZone+'\n'+"First Class Price: $"+this.firstPrice+'\n'+
        "Business Class Price: $"+this.businessPrice+'\n'+"Main Cabin Price: $"+this.mainPrice+'\n'+"First Class Seats: "+this.firstSeats+'\n'+"Business Class Seats: "+this.businessSeats+ '\n'+
        "Main Cabin Seats: "+ this.mainSeats +'\n'+"Total Seats: "+this.totalSeats+"\nFlight is not cancelled: "+isValidFlight);
    }

    /**
     * print Flight Information
     */
    public void printAirport()
    {
        System.out.println("ID: "+this.id+"\nOrigin Airport: "+ this.originAirport+'\n'+"Origin Code: "+ this.originCode+'\n'+"Destination Airport: "+ this.destAirport+'\n'+
        "Destination Code: "+ this.destCode+'\n'+"Departure Date: "+this.depDate+'\n'+"Departure Time: "+this.depTime+'\n'+"Arrival Date: "+this.arrDate+'\n'+
        "Arrival Time: "+ this.arrTime+'\n'+"Flight is not cancelled: "+isValidFlight+"\n");
    }


    /**
     * Cancel Flight
     */
    public void cancelFlight(){
        this.transaction.cancelFlight(this.id);
    }

    /**
     * Cancel Ticket for Flight
     * @param confirmation
     */
    public void cancelTicket(String confirmation){
        this.transaction.cancelTicket(confirmation);
    }

    /**
     * Create Ticket, Transacction, and add to List for Flight
     * @param type
     * @param quantity
     * @param customer
     * @return
     */
    public String createTicket(int type, int quantity, Person customer){
        String text = this.transaction.createTicket(type, quantity, customer, this.id);
        return text;
    }

    /**
     * get Taxes Collected
     * @return
     */
    public double getTaxesCollected(){
        return this.transaction.getTaxesCollected();
    }

}