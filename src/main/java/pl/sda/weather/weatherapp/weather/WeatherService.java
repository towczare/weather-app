package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Service;
import pl.sda.weather.weatherapp.weather.goweather.GoWeatherProvider;

@Service
public class WeatherService {

    private final WeatherProvider weatherProvider;

    public WeatherService() {
        this.weatherProvider = new DummyWeatherProvider();
    }

    public Weather getWeather() {
        return weatherProvider.forecast();
    }

    public Weather getWeather(String city) {
        return weatherProvider.forecast(city);
    }
}