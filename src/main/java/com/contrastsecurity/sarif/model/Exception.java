package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.*;

import org.jetbrains.annotations.Nullable;

/** Describes a runtime exception encountered during the execution of an analysis tool. */
@AutoValue
public abstract class Exception {
  /**
   * A string that identifies the kind of exception, for example, the fully qualified type name of
   * an object that was thrown, or the symbolic name of a signal.
   */
  @JsonProperty("kind")
  @Nullable
  public abstract String kind();
  /** A message that describes the exception. */
  @JsonProperty("message")
  @Nullable
  public abstract String message();
  /** The sequence of function calls leading to the exception. */
  @JsonProperty("stack")
  @Nullable
  public abstract com.contrastsecurity.sarif.model.Stack stack();
  /** An array of exception objects each of which is considered a cause of this exception. */
  @JsonProperty("innerExceptions")
  @Nullable
  public abstract List<Exception> innerExceptions();
  /** Key/value pairs that provide additional information about the exception. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static Exception.Builder builder() {
    return new AutoValue_Exception.Builder();
  }

  public static Exception from(Throwable throwable) {
    final List<Exception> innerExceptions = new ArrayList<>();
    if (throwable.getCause() != null) {
      innerExceptions.add(Exception.from(throwable.getCause()));
    }

    return builder()
        .setMessage(throwable.getMessage())
        .setKind(throwable.getClass().getSimpleName())
        .setInnerExceptions(Collections.unmodifiableList(innerExceptions))
        .setStack(com.contrastsecurity.sarif.model.Stack.from(throwable))
        .build();
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
