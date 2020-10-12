package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@AutoValue
public abstract class Conversion {
    /**
     * A tool object that describes the converter.
     */
    @JsonProperty("tool")
    @Nullable
    public abstract Tool tool();
    /**
     * An invocation object that describes the invocation of the converter.
     */
    @JsonProperty("invocation")
    @Nullable
    public abstract Invocation invocation();
    /**
     * The locations of the analysis tool's per-run log files.
     */
    @JsonProperty("analysisToolLogFiles")
    @Nullable
    public abstract List<ArtifactLocation> analysisToolLogFiles();
    /**
     * Key/value pairs that provide additional information about the conversion.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static Conversion.Builder builder() {
        return new AutoValue_Conversion.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Conversion.Builder setTool(Tool tool);
        public abstract Conversion.Builder setInvocation(Invocation invocation);
        public abstract Conversion.Builder setAnalysisToolLogFiles(List<ArtifactLocation> analysisToolLogFiles);
        public abstract Conversion.Builder setProperties(PropertyBag properties);
        public abstract Conversion build();
    }
}
