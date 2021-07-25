package pl.sda.weather.weatherapp.weather;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.weather.weatherapp.weather.photo.InMemoryWeatherPhotoRepository;
import pl.sda.weather.weatherapp.weather.photo.WeatherPhoto;
import pl.sda.weather.weatherapp.weather.photo.WeatherPhotoRepository;
import pl.sda.weather.weatherapp.weather.photo.WeatherPhotoService;
import pl.sda.weather.weatherapp.weather.provider.DummyWeatherProvider;
import pl.sda.weather.weatherapp.weather.provider.WeatherProvider;
import pl.sda.weather.weatherapp.weather.provider.weatherbitio.WeatherbitioProvider;

import java.util.List;

@Service
@Slf4j
public class WeatherService {

    private final WeatherProvider weatherProvider;
    private final WeatherPhotoService weatherPhotoService;

    public WeatherService(WeatherProvider weatherProvider, WeatherPhotoService weatherPhotoService) {
        this.weatherPhotoService = weatherPhotoService;
        this.weatherProvider = weatherProvider;
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