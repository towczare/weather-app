package pl.sda.weather.weatherapp.weather.goweather;


import org.junit.jupiter.api.Test;
import pl.sda.weather.weatherapp.weather.Weather;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GoWeatherProviderTest {

    @Test
    public void consume() {
        GoWeatherProvider goWeatherProvider = new GoWeatherProvider();

        Weather forecast = goWeatherProvider.forecast();
        assertNotNull(forecast);
    }

}
