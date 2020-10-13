package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Describes a runtime exception encountered during the execution of an analysis tool.
 */
@AutoValue
public abstract class Exception {
    /**
     * A string that identifies the kind of exception, for example, the fully qualified type name of an object that was
     * thrown, or the symbolic name of a signal.
     */
    @JsonProperty("kind")
    public abstract String kind();
    /**
     * A message that describes the exception.
     */
    @JsonProperty("message")
    public abstract String message();
    /**
     * The sequence of function calls leading to the exception.
     */
    @JsonProperty("stack")
    public abstract Stack stack();
    /**
     * An array of exception objects each of which is considered a cause of this exception.
     */
    @JsonProperty("innerExceptions")
    public abstract List<Exception> innerExceptions();
    /**
     * Key/value pairs that provide additional information about the exception.
     */
    @JsonProperty("properties")
    public abstract PropertyBag properties();

    public static Exception.Builder builder() {
        return new AutoValue_Exception.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Exception.Builder setKind(String kind);
        public abstract Exception.Builder setMessage(String message);
        public abstract Exception.Builder setStack(Stack stack);
        public abstract Exception.Builder setInnerExceptions(List<Exception> innerExceptions);
        public abstract Exception.Builder setProperties(PropertyBag bag);
        public abstract Exception build();
    }
}
