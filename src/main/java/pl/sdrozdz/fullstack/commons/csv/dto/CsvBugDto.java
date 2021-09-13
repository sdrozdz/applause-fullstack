package pl.sdrozdz.fullstack.commons.csv.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvBugDto {
  @CsvBindByName
  private Long bugId;
  @CsvBindByName
  private Long deviceId;
  @CsvBindByName
  private Long testerId;
}
