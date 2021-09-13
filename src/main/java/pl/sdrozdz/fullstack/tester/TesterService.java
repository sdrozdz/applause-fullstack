package pl.sdrozdz.fullstack.tester;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdrozdz.fullstack.tester.dto.SearchCriteriaDto;
import pl.sdrozdz.fullstack.tester.dto.TesterDto;
import pl.sdrozdz.fullstack.tester.dto.TesterExperienceProjection;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class TesterService {

  private final TesterRepository testerRepository;

  public List<TesterDto> getTesters(SearchCriteriaDto searchCriteriaDto) {
    List<Long> deviceIds = searchCriteriaDto.getDevice();
    List<String> countries = searchCriteriaDto.getCountry();
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
