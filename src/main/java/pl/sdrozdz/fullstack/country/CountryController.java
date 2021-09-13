package pl.sdrozdz.fullstack.country;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

  private final CountryService countryService;

  @GetMapping
  public List<String> getCountries() {
    return countryService.getCountries();
  }
}
