package pl.sda.weather.weatherapp.weather;

public interface WeatherProvider {
    Weather forecast();
    Weather forecast(String city);
}
