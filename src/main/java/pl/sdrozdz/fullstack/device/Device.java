package pl.sdrozdz.fullstack.device;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import pl.sdrozdz.fullstack.bug.Bug;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table
public class Device {
  @Id
  @CsvBindByName(column = "deviceId")
  private Long id;

  @CsvBindByName
  private String description;

  @JsonIgnore
  @OneToMany(mappedBy = "device")
  private List<Bug> bugs;
}
