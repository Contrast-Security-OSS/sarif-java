package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/**
 * Describes a sequence of code locations that specify a path through a single thread of execution
 * such as an operating system or fiber.
 */
@AutoValue
public abstract class ThreadFlow {
  /** An string that uniquely identifies the threadFlow within the codeFlow in which it occurs. */
  @JsonProperty("id")
  @Nullable
  public abstract String id();
  /** A message relevant to the thread flow. */
  @JsonProperty("message")
  @Nullable
  public abstract Message message();
  /**
   * Values of relevant expressions at the start of the thread flow that may change during thread
   * flow execution.
   */
  @JsonProperty("initialState")
  @Nullable
  public abstract Map<String, MultiformatMessageString> initialState();
  /** Values of relevant expressions at the start of the thread flow that remain constant. */
  @JsonProperty("immutableState")
  @Nullable
  public abstract Map<String, MultiformatMessageString> immutableState();
  /**
   * A temporally ordered array of 'threadFlowLocation' objects, each of which describes a location
   * visited by the tool while producing the result.
   */
  @JsonProperty("locations")
  @Nullable
  public abstract List<ThreadFlowLocation> locations();
  /** Key/value pairs that provide additional information about the thread flow. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static ThreadFlow.Builder builder() {
    return new AutoValue_ThreadFlow.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract ThreadFlow.Builder setId(String id);

    public abstract ThreadFlow.Builder setMessage(Message message);

    public abstract ThreadFlow.Builder setInitialState(
        Map<String, MultiformatMessageString> initialState);

    public abstract ThreadFlow.Builder setImmutableState(
        Map<String, MultiformatMessageString> immutableState);

    public abstract ThreadFlow.Builder setLocations(List<ThreadFlowLocation> locations);

    public abstract ThreadFlow.Builder setProperties(PropertyBag properties);

    public abstract ThreadFlow build();
  }
}
