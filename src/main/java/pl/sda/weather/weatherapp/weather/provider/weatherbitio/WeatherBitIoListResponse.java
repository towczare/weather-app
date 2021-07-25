package pl.sda.weather.weatherapp.weather.provider.weatherbitio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherBitIoListResponse implements Serializable {

    List<WeatherBitIoResponse> data;
}
