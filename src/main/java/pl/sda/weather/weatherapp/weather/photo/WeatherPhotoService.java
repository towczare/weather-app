package pl.sda.weather.weatherapp.weather.photo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherPhotoService {

    private final WeatherPhotoRepository weatherPhotoRepository;
    private CloudinaryService cloudinaryService;

    public WeatherPhotoService(CloudinaryService cloudinaryService) {
        this.weatherPhotoRepository = new InMemoryWeatherPhotoRepository();
        this.cloudinaryService = cloudinaryService;
    }

    public List<WeatherPhoto> findByCity(String city) {
        return weatherPhotoRepository.findByCity(city);
    }

    public void save(WeatherPhoto photo) {
        String url = cloudinaryService.upload(photo.getImage());
        weatherPhotoRepository.save(photo.withUrl(url));
    }
}
