package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Service;
import pl.sda.weather.weatherapp.weather.provider.DummyWeatherProvider;
import pl.sda.weather.weatherapp.weather.provider.WeatherProvider;

import java.util.Collections;

@Service
public class WeatherService {

    private final WeatherProvider weatherProvider;

    public WeatherService() {
        this.weatherProvider = new DummyWeatherProvider();
    }

    public Weather getWeather() {
        WeatherStats stats = weatherProvider.forecast();

        return new Weather("Lodz", stats, Collections.emptyList());
    }

    public Weather getWeather(String city) {
        WeatherStats stats = weatherProvider.forecast(city);

        return new Weather(city, stats, Collections.emptyList());
    }
}