package io.codescan.sarif.encoding;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codescan.sarif.model.PropertyBag;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyBagSerializerTests {

    @Test
    public void propertyBagArbitraryKVs() throws Exception {
        var bag = new PropertyBag();
        LinkedHashSet<String> tags = new LinkedHashSet<String>();
        tags.add("foo");
        tags.add("bar");
        tags.add("quux");
        tags.add("qaaz");
        bag.setTags(tags);
        Map<String, String> m = new HashMap();
        m.put("akey", "aval");
        m.put("bkey", "bval");
        bag.setProperties(m);

        var bagJson = SarifJsonSerializer.toJson(bag);

        JsonNode actual = new ObjectMapper().readTree(bagJson);
        JsonNode expected = new ObjectMapper().readTree(new StringBuilder()
                .append("{")
                .append("\"akey\": \"aval\",")
                .append("\"bkey\": \"bval\",")
                .append("\"tags\": [\"foo\", \"bar\", \"quux\", \"qaaz\"]}")
                .toString());

        assertEquals(expected, actual);
    }

    @Test
    public void GivenNullTags_WhenToJson_ThenNoTagsAreShown() throws Exception {
        var bag = new PropertyBag();
        Map<String, String> m = new HashMap();
        m.put("akey", "aval");
        m.put("bkey", "bval");
        bag.setProperties(m);

        var bagJson = SarifJsonSerializer.toJson(bag);

        JsonNode actual = new ObjectMapper().readTree(bagJson);
        JsonNode expected = new ObjectMapper().readTree(new StringBuilder()
                .append("{")
                .append("\"akey\": \"aval\",")
                .append("\"bkey\": \"bval\"}")
                .toString());

        assertEquals(expected, actual);
    }
    @Test
    public void GivenEmptyTags_WhenToJson_ThenEmptyTagsAreShown() throws Exception {
        var bag = new PropertyBag();
        Map<String, String> m = new HashMap();
        m.put("akey", "aval");
        m.put("bkey", "bval");
        bag.setProperties(m);
        bag.setTags(new LinkedHashSet<String>());

        var bagJson = SarifJsonSerializer.toJson(bag);

        JsonNode actual = new ObjectMapper().readTree(bagJson);
        JsonNode expected = new ObjectMapper().readTree(new StringBuilder()
                .append("{")
                .append("\"akey\": \"aval\",")
                .append("\"bkey\": \"bval\",")
                .append("\"tags\": []}")
                .toString());

        assertEquals(expected, actual);
    }

    @Test
    public void GivenEmptyProps_WhenToJson_ThenNoPropsAreShown() throws Exception {
        var bag = new PropertyBag();
        Map<String, String> m = new HashMap();
        bag.setProperties(m);
        var tags = new LinkedHashSet<String>();
        tags.add("foo");
        tags.add("bar");
        bag.setTags(tags);

        var bagJson = SarifJsonSerializer.toJson(bag);

        JsonNode actual = new ObjectMapper().readTree(bagJson);
        JsonNode expected = new ObjectMapper().readTree(new StringBuilder()
                .append("{")
                .append("\"tags\": [\"foo\", \"bar\"]}")
                .toString());

        assertEquals(expected, actual);
    }

    @Test
    public void GivenNullProps_WhenToJson_ThenNoPropsAreShown() throws Exception {
        var bag = new PropertyBag();
        var tags = new LinkedHashSet<String>();
        tags.add("foo");
        tags.add("bar");
        bag.setTags(tags);

        var bagJson = SarifJsonSerializer.toJson(bag);

        JsonNode actual = new ObjectMapper().readTree(bagJson);
        JsonNode expected = new ObjectMapper().readTree(new StringBuilder()
                .append("{")
                .append("\"tags\": [\"foo\", \"bar\"]}")
                .toString());

        assertEquals(expected, actual);
    }

    @Test
    public void GivenNullPropsAndTags_WhenToJson_ThenNoPropsOrTagsAreShown() throws Exception {
        var bag = new PropertyBag();

        var bagJson = SarifJsonSerializer.toJson(bag);

        JsonNode actual = new ObjectMapper().readTree(bagJson);
        JsonNode expected = new ObjectMapper().readTree(new StringBuilder()
                .append("{")
                .append("}")
                .toString());

        assertEquals(expected, actual);
    }

    @Test
    public void GivenEmptyPropsAndTags_WhenToJson_ThenEmptyTagsAreOnlyShown() throws Exception {
        var bag = new PropertyBag();
        bag.setProperties(new HashMap<String, String>());
        bag.setTags(new LinkedHashSet<String>());

        var bagJson = SarifJsonSerializer.toJson(bag);

        JsonNode actual = new ObjectMapper().readTree(bagJson);
        JsonNode expected = new ObjectMapper().readTree(new StringBuilder()
                .append("{")
                .append("\"tags\":[]}")
                .toString());

        assertEquals(expected, actual);
    }
}
