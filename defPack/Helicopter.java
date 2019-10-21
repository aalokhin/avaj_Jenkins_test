package defPack;
import java.util.HashMap;
/**
 * Created by aalokhin on 2/2/19.
 */

public class Helicopter extends Aircraft implements Flyable
{

    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        HashMap<String, WeatherUpdateResult> weatherUpdateResult = new HashMap<String, WeatherUpdateResult>(){{
            put("SUN", new WeatherUpdateResult(10, 0, 2, "Bloody sun burns my eyes out but I'm ascending and going higher.\n"));
            put("SNOW", new WeatherUpdateResult(0, 0, -12, "Snow, no way. It's global warming, snow should seize to exist.\n"));
            put("RAIN", new WeatherUpdateResult(5, 0, 0, "Thrill is gone and rain is not. It's unfair...\n"));
            put("FOG", new WeatherUpdateResult(1, 0, 0, "Fogggg... I feel like I'm British. Couple more miles and I'll start making black jokes noone understands.\n"));
        }};

        String message =  "Helicoopter#" + this.name + "(" + this.id + ") : " + weatherUpdateResult.get(weather).getMessage();
        int longt = this.coordinates.getLongitude() + weatherUpdateResult.get(weather).getAddLongitude();
        int lat = this.coordinates.getLatitude() + weatherUpdateResult.get(weather).getAddLatitude();
        int height = this.coordinates.getHeight() + weatherUpdateResult.get(weather).getAddHeight();
        if (height <= 0)
        {
            message = "Helicoopter#" + this.name + "(" + id + ") is landing.\n";
            this.weatherTower.unregister(this);
            message += "Helicoopter#" + this.name + "(" + id + ") unregistered from weather tower.\n";
        }
        else {
            this.coordinates.setNewCoordinates(longt, lat, height);
        }
        Result.resultBuilder.append(message);

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String message = "Helicoopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n";
        Result.resultBuilder.append(message);
    }
}
