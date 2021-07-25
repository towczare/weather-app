package pl.sda.weather.weatherapp.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sda.weather.weatherapp.weather.photo.WeatherPhoto;

import java.util.List;

@Data
@AllArgsConstructor
public class Weather {

    private String city;
    private WeatherStats stats;
    private List<WeatherPhoto> photos;

}
