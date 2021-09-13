package pl.sdrozdz.fullstack.tester.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchCriteriaDto {
  private List<String> country;
  private List<Long> device;
}
