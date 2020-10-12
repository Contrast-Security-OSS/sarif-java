package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * Identifies a particular toolComponent object, either the driver or an extension.
 */
@AutoValue
public abstract class ToolComponentReference {
    /**
     * The 'name' property of the referenced toolComponent.
     */
    @JsonProperty("name")
    @Nullable
    public abstract String name();
    /**
     * An index into the referenced toolComponent in tool.extensions.
     */
    @JsonProperty("index")
    @Nullable
    public abstract Integer index();
    /**
     * The 'guid' property of the referenced toolComponent.
     */
    @JsonProperty("guid")
    @Nullable
    public abstract String guid();
    /**
     * Key/value pairs that provide additional information about the toolComponentReference.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static ToolComponentReference.Builder builder() {
        return new AutoValue_ToolComponentReference.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract ToolComponentReference.Builder setName(String name);
        public abstract ToolComponentReference.Builder setIndex(Integer index);
        public abstract ToolComponentReference.Builder setGuid(String guid);
        public abstract ToolComponentReference.Builder setProperties(PropertyBag properties);
        public abstract ToolComponentReference build();
    }
}
