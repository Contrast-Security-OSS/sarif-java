package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@AutoValue
public abstract class StackFrame {
    /**
     * The location to which this stack frame refers.
     */
    @JsonProperty("location")
    @Nullable
    public abstract Location location();
    /**
     * The name of the module that contains the code of this stack frame.
     */
    @JsonProperty("module")
    @Nullable
    public abstract String module();
    /**
     * The thread identifier of the stack frame.
     */
    @JsonProperty("threadId")
    @Nullable
    public abstract Integer threadId();
    /**
     * The parameters of the call that is executing.
     */
    @JsonProperty("parameters")
    @Nullable
    public abstract List<String> parameters();
    /**
     * Key/value pairs that provide additional information about the stack frame.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static StackFrame.Builder builder() {
        return new AutoValue_StackFrame.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract StackFrame.Builder setLocation(Location location);
        public abstract StackFrame.Builder setModule(String module);
        public abstract StackFrame.Builder setThreadId(Integer threadId);
        public abstract StackFrame.Builder setParameters(List<String> parameters);
        public abstract StackFrame.Builder setProperties(PropertyBag properties);
        public abstract StackFrame build();
    }
}
