package pl.sdrozdz.fullstack.commons;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

  private final List<Fixture> fixtures;

  @PostConstruct
  public void load() {
    fixtures.forEach(Fixture::load);
  }

}
