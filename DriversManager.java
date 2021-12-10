import java.util.*;

public class DriversManager
{
    private final HashMap<String, Passenger> passengersMap = new HashMap<>();

    private final HashMap<String, Driver> driversMap = new HashMap<>();

    public void addPassenger( Passenger passenger )
    {
        passengersMap.put( passenger.getId(), passenger );
    }

    public void addDriver( Driver driver )
    {
        driversMap.put( driver.getId(), driver );
    }

    public Driver getDriver( String driverId )
    {
        return driversMap.getOrDefault( driverId, null );
    }

    public Passenger getPassenger( String passengerId )
    {
        return passengersMap.getOrDefault( passengerId, null );
    }

    public void startTrip( String passengerId, String driverId )
    {
        if ( passengersMap.containsKey( passengerId ) && driversMap.containsKey( driverId ) )
        {
            Passenger passenger = passengersMap.get( passengerId );
            passenger.startTrip();
            Driver driver = driversMap.get( driverId );
            driver.startTrip();
        }
    }

    public void endTrip( String passengerId, String driverId )
    {
        if ( passengersMap.containsKey( passengerId ) && driversMap.containsKey( driverId ) )
        {
            Driver driver = driversMap.get( driverId );
            driver.endTrip();
            Passenger passenger = passengersMap.get( passengerId );
            passenger.endTrip( driver.getFee() );
        }
    }

    public String findNextAvailableDriver()
    {
        for(Driver driver : driversMap.values())
        {
            // System.out.println(driver);
            // System.out.println(driversMap.values());
            if(driver.isAvailable() == true)
            {
                return driver.getId();
            }
        }
        return "Not Available";
    }
}
