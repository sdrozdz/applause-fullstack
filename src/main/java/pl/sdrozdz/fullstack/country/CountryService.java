package pl.sdrozdz.fullstack.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdrozdz.fullstack.tester.TesterRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
  private final TesterRepository testerRepository;

  public List<String> getCountries() {
    return testerRepository.findDistinctCountries();
  }
}
