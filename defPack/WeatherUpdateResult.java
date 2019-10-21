package defPack;

public class WeatherUpdateResult {

    public int addLongitude;
    public int addLatitude;
    public int addHeight;
    public String message;

        public WeatherUpdateResult(int addLongitude, int addLatitude, int addHeight, String message) {
            this.addLongitude = addLongitude;
            this.addLatitude = addLatitude;
            this.addHeight = addHeight;
            this.message = message;
        }

        public int getAddLongitude() {
            return addLongitude;
        }

        public int getAddLatitude() {
            return addLatitude;
        }

        public int getAddHeight() {
            return addHeight;
        }

        public String getMessage() {
            return message;
        }

}
