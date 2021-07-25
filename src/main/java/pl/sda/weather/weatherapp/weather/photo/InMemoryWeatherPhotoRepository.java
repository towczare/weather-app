package pl.sda.weather.weatherapp.weather.photo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryWeatherPhotoRepository implements WeatherPhotoRepository {

    private static Map<Long, WeatherPhoto> weatherPhotos = new HashMap<>();

    static {
        weatherPhotos.put(1l, new WeatherPhoto("https://bi.im-g.pl/im/81/4d/16/z23387777Q,Wielka-ulewa-w-Lodzi.jpg", "Lodz"));
        weatherPhotos.put(2l, new WeatherPhoto("https://visitwroclaw.eu/files/news/wroclaw_panorama1_1.jpg", "Wroclaw"));
        weatherPhotos.put(3l, new WeatherPhoto("https://bi.im-g.pl/im/a5/8a/11/z18391717V,Pogoda-w-Warszawie--Burza.jpg", "Warsaw"));
        weatherPhotos.put(4l, new WeatherPhoto("https://lodz.travel/files/public/_processed_/1/7/csm_manufaktura_main_ad123a7317.png", "Lodz"));
    }

    @Override
    public WeatherPhoto getById(Long id) {
        return weatherPhotos.get(id);
    }

    @Override
    public List<WeatherPhoto> findByCity(String city) {
        return weatherPhotos.values()
                .stream()
                .filter(w -> w.getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public void save(WeatherPhoto photo) {
        weatherPhotos.put(weatherPhotos.size() + 1l, photo);
    }
}
