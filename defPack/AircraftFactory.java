package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */


public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable Aircraft = type.equals("baloon") ? new Baloon(name, coordinates) : (type.equals("helicopter") ? new Helicopter(name, coordinates) : (type.equals("jetplane") ? new JetPlane(name, coordinates) : null));
        return Aircraft;
    }
}
