package pl.sda.weather.weatherapp.weather.provider.weatherbitio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherBitIoResponse implements Serializable {

    double temp;
//    Date datetime;
}
