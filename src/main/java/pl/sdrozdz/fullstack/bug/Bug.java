package pl.sdrozdz.fullstack.bug;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import pl.sdrozdz.fullstack.device.Device;
import pl.sdrozdz.fullstack.tester.Tester;

import javax.persistence.*;

@Data
@Entity
@Table
public class Bug {
  @Id
  @CsvBindByName(column = "bugId")
  private Long id;

  @ManyToOne
  @JoinColumn
  private Device device;

  @ManyToOne
  @JoinColumn
  private Tester tester;
}
