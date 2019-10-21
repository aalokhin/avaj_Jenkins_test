package defPack;
import java.util.Random;
/**
 * Created by aalokhin on 2/2/19.
 */

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        String weather = this.weather[rand.nextInt(4)];
        return (weather);
    }
}