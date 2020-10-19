package com.contrastsecurity.sarif.encoding;

import com.contrastsecurity.sarif.model.PropertyBag;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public final class PropertyBagSerializer extends StdSerializer<PropertyBag> {
  public PropertyBagSerializer() {
    this(null);
  }

  public PropertyBagSerializer(Class<PropertyBag> t) {
    super(t);
  }

  @Override
  public void serialize(PropertyBag bag, JsonGenerator jsonGenerator, SerializerProvider serializer)
      throws IOException {
    Map<String, Object> props = bag.properties();
    Set<String> tags = bag.tags();

    jsonGenerator.writeStartObject();

    if (props != null) {
      for (Map.Entry<String, Object> entry : props.entrySet()) {
        jsonGenerator.writeObjectField(entry.getKey(), entry.getValue());
      }
    }

    if (tags != null) {
      jsonGenerator.writeArrayFieldStart("tags");
      for (String val : tags) {
        jsonGenerator.writeString(val);
      }
      jsonGenerator.writeEndArray();
    }

    jsonGenerator.writeEndObject();
  }
}
