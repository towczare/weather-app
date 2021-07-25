package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Service;
import pl.sda.weather.weatherapp.weather.provider.DummyWeatherProvider;
import pl.sda.weather.weatherapp.weather.provider.WeatherProvider;

import java.util.Collections;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherProvider weatherProvider;
    private final WeatherPhotoRepository weatherPhotoRepository;

    public WeatherService() {
        this.weatherPhotoRepository = new InMemoryWeatherPhotoRepository();
        this.weatherProvider = new DummyWeatherProvider();
    }

    public Weather getWeather() {
        String defaultCity = "Lodz";
        WeatherStats stats = weatherProvider.forecast();
        List<WeatherPhoto> photos = weatherPhotoRepository.findByCity(defaultCity);

        return new Weather(defaultCity, stats, photos);
    }

    public Weather getWeather(String city) {
        WeatherStats stats = weatherProvider.forecast(city);
        List<WeatherPhoto> photos = weatherPhotoRepository.findByCity(city);

        return new Weather(city, stats, photos);
    }

    public void addWeatherPhoto(WeatherPhoto photo) {
        weatherPhotoRepository.save(photo);
    }
}