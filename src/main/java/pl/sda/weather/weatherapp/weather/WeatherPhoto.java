package pl.sda.weather.weatherapp.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherPhoto {

    private String url;
    private String city;
}
