package io.codescan.sarif.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codescan.sarif.encoding.SarifJsonSerializer;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SarifLogTests {

  @Test
  public void GivenNoData_WhenSerialized_ThenSchemaAndVersionPresent() throws IOException {
    var tool =
        Tool.builder().setDriver(ToolComponent.builder().setName("testdriver").build()).build();
    var runs = List.of(Run.builder().setTool(tool).build());
    var sarif = SarifLog.builder().setRuns(runs).build();

    assertEquals("2.1.0", sarif.version());
    assertEquals(
        "https://raw.githubusercontent.com/oasis-tcs/sarif-spec/master/Schemata/sarif-schema-2.1.0.json",
        sarif.schema());

    var mapper = new ObjectMapper();
    JsonNode expected =
        mapper.readTree(
            new StringBuilder()
                .append(
                    "{\"$schema\": \"https://raw.githubusercontent.com/oasis-tcs/sarif-spec/master/Schemata/sarif-schema-2.1.0.json\",")
                .append("\"version\": \"2.1.0\",")
                .append("\"runs\":[")
                .append("{\"tool\": {\"driver\": {\"name\": \"testdriver\"}}}")
                .append("]}")
                .toString());

    assertEquals(expected, mapper.readTree(SarifJsonSerializer.toJson(sarif)));
  }
}
