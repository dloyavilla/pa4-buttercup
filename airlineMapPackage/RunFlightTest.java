package airlineMapPackage;
import static org.junit.Assert.*;
import org.junit.Test;

public class RunFlightTest {

    /**
     * TEST flight getters
     */
    @Test 
    public void testFlightGetters()
    { // test flight setters and getters
        International flight = new International();
        flight.setId("TEX");
        String name = flight.getId();
        assertEquals(name, "TEX");
    }

    /**
     * TEST Customer getters
     */
      @Test
    public void testCustomerGetters()
    { // test to retrun key from customers map
        Customer customer = new Customer();
        customer.setMoneyAvailable("10000");
        boolean test = customer.availableMoney(12);
        assertEquals(true, test);
    }

    /**
     * TEST method to check if password is valid
     */
    @Test
    public void testIsValidPassword() 
    { // test to check if password is in map
        boolean test = RunFlight.isValidPassword("Fun");
        assertEquals(false, test);
    }

    /**
     * TEST method to see if valid user
     */
    @Test
    public void testIsValidUser() 
    { // test to see if user is in map
        boolean test = RunFlight.isValidUser("bellenickelodeon");
        assertEquals(false, test);
    }

    /**
     * TEST Ticket Class getters
     */
    @Test
    public void testTicketClass() 
    { // test to see flight type
       Ticket ticket = new Ticket();
       ticket.setConfirmation("1234");
       String type =  ticket.getConfirmation();
       assertEquals("1234", type);
    }
}
