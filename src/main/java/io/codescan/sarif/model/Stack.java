package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@AutoValue
public abstract class Stack {
    /**
     * A message relevant to this call stack.
     */
    @JsonProperty("message")
    @Nullable
    public abstract Message message();
    /**
     * An array of stack frames that represents a sequence of calls, rendered in reverse chronological order, that
     * comprise the call stack.
     */
    @JsonProperty("frames")
    @Nullable
    public abstract List<StackFrame> frames();
    /**
     * Key/value pairs that provide additional information about the stack.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static Stack.Builder builder() {
        return new AutoValue_Stack.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Stack.Builder setMessage(Message message);
        public abstract Stack.Builder setFrames(List<StackFrame> frames);
        public abstract Stack.Builder setProperties(PropertyBag properties);
        public abstract Stack build();
    }
}
