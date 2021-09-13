package pl.sdrozdz.fullstack.commons.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
@Service
public class CsvService {

  @SneakyThrows
  public <T> Stream<T> stream(String filePath, Class<T> type) {
    HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
    strategy.setType(type);
    return new CsvToBeanBuilder<T>(Files.newBufferedReader(Paths.get(filePath)))
        .withMappingStrategy(strategy)
        .withIgnoreEmptyLine(true)
        .build().stream();
  }
}
