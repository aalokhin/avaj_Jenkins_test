package defPack;

import java.util.HashMap;

/**
 * Created by aalokhin on 2/2/19.
 */
public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    protected Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions (){

        String weather = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, WeatherUpdateResult> weatherUpdateResult = new HashMap<String, WeatherUpdateResult>(){{
            put("SUN", new WeatherUpdateResult(2, 0, 4, "Guess who gooooes up-up-up!\n"));
            put("SNOW", new WeatherUpdateResult(0, 0, -15, "I am ready to freeze to death. Death of my passengers.\n"));
            put("RAIN", new WeatherUpdateResult(0, 0, -5, "Rain is good. And lightning is even better. Scary and epic and we'll all die here.\n"));
            put("FOG", new WeatherUpdateResult(0, 0, -3, "They paid for a view and pictures. Now they will see nothing.\n"));
        }};
        String message =  "Baloon#" + this.name + "(" + this.id + ") : " + weatherUpdateResult.get(weather).getMessage();
        int longt = this.coordinates.getLongitude() + weatherUpdateResult.get(weather).getAddLongitude();
        int lat = this.coordinates.getLatitude() + weatherUpdateResult.get(weather).getAddLatitude();
        int height = this.coordinates.getHeight() + weatherUpdateResult.get(weather).getAddHeight();
        if (height <= 0)
        {
            message = "Baloon#" + this.name + "(" + id + ") is landing.\n";
            this.weatherTower.unregister(this);
            message += "Baloon#" + this.name + "(" + id + ") unregistered from weather tower.\n";
        }
        else {
            this.coordinates.setNewCoordinates(longt, lat, height);
        }
        Result.resultBuilder.append(message);

    }
    public void registerTower(WeatherTower weatherTower, Coordinates coordinates) {
        this.weatherTower = weatherTower;
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String message = "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n";
        Result.resultBuilder.append(message);
    }
}
