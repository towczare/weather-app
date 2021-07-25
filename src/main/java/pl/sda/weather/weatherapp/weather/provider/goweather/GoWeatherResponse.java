package pl.sda.weather.weatherapp.weather.provider.goweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoWeatherResponse implements Serializable {

    String temperature;

    public double getTemperatureFormatted() {
        return Double.valueOf(temperature.split(" ")[0].replace("+", ""));
    }
}

// {"temperature":"+24 °C","wind":"0 km/h","description":"Sunny",
// "forecast":[
//  {"day":"1","temperature":"+24 °C","wind":"10 km/h"},
//  {"day":"2","temperature":"27 °C","wind":"18 km/h"},
//  {"day":"3","temperature":"26 °C","wind":"7 km/h"}
//  ]}