package pl.sdrozdz.fullstack.tester

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import pl.sdrozdz.fullstack.tester.dto.SearchCriteriaDto
import spock.lang.Specification

import static org.hamcrest.Matchers.hasSize
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class TesterControllerIntegrationTest extends Specification {

  @Autowired
  private MockMvc mockMvc

  @Autowired
  private ObjectMapper objectMapper

  def "should return testers without criteria"() {
    given:
    def url = "/api/tester"

    when:
    def result = mockMvc.perform(post(url))
        .andDo(MockMvcResultHandlers.print())

    then:
    result
        .andExpect(status().isOk())
        .andExpect(jsonPath('$', hasSize(9)))
  }

  def "should find all testers"() {
    given:
    def url = "/api/tester"
    def criteria = SearchCriteriaDto.builder()
        .country(country)
        .device(device)
        .build()

    when:
    def result = mockMvc.perform(post(url)
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(criteria)))
        .andDo(MockMvcResultHandlers.print())

    then:
    result
        .andExpect(status().isOk())
        .andExpect(jsonPath('$', hasSize(testerCount)))
        .andExpect(jsonPath('$[0].experience').value(topExperience))

    where:
    country | device || testerCount || topExperience
    null    | null   || 9           || 125
    []      | []     || 9           || 125
    ['JP']  | []     || 3           || 117
    ['US']  | []     || 3           || 125

  }

}
