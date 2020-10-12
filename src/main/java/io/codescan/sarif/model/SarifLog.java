package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * Static Analysis Results.
 */
@AutoValue
public abstract class SarifLog {

    /**
     * The URI of the JSON schema corresponding to the version.
     */
    @JsonProperty("$schema")
    private static String schema = "https://raw.githubusercontent.com/oasis-tcs/sarif-spec/master/Schemata/sarif-schema-2.1.0.json";

    /**
     * The SARIF format version of this log file.
     */
    @JsonProperty("version")
    private static String version = "2.1.0";

    /**
     * The set of runs contained in this log file.
     */
    @JsonProperty("runs")
    @Nullable
    public abstract List<Run> runs();


    public static SarifLog.Builder builder() {
        return new AutoValue_SarifLog.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract SarifLog.Builder setRuns(List<Run> runs);
        public abstract SarifLog build();
    }
}
