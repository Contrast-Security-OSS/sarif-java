package io.codescan.sarif.model;

import java.util.LinkedHashSet;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * Key/value pairs that provide additional information about the object.
 */
@AutoValue
public abstract class PropertyBag {

    @JsonProperty("properties")
    @Nullable
    public abstract Map<String, String> properties();
    /**
     * A set of distinct strings that provide additional information.
     *
     * The object is a LinkedHashSet implementation because lists in json are considered ordered.
     */
    @JsonProperty("tags")
    @Nullable
    public abstract LinkedHashSet<String> tags();
    public static PropertyBag.Builder builder() {
        return new AutoValue_PropertyBag.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract PropertyBag.Builder setProperties(Map<String, String> properties);
        public abstract PropertyBag.Builder setTags(LinkedHashSet<String> tags);
        public abstract PropertyBag build();
    }
}
