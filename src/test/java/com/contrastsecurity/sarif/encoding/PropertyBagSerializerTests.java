package com.contrastsecurity.sarif.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.contrastsecurity.sarif.model.PropertyBag;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import org.junit.jupiter.api.Test;

public class PropertyBagSerializerTests {

  @Test
  public void propertyBagArbitraryKVs() throws Exception {

    LinkedHashSet<String> tags = new LinkedHashSet<String>();
    tags.add("foo");
    tags.add("bar");
    tags.add("quux");
    tags.add("qaaz");
    Map<String, Object> m = new HashMap();
    m.put("akey", "aval");
    m.put("bkey", "bval");

    var bag = PropertyBag.builder().setTags(tags).setProperties(m).build();

    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper()
            .readTree(
                new StringBuilder()
                    .append("{")
                    .append("\"akey\": \"aval\",")
                    .append("\"bkey\": \"bval\",")
                    .append("\"tags\": [\"foo\", \"bar\", \"quux\", \"qaaz\"]}")
                    .toString());

    assertEquals(expected, actual);
  }

  @Test
  public void GivenNullTags_WhenToJson_ThenNoTagsAreShown() throws Exception {
    Map<String, Object> m = new HashMap();
    m.put("akey", "aval");
    m.put("bkey", "bval");
    var bag = PropertyBag.builder().setProperties(m).build();

    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper()
            .readTree(
                new StringBuilder()
                    .append("{")
                    .append("\"akey\": \"aval\",")
                    .append("\"bkey\": \"bval\"}")
                    .toString());

    assertEquals(expected, actual);
  }

  @Test
  public void GivenEmptyTags_WhenToJson_ThenEmptyTagsAreShown() throws Exception {
    Map<String, Object> m = new HashMap();
    m.put("akey", "aval");
    m.put("bkey", "bval");
    var bag = PropertyBag.builder().setTags(new LinkedHashSet<String>()).setProperties(m).build();

    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper()
            .readTree(
                new StringBuilder()
                    .append("{")
                    .append("\"akey\": \"aval\",")
                    .append("\"bkey\": \"bval\",")
                    .append("\"tags\": []}")
                    .toString());

    assertEquals(expected, actual);
  }

  @Test
  public void GivenEmptyProps_WhenToJson_ThenNoPropsAreShown() throws Exception {
    Map<String, Object> m = new HashMap();
    var tags = new LinkedHashSet<String>();
    tags.add("foo");
    tags.add("bar");

    var bag = PropertyBag.builder().setTags(tags).setProperties(m).build();
    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper()
            .readTree(
                new StringBuilder().append("{").append("\"tags\": [\"foo\", \"bar\"]}").toString());

    assertEquals(expected, actual);
  }

  @Test
  public void GivenNullProps_WhenToJson_ThenNoPropsAreShown() throws Exception {
    var tags = new LinkedHashSet<String>();
    tags.add("foo");
    tags.add("bar");

    var bag = PropertyBag.builder().setTags(tags).build();
    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper()
            .readTree(
                new StringBuilder().append("{").append("\"tags\": [\"foo\", \"bar\"]}").toString());

    assertEquals(expected, actual);
  }

  @Test
  public void GivenNullPropsAndTags_WhenToJson_ThenNoPropsOrTagsAreShown() throws Exception {
    var bag = PropertyBag.builder().build();
    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper().readTree(new StringBuilder().append("{").append("}").toString());

    assertEquals(expected, actual);
  }

  @Test
  public void GivenEmptyPropsAndTags_WhenToJson_ThenEmptyTagsAreOnlyShown() throws Exception {
    var m = new HashMap<String, Object>();
    var tags = new LinkedHashSet<String>();

    var bag = PropertyBag.builder().setTags(tags).setProperties(m).build();
    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper()
            .readTree(new StringBuilder().append("{").append("\"tags\":[]}").toString());

    assertEquals(expected, actual);
  }

  @Test
  public void GivenProperties_WhenObjectTypesMixed_ThenEncodesAsCorrectObjectTypes()
      throws Exception {
    var m = new HashMap<String, Object>();
    m.put("myint", 42);
    m.put("mystr", String.valueOf(42));
    m.put("myfloat", (float) 123.45);
    m.put("myarray", List.of("item1", "item2", "item3"));
    m.put("mymap", Map.of("k1", "v1", "k2", "v2"));

    var bag = PropertyBag.builder().setProperties(m).build();
    var bagJson = SarifJsonSerializer.toJson(bag);

    JsonNode actual = new ObjectMapper().readTree(bagJson);
    JsonNode expected =
        new ObjectMapper()
            .readTree(
                "{"
                    + "\"myint\": 42,"
                    + "\"mystr\": \"42\","
                    + "\"myfloat\": 123.45,"
                    + "\"myarray\": [\"item1\", \"item2\", \"item3\"],"
                    + "\"mymap\":{\"k1\": \"v1\", \"k2\": \"v2\"}"
                    + "}");

    assertEquals(expected, actual);
  }
}
