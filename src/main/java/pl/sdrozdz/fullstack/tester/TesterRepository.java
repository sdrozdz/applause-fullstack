package pl.sdrozdz.fullstack.tester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sdrozdz.fullstack.tester.dto.TesterExperienceProjection;

import java.util.List;

public interface TesterRepository extends JpaRepository<Tester, Long> {

  @Query("select distinct country FROM Tester order by country asc")
  List<String> findDistinctCountries();

  @Query("select t as tester, count(distinct b.id) as experience from Tester t " +
      "join t.devices d " +
      "left join Bug b on b.tester = t and b.device = d " +
      "where (:deviceIds is null or d.id in :deviceIds) and (:countries is null or t.country in :countries) " +
      "group by t " +
      "order by experience desc ")
  List<TesterExperienceProjection> findByDevicesInAndCountryInOrderByExperienceDesc(
      @Param("deviceIds") List<Long> deviceIds,
      @Param("countries") List<String> countries
  );
}
