package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

@AutoValue
/**
 * Information about how to locate a relevant reporting descriptor.
 */
public abstract class ReportingDescriptorReference {
    /**
     * The id of the descriptor.
     */
    @JsonProperty("id")
    @Nullable
    public abstract String id();
    /**
     * The index into an array of descriptors in toolComponent.ruleDescriptors, toolComponent.notificationDescriptors,
     * or toolComponent.taxonomyDescriptors, depending on context.
     */
    @JsonProperty("index")
    @Nullable
    public abstract Integer index();
    /**
     * A guid that uniquely identifies the descriptor.
     */
    @JsonProperty("guid")
    @Nullable
    public abstract String guid();
    /**
     * A reference used to locate the toolComponent associated with the descriptor.
     */
    @JsonProperty("toolComponent")
    @Nullable
    public abstract ToolComponentReference toolComponent();
    /**
     * Key/value pairs that provide additional information about the reporting descriptor reference.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static ReportingDescriptorReference.Builder builder() {
        return new AutoValue_ReportingDescriptorReference.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract ReportingDescriptorReference.Builder setId(String id);
        public abstract ReportingDescriptorReference.Builder setIndex(Integer index);
        public abstract ReportingDescriptorReference.Builder setGuid(String guid);
        public abstract ReportingDescriptorReference.Builder setToolComponent(ToolComponentReference toolComponent);
        public abstract ReportingDescriptorReference.Builder setProperties(PropertyBag properties);
        public abstract ReportingDescriptorReference build();
    }
}
