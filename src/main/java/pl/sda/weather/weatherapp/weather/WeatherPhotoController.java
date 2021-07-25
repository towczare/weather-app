package pl.sda.weather.weatherapp.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/photos")
public class WeatherPhotoController {

    private final WeatherService weatherService;

    public WeatherPhotoController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping
    String form(Model model) {
        model.addAttribute("photo", new WeatherPhoto());
        return "add-photo";
    }

    @RequestMapping(method = RequestMethod.POST)
    String addPhoto(@ModelAttribute WeatherPhoto photo) {
        weatherService.addWeatherPhoto(photo);
        return "redirect:/?city=" + photo.getCity();
    }

}
