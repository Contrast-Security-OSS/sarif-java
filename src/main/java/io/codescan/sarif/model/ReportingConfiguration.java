package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * Information about a rule or notification that can be configured at runtime.
 */
@AutoValue
public abstract class ReportingConfiguration {

    /**
     * Specifies whether the report may be produced during the scan.
     */
    @JsonProperty("enabled")
    public abstract boolean enabled();

    /**
     * Specifies the failure level for the report.
     */
    @JsonProperty("level")
    @Nullable
    public abstract SeverityLevel level();

    /**
     * Specifies the relative priority of the report. Used for analysis output only.
     */
    @JsonProperty("rank")
    @Nullable
    public abstract Float rank();

    /**
     * Contains configuration information specific to a report.
     */
    @JsonProperty("parameters")
    @Nullable
    public abstract PropertyBag parameters();

    /**
     * Key/value pairs that provide additional information about the reporting configuration.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static ReportingConfiguration.Builder builder() {
        return new AutoValue_ReportingConfiguration.Builder()
                .setEnabled(true);
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract ReportingConfiguration.Builder setEnabled(boolean enabled);
        public abstract ReportingConfiguration.Builder setLevel(SeverityLevel level);
        public abstract ReportingConfiguration.Builder setRank(Float rank);
        public abstract ReportingConfiguration.Builder setParameters(PropertyBag parameters);
        public abstract ReportingConfiguration.Builder setProperties(PropertyBag properties);
        public abstract ReportingConfiguration build();
    }
}
