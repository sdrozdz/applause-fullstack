package pl.sdrozdz.fullstack.commons.csv.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvTesterDeviceDto {
  @CsvBindByName
  private String testerId;
  @CsvBindByName
  private String deviceId;
}
