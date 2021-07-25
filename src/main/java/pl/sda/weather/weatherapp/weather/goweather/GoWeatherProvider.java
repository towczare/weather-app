package pl.sda.weather.weatherapp.weather.goweather;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.sda.weather.weatherapp.weather.Weather;
import pl.sda.weather.weatherapp.weather.WeatherProvider;

public class GoWeatherProvider implements WeatherProvider {

    RestTemplate restTemplate = new RestTemplate();

    private String GO_WEATHER_BASE_PATH = "https://goweather.herokuapp.com/weather/";

    @Override
    public Weather forecast() {
        return getWeather("Lodz");
    }

    @Override
    public Weather forecast(String city) {
        return getWeather(city);
    }

    private Weather getWeather(String city) {
        String fooResourceUrl
                = GO_WEATHER_BASE_PATH + city;
        ResponseEntity<GoWeatherResponse> response
                = restTemplate.getForEntity(fooResourceUrl, GoWeatherResponse.class);

        return new Weather(response.getBody().getTemperatureFormatted());
    }
}
