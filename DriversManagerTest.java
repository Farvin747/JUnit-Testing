
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
    public void Passenger(){
        Passenger firstPassenger = driversManager.getPassenger("44234");
        boolean checkObj = false;
        if("Carlos" == firstPassenger.getName() && "44234" == firstPassenger.getId() && 100 == firstPassenger.getBalance())
        {
            checkObj = true;
        }
        Assert.assertTrue("Passenger is Not added..!",checkObj);
        // Assert.assertEquals("Carlos",driversManager.getPassenger("44234").getName());
        // Assert.assertEquals("44234",driversManager.getPassenger("44234").getId());
        // Assert.assertEquals(100 ,driversManager.getPassenger("44234").getBalance());

    }
    @Test
    public void Driver(){
        Driver firstDriver = driversManager.getDriver("1234990");
        boolean checkObj = false;
        if("Emilio" == firstDriver.getName() && "1234990" == firstDriver.getId() && 10f == firstDriver.getFee())
        {
            checkObj = true;
        }
        Assert.assertTrue("Driver is Not added..!",checkObj);


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
