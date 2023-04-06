package airlineMapPackage;
/**
 * @author Denisse_Loya
 * Airport class to store the information of each airport
 */

public class Airport
{
    private String name, city, state, country, fee, lounge, code;
    private double totalFees;

    /**
     * Constructor for Airport
     * @param code
     * @param name
     * @param city
     * @param state
     * @param country
     * @param fee
     * @param lounge
     */
    public Airport(String code, String name, String city, String state, String country, String fee, String lounge, double totalFees) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.fee = fee;
        this.lounge = lounge;
        this.totalFees = totalFees;
    }

    /**
     * Constructor for Airport
     */
    public Airport() {}

    /**
     * get Airport Name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * set Airport Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return
     */
    public double getTotalFees() {
        return this.totalFees;
    }

    /**
     * @param totalFees
     */
    public void setTotalFees(double totalFees) {
        this.totalFees += totalFees;
    }

    /**
     * get Airport City
     * @return
     */
    public String getCity() {
        return this.city;
    }

    /**
     * set Airport City
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get Airport State
     * @return
     */
    public String getState() {
        return this.state;
    }

    /**
     * Set Airport State
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * get Airport Country
     * @return
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Set Airport Country
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * get Airport fee
     * @return
     */
    public String getFee() {
        return this.fee;
    }

    /**
     * Set Airport fee
     * @param fee
     */
    public void setFee(String fee) {
        this.fee = fee;
    }

    /**
     * get airport lounge
     * @return
     */
    public String getLounge() {
        return this.lounge;
    }

    /**
     * set Airport Lounge
     * @param lounge
     */
    public void setLounge(String lounge) {
        this.lounge = lounge;
    }

    public void printAirportInformation(){
        System.out.println("Airport Information \n Code: "+this.code+"\n Name: "+this.name+"\n Location: "+this.city+", "+this.state+", "+this.country+"\n Fee: $"+this.fee+"\n Lounge Status: "+this.lounge+"\n Total Fees Collected: "+this.totalFees);
    }

}