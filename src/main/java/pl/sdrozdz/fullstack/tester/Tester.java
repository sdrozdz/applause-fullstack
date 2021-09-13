package pl.sdrozdz.fullstack.tester;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Data;
import pl.sdrozdz.fullstack.bug.Bug;
import pl.sdrozdz.fullstack.device.Device;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
public class Tester {
  @Id
  @CsvBindByName(column = "testerId")
  private Long id;

  @CsvBindByName
  private String firstName;

  @CsvBindByName
  private String lastName;

  @CsvBindByName
  private String country;

  @CsvDate("yyyy-MM-dd HH:mm:ss")
  @CsvBindByName
  private LocalDateTime lastLogin;

  @JsonIgnore
  @ManyToMany
  @JoinTable
  private List<Device> devices;

  @JsonIgnore
  @OneToMany(mappedBy = "tester")
  private List<Bug> bugs;
}
