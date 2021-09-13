package pl.sdrozdz.fullstack.tester.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TesterDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String country;
  private LocalDateTime lastLogin;
  private Long experience;
}
