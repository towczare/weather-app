package pl.sda.weather.weatherapp.weather.provider;

import pl.sda.weather.weatherapp.weather.WeatherStats;

public interface WeatherProvider {
    WeatherStats forecast();
    WeatherStats forecast(String city);
}
