package io.codescan.sarif.encoding;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatterBuilder;


public class InstantSerializer extends StdSerializer<Instant> {
    public InstantSerializer() {
        this(null);
    }

    public InstantSerializer(Class<Instant> t) {
        super(t);
    }

    @Override
    public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        //TODO: convert 'instant' to utc date-time sarif format.
        var fmt = new DateTimeFormatterBuilder().appendInstant().toFormatter();
        jsonGenerator.writeString(fmt.format(instant));
    }
}
