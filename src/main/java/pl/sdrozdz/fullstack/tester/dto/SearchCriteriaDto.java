package pl.sdrozdz.fullstack.tester.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@AllArgsConstructor
public class SearchCriteriaDto {
  private List<String> country;
  private List<Long> device;

  public List<String> getCountry() {
    return country != null && !country.isEmpty() ? country : null;
  }

  public List<Long> getDevice() {
    return device != null && !device.isEmpty() ? device : null;
  }
}
