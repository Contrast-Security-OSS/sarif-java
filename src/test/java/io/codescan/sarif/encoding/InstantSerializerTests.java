package io.codescan.sarif.encoding;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codescan.sarif.model.PropertyBag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstantSerializerTests {

    @Test
    public void GivenInstantInUTC_WhenSerialized_ThenIsISO8601Formatted() throws IOException {
        var instant = ZonedDateTime.parse("2018-09-16T08:00:00+00:00[UTC]").toInstant();
        check(instant, "2018-09-16T08:00:00Z");
    }

    @Test
    public void GivenInstantInNonUTC_WhenSerialized_ThenIsISO8601FormattedInUTC() throws IOException {
        var instant = ZonedDateTime.parse("2018-09-16T08:00:00+01:00[Europe/Paris]").toInstant();
        check(instant, "2018-09-16T07:00:00Z");
    }

    @Test
    public void GivenEmptyInstant_WhenSerialized_ThenIsISO8601FormattedInUTC() throws IOException {
        var instant = Instant.EPOCH;
        check(instant, "1970-01-01T00:00:00Z");
    }

    public void check(Instant given, String expected) throws IOException {
        var mapper = new ObjectMapper();
        var instantJson = SarifJsonSerializer.toJson(given);

        JsonNode actualJson = mapper.readTree("{\"test\" : " + instantJson + "}");
        JsonNode expectedJson = mapper.readTree(new StringBuilder()
                .append("{")
                .append("\"test\": \"" + expected + "\"")
                .append("}")
                .toString());

        assertEquals(expectedJson, actualJson);
    }
}
