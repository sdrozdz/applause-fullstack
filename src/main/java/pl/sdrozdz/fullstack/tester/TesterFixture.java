package pl.sdrozdz.fullstack.tester;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.sdrozdz.fullstack.commons.ApplicationConstants;
import pl.sdrozdz.fullstack.commons.Fixture;
import pl.sdrozdz.fullstack.commons.csv.CsvService;
import pl.sdrozdz.fullstack.commons.csv.dto.CsvTesterDeviceDto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Slf4j
@Order(1)
@Component
@Transactional
@RequiredArgsConstructor
public class TesterFixture implements Fixture {

  private final CsvService csvService;
  private final TesterRepository testerRepository;
  private final EntityManager entityManager;

  @Override
  public void load() {
    log.info("Load tester fixture");
    testerRepository.saveAll(csvService.stream(ApplicationConstants.TESTERS_CSV, Tester.class).collect(Collectors.toList()));

    csvService.stream(ApplicationConstants.TESTER_DEVICES, CsvTesterDeviceDto.class).forEach(it ->
        entityManager.createNativeQuery("INSERT INTO TESTER_DEVICES (TESTER_ID, DEVICES_ID) VALUES (?, ?)")
            .setParameter(1, it.getTesterId())
            .setParameter(2, it.getDeviceId())
            .executeUpdate()
    );
  }
}
