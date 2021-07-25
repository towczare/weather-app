package pl.sda.weather.weatherapp.weather.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherPhoto {

    private String url;
    private String city;
    private MultipartFile image;

    public WeatherPhoto(String url, String city) {
        this.url = url;
        this.city = city;
    }

    public WeatherPhoto withUrl(String url) {
        setUrl(url);
        setImage(null);
        return this;
    }
}
