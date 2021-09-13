package pl.sdrozdz.fullstack.country

import pl.sdrozdz.fullstack.tester.TesterRepository
import spock.lang.Specification
import spock.lang.Subject

class CountryServiceTest extends Specification {

  def repository = Mock(TesterRepository)

  @Subject
  def service = new CountryService(repository)

  def "should return tester countries"() {
    given:
    def countries = ["PL", "EN"]

    when:
    def result = service.getCountries()

    then:
    1 * repository.findDistinctCountries() >> countries
    result == countries
  }
}
