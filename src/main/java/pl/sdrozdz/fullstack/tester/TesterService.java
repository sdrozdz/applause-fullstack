package pl.sdrozdz.fullstack.tester;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdrozdz.fullstack.tester.dto.SearchCriteriaDto;
import pl.sdrozdz.fullstack.tester.dto.TesterDto;
import pl.sdrozdz.fullstack.tester.dto.TesterExperienceProjection;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class TesterService {

  private final TesterRepository testerRepository;

  public List<TesterDto> getTesters(Optional<SearchCriteriaDto> criteria) {
    List<Long> deviceIds = criteria.map(SearchCriteriaDto::getDevice).orElse(null);
    List<String> countries = criteria.map(SearchCriteriaDto::getCountry).orElse(null);
    return testerRepository
        .findByDevicesInAndCountryInOrderByExperienceDesc(deviceIds, countries)
        .stream()
        .map(this::convertToDto)
        .collect(toList());
  }

  private TesterDto convertToDto(TesterExperienceProjection projection) {
    final Tester tester = projection.getTester();
    return TesterDto.builder()
        .id(tester.getId())
        .firstName(tester.getFirstName())
        .lastName(tester.getLastName())
        .lastLogin(tester.getLastLogin())
        .country(tester.getCountry())
        .experience(projection.getExperience())
        .build();
  }
}
