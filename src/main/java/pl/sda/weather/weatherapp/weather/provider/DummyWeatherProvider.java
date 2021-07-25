package pl.sda.weather.weatherapp.weather.provider;

import pl.sda.weather.weatherapp.weather.WeatherStats;

import java.util.HashMap;
import java.util.Map;

public class DummyWeatherProvider implements WeatherProvider {

    private static Map<String, WeatherStats> weathers = new HashMap<>();

    static {
        weathers.put("Lodz", new WeatherStats(25.0));
        weathers.put("Warsaw", new WeatherStats(15.0));
        weathers.put("London", new WeatherStats(17.0));
        weathers.put("Berlin", new WeatherStats(18.0));
        weathers.put("Madryt", new WeatherStats(34.0));
    }

    @Override
    public WeatherStats forecast(String city) {
        return weathers.getOrDefault(city, new WeatherStats(-100.0));
    }
}
