package pl.sda.weather.weatherapp.weather;

public class DummyWeatherProvider implements WeatherProvider {
    @Override
    public Weather forecast() {
        return new Weather(25.0);
    }
}
