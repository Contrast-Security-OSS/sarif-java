package io.codescan.sarif.encoding;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.codescan.sarif.model.PropertyBag;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PropertyBagSerializer extends StdSerializer<PropertyBag> {
    public PropertyBagSerializer() {
        this(null);
    }

    public PropertyBagSerializer(Class<PropertyBag> t) {
        super(t);
    }

    @Override
    public void serialize(PropertyBag properties, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        Map<String, String> props = properties.getProperties();
        Set<String> tags = properties.getTags();

        jsonGenerator.writeStartObject();

        if (props != null) {
            for (Map.Entry<String, String> entry: props.entrySet()) {
                jsonGenerator.writeStringField(entry.getKey(), entry.getValue());
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
