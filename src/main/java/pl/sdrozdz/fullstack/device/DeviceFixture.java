package pl.sdrozdz.fullstack.device;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.sdrozdz.fullstack.commons.ApplicationConstants;
import pl.sdrozdz.fullstack.commons.Fixture;
import pl.sdrozdz.fullstack.commons.csv.CsvService;

import javax.transaction.Transactional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Order(0)
@Component
@Transactional
@RequiredArgsConstructor
public class DeviceFixture implements Fixture {
  private final CsvService csvService;
  private final DeviceRepository deviceRepository;

  @Override
  public void load() {
    log.info("Load device fixture");
    deviceRepository.saveAll(csvService.stream(ApplicationConstants.DEVICES_CSV, Device.class).collect(toList()));
  }
}
