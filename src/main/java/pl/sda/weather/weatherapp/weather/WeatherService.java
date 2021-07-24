package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherProvider weatherProvider;

    public WeatherService() {
        this.weatherProvider = new DummyWeatherProvider();
    }

    public Weather getWeather() {
        return weatherProvider.forecast();
    }
}