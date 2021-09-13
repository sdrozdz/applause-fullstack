package pl.sdrozdz.fullstack.bug;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.sdrozdz.fullstack.commons.ApplicationConstants;
import pl.sdrozdz.fullstack.commons.Fixture;
import pl.sdrozdz.fullstack.commons.csv.CsvService;
import pl.sdrozdz.fullstack.commons.csv.dto.CsvBugDto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@Order(2)
@Component
@Transactional
@RequiredArgsConstructor
public class BugFixture implements Fixture {

  private final EntityManager entityManager;
  private final CsvService csvService;

  @Override
  public void load() {
    log.info("Load bug fixture");
    csvService.stream(ApplicationConstants.BUGS_CSV, CsvBugDto.class).forEach(it ->
        entityManager.createNativeQuery("INSERT INTO BUG (ID, DEVICE_ID, TESTER_ID) VALUES (?, ?, ?)")
            .setParameter(1, it.getBugId())
            .setParameter(2, it.getDeviceId())
            .setParameter(3, it.getTesterId())
            .executeUpdate()
    );
  }
}
