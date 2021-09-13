package pl.sdrozdz.fullstack.device;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/device")
public class DeviceController {
  private final DeviceService deviceService;

  @GetMapping
  public List<Device> getDevices(@SortDefault(sort = "description") Sort sort) {
    return deviceService.getDevices(sort);
  }
}
