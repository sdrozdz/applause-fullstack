package pl.sdrozdz.fullstack.tester;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdrozdz.fullstack.tester.dto.SearchCriteriaDto;
import pl.sdrozdz.fullstack.tester.dto.TesterDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tester")
public class TesterController {

  private final TesterService testerService;

  @GetMapping
  public List<TesterDto> getTesters(@ModelAttribute SearchCriteriaDto searchCriteriaDto) {
    return testerService.getTesters(searchCriteriaDto);
  }
}
