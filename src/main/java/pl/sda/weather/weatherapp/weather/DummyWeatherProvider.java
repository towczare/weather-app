package pl.sda.weather.weatherapp.weather;

import java.util.HashMap;
import java.util.Map;

public class DummyWeatherProvider implements WeatherProvider {

    private static Map<String, Weather> weathers = new HashMap<>();

    static {
        weathers.put("Lodz", new Weather(25.0));
        weathers.put("Warsaw", new Weather(15.0));
        weathers.put("London", new Weather(17.0));
        weathers.put("Berlin", new Weather(18.0));
        weathers.put("Madryt", new Weather(34.0));
    }

    @Override
    public Weather forecast() {
        return new Weather(25.0);
    }

    @Override
    public Weather forecast(String city) {
        return weathers.getOrDefault(city, new Weather(-100.0));
    }
}
