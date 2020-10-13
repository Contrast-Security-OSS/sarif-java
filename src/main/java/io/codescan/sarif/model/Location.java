package io.codescan.sarif.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * A location within a programming artifact.
 */
@AutoValue
public abstract class Location {

    /**
     * Value that distinguishes this location from all other locations within a single result object.
     */
    @JsonProperty("id")
    @Nullable
    public abstract Integer id();

    /**
     * Identifies the artifact and region.
     */
    @JsonProperty("physicalLocation")
    @Nullable
    public abstract PhysicalLocation physicalLocation();

    /**
     * The logical locations associated with the result.
     */
    @JsonProperty("logicalLocations")
    @Nullable
    public abstract List<LogicalLocation> logicalLocations();

    /**
     * A message relevant to the location.
     */
    @JsonProperty("message")
    @Nullable
    public abstract Message message();

    public static Location.Builder builder() {
        return new AutoValue_Location.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Location.Builder setId(Integer id);
        public abstract Location.Builder setPhysicalLocation(PhysicalLocation physicalLocation);
        public abstract Location.Builder setLogicalLocations(List<LogicalLocation> logicalLocations);
        public abstract Location.Builder setMessage(Message message);
        public abstract Location build();
    }
}
