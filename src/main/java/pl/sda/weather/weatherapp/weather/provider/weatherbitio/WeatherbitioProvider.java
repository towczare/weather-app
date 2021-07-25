package pl.sda.weather.weatherapp.weather.provider.weatherbitio;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.weather.weatherapp.weather.WeatherStats;
import pl.sda.weather.weatherapp.weather.provider.WeatherProvider;
import pl.sda.weather.weatherapp.weather.provider.goweather.GoWeatherResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherbitioProvider implements WeatherProvider {

    @Value("${weatherbitio.key}")
    private String weatherBitIoKey;

    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URL = "https://api.weatherbit.io/v2.0/forecast/daily?key=";

    private Map<String, Location> locations = new HashMap<>();

    @SneakyThrows
    public WeatherbitioProvider() {
        populateFromFile();
    }

    @SneakyThrows
    private void populateFromFile() throws FileNotFoundException {
        File file = new File(getClass().getClassLoader().getResource("cities.csv").getFile());

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line =  null;

        while((line=br.readLine())!=null) {
            String str[] = line.split(";");
            String city = str[2];
            locations.put(city, new Location(city, Double.valueOf(str[3]), Double.valueOf(str[4])));
        }
    }

    @Override
    public WeatherStats forecast(String city) {

        Location location = locations.get(city);

        String resourceUrl = BASE_URL + weatherBitIoKey + "&lat=" + location.getLat() + "&lon=" + location.getLon();
        ResponseEntity<WeatherBitIoListResponse> response
                = restTemplate.getForEntity(resourceUrl, WeatherBitIoListResponse.class);

        double temp = response.getBody().getData().get(0).getTemp();

        return new WeatherStats(temp);
    }
}
