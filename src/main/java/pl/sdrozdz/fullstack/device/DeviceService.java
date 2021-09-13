package pl.sdrozdz.fullstack.device;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
  private final DeviceRepository deviceRepository;

  public List<Device> getDevices(Sort sort) {
    return deviceRepository.findAll(sort);
  }
}
