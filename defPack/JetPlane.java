package defPack;

import java.util.HashMap;

/**
 * Created by aalokhin on 2/2/19.
 */
public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    protected JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String message = "JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n";
        Result.resultBuilder.append(message);
    }


    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, WeatherUpdateResult> weatherUpdateResult = new HashMap<String, WeatherUpdateResult>(){{
            put("SUN", new WeatherUpdateResult(0, 10, 2, "Sun is awesome. But I'm awesome even without it.\n"));
            put("RAIN", new WeatherUpdateResult(0, 5, 0, "Jetplane doesn't notice rain, it just flies by.\n"));
            put("FOG", new WeatherUpdateResult(0, 1, 0, "No fog can hide my awesomeness.\n"));
            put("SNOW", new WeatherUpdateResult(0, 0, -7, "I'M A JET PLANE FUCKAS, I DON'T CARE ABOUT SNOW\n"));

        }};
        String message =  "JetPlane#" + this.name + "(" + this.id + ") : " + weatherUpdateResult.get(weather).getMessage();
        int longt = this.coordinates.getLongitude() + weatherUpdateResult.get(weather).getAddLongitude();
        int lat = this.coordinates.getLatitude() + weatherUpdateResult.get(weather).getAddLatitude();
        int height = this.coordinates.getHeight() + weatherUpdateResult.get(weather).getAddHeight();
        if (height <= 0) {
            message = "JetPlane#" + this.name + "(" + id + ") is landing.\n";
            this.weatherTower.unregister(this);
            message += "JetPlane#" + this.name + "(" + id + ") unregistered from weather tower.\n";
        }
        else {
            this.coordinates.setNewCoordinates(longt, lat, height);
        }
        Result.resultBuilder.append(message);
    }
}
