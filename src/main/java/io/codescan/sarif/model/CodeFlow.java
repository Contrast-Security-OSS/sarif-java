package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * A set of threadFlows which together describe a pattern of code execution relevant to detecting a result.
 */
@AutoValue
public abstract class CodeFlow {
    /**
     * A message relevant to the code flow.
     */
    @JsonProperty("message")
    @Nullable
    public abstract Message message();
    /**
     * An array of one or more unique threadFlow objects, each of which describes the progress of a program through a
     * thread of execution.
     */
    @JsonProperty("threadFlows")
    @Nullable
    public abstract List<ThreadFlow> threadFlows();

    /**
     * Key/value pairs that provide additional information about the code flow.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();

    public static CodeFlow.Builder builder() {
        return new AutoValue_CodeFlow.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract CodeFlow.Builder setMessage(Message message);
        public abstract CodeFlow.Builder setThreadFlows(List<ThreadFlow> threadFlows);
        public abstract CodeFlow.Builder setProperties(PropertyBag properties);
        public abstract CodeFlow build();
    }
}
