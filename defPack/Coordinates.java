package defPack;

/**
 * Created by aalokhin on 2/2/19.
 */
public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = (height >= 100 ? 100 : (height <= 0 ? 0 : height));
    }

    public int getLongitude()
    {
        return this.longitude;
    }
    public int getLatitude()
    {
        return this.latitude;
    }
    public int getHeight()
    {
        return this.height;
    }

    public void setNewCoordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = (height >= 100 ? 100 : (height <= 0 ? 0 : height));
    }
}
