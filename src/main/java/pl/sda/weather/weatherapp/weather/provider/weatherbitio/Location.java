package pl.sda.weather.weatherapp.weather.provider.weatherbitio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private String city;
    private double lat;
    private double lon;

}
