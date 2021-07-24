package pl.sda.weather.weatherapp.weather.goweather;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.sda.weather.weatherapp.weather.Weather;
import pl.sda.weather.weatherapp.weather.WeatherProvider;

public class GoWeatherProvider implements WeatherProvider {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Weather forecast() {

        String fooResourceUrl
                = "https://goweather.herokuapp.com/weather/Lodz";
        ResponseEntity<GoWeatherResponse> response
                = restTemplate.getForEntity(fooResourceUrl, GoWeatherResponse.class);

        return new Weather(response.getBody().getTemperatureFormatted());
    }
}
