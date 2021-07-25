package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @ModelAttribute
    WeatherCriteria weatherCriteria() {
        return new WeatherCriteria();
    }

    @RequestMapping
    public String index(@ModelAttribute WeatherCriteria weatherCriteria, Model model){
        model.addAttribute("weather", weatherService.getWeather(weatherCriteria.getCity()));

        return "index";
    }
}
