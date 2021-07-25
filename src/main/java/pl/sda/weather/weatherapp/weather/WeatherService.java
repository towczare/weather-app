package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Service;
import pl.sda.weather.weatherapp.weather.photo.InMemoryWeatherPhotoRepository;
import pl.sda.weather.weatherapp.weather.photo.WeatherPhoto;
import pl.sda.weather.weatherapp.weather.photo.WeatherPhotoRepository;
import pl.sda.weather.weatherapp.weather.photo.WeatherPhotoService;
import pl.sda.weather.weatherapp.weather.provider.DummyWeatherProvider;
import pl.sda.weather.weatherapp.weather.provider.WeatherProvider;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherProvider weatherProvider;
    private final WeatherPhotoService weatherPhotoService;

    public WeatherService(WeatherPhotoService weatherPhotoService) {
        this.weatherPhotoService = weatherPhotoService;
        this.weatherProvider = new DummyWeatherProvider();
    }

    public Weather getWeather() {
        String defaultCity = "Lodz";
        WeatherStats stats = weatherProvider.forecast();
        List<WeatherPhoto> photos = weatherPhotoService.findByCity(defaultCity);

        return new Weather(defaultCity, stats, photos);
    }

    public Weather getWeather(String city) {
        WeatherStats stats = weatherProvider.forecast(city);
        List<WeatherPhoto> photos = weatherPhotoService.findByCity(city);

        return new Weather(city, stats, photos);
    }

    public void addWeatherPhoto(WeatherPhoto photo) {
        weatherPhotoService.save(photo);
    }
}