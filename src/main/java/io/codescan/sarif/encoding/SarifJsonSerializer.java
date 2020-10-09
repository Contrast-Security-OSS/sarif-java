package io.codescan.sarif.encoding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.codescan.sarif.model.PropertyBag;

import java.time.Instant;

public class SarifJsonSerializer {

    private SarifJsonSerializer() {}

    public static String toJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        SimpleModule module =
                new SimpleModule("CustomSerializers", new Version(1, 0, 0, null, null, null));
        module.addSerializer(PropertyBag.class, new PropertyBagSerializer());
        module.addSerializer(Instant.class, new InstantSerializer()); // handle sarif data-time format
        mapper.registerModule(module);

        final String sarifJson = mapper.writeValueAsString(obj);
        return sarifJson;
    }
}
