package io.codescan.sarif.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * The analysis tool that was run.
 */
@AutoValue
public abstract class Tool {

    /**
     * The analysis tool that was run.
     */
    @JsonProperty("driver")
    public abstract ToolComponent driver();

    /**
     * Tool extensions that contributed to or reconfigured the analysis tool that was run.
     */
    @JsonProperty("extensions")
    @Nullable
    public abstract List<ToolComponent> extensions();

    /**
     * Key/value pairs that provide additional information about the tool.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();

    public static Tool.Builder builder() {
        return new AutoValue_Tool.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Tool.Builder setDriver(ToolComponent driver);
        public abstract Tool.Builder setExtensions(List<ToolComponent> extensions);
        public abstract Tool.Builder setProperties(PropertyBag properties);
        public abstract Tool build();
    }
}
