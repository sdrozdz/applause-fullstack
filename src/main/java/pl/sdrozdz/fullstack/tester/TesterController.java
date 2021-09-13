package pl.sdrozdz.fullstack.tester;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdrozdz.fullstack.tester.dto.SearchCriteriaDto;
import pl.sdrozdz.fullstack.tester.dto.TesterDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tester")
public class TesterController {

  private final TesterService testerService;

  @PostMapping
  public List<TesterDto> getTesters(@RequestBody(required = false) Optional<SearchCriteriaDto> searchCriteriaDto) {
    return testerService.getTesters(searchCriteriaDto);
  }
}
