package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping()
    public String index(@RequestParam(required = false) String city, Model model){
        model.addAttribute("weather", weatherService.getWeather(city));

        return "index";
    }
}
