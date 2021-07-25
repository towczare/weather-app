package pl.sda.weather.weatherapp.weather.provider.goweather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.sda.weather.weatherapp.weather.WeatherStats;
import pl.sda.weather.weatherapp.weather.provider.WeatherProvider;

public class GoWeatherProvider implements WeatherProvider {

    @Autowired
    RestTemplate restTemplate;

    private String GO_WEATHER_BASE_PATH = "https://goweather.herokuapp.com/weather/";

    @Override
    public WeatherStats forecast(String city) {
        return getWeather(city);
    }

    private WeatherStats getWeather(String city) {
        String fooResourceUrl
                = GO_WEATHER_BASE_PATH + city;
        ResponseEntity<GoWeatherResponse> response
                = restTemplate.getForEntity(fooResourceUrl, GoWeatherResponse.class);

        return new WeatherStats(response.getBody().getTemperatureFormatted());
    }
}
