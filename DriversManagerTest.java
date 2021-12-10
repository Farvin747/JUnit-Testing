
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class DriversManagerTest
{

    private final DriversManager driversManager = new DriversManager();

    @Before
    public void setup(){
        driversManager.addPassenger( new Passenger( "Carlos", "44234", 100 ) );
        driversManager.addPassenger( new Passenger( "Elise", "533434", 100 ) );
        driversManager.addPassenger( new Passenger( "Ian", "5343433", 100 ) );
        driversManager.addPassenger( new Passenger( "Debbie", "44555521", 100 ) );
        driversManager.addPassenger( new Passenger( "Cleon", "559988", 100 ) );
        driversManager.addPassenger( new Passenger( "Santiago", "1203123", 100 ) );

        driversManager.addDriver( new Driver( "Emilio", "1234990", 10f ) );
        driversManager.addDriver( new Driver( "Pedro", "12312440", 12f ) );
        driversManager.addDriver( new Driver( "Constanza", "9824990", 11f ) );
    }

    @Test
    public void verifyDriverAddedCorrectly(){
		Assert.assertEquals(driversManager.getDriver("1234990").getName(), "Emilio");
		Assert.assertEquals(driversManager.getDriver("12312440").getName(), "Pedro");
		Assert.assertEquals(driversManager.getDriver("9824990").getName(), "Constanza");
    }

    @Test
    public void verifyPassengerAddedCorrectly(){
		Assert.assertEquals(driversManager.getPassenger("44234").getName(), "Carlos");
		Assert.assertEquals(driversManager.getPassenger("533434").getName(), "Elise");
		Assert.assertEquals(driversManager.getPassenger("5343433").getName(), "Ian");
    }
    
    @Test
    public void startTripTest(){
        driversManager.startTrip("44234","9824990");
        boolean checkTrip = false;
        if(driversManager.getDriver("9824990").isAvailable() == false && driversManager.getPassenger("44234").isOnTrip() == true)
        {
            checkTrip = true;
        }
        Assert.assertTrue("Trip not Started..!",checkTrip);
    }

    @Test
    public void endTripTest(){
        driversManager.endTrip("44234","1234990");
        boolean checkEndTrip = false;
        if(driversManager.getDriver("1234990").getBalance() >= 10f && driversManager.getPassenger("44234").getBalance() < 100)
        {
            checkEndTrip = true;
        }
        Assert.assertTrue("Trip not Ended..!",checkEndTrip);
    }

    @Test
    public void nextAvailableDriverTest(){
        driversManager.endTrip("44234","9824990");
        String availableDriver = driversManager.findNextAvailableDriver();
        Assert.assertEquals("9824990" , availableDriver);

    }
}
