package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

@AutoValue
/**
 * A location visited by an analysis tool while simulating or monitoring the execution of a program.
 */
public abstract class ThreadFlowLocation {
  /** The index within the run threadFlowLocations array. */
  @JsonProperty("index")
  @Nullable
  public abstract Integer index();
  /** The code location. */
  @JsonProperty("location")
  @Nullable
  public abstract Location location();
  /** The call stack leading to this location. */
  @JsonProperty("stack")
  @Nullable
  public abstract Stack stack();
  /**
   * A set of distinct strings that categorize the thread flow location. Well-known kinds include
   * 'acquire', 'release', 'enter', 'exit', 'call', 'return', 'branch', 'implicit', 'false', 'true',
   * 'caution', 'danger', 'unknown', 'unreachable', 'taint', 'function', 'handler', 'lock',
   * 'memory', 'resource', 'scope' and 'value'.
   */
  @JsonProperty("kinds")
  @Nullable
  public abstract Set<String> kinds();
  /**
   * An array of references to rule or taxonomy reporting descriptors that are applicable to the
   * thread flow location.
   */
  @JsonProperty("taxa")
  @Nullable
  public abstract Set<ReportingDescriptorReference> taxa();
  /** The name of the module that contains the code that is executing. */
  @JsonProperty("module")
  @Nullable
  public abstract String module();
  /**
   * A dictionary, each of whose keys specifies a variable or expression, the associated value of
   * which represents the variable or expression value. For an annotation of kind 'continuation',
   * for example, this dictionary might hold the current assumed values of a set of global
   * variables.
   */
  @JsonProperty("state")
  @Nullable
  public abstract Map<String, MultiformatMessageString> state();
  /** An integer representing a containment hierarchy within the thread flow. */
  @JsonProperty("nestingLevel")
  @Nullable
  public abstract Integer nestingLevel();
  /** An integer representing the temporal order in which execution reached this location. */
  @JsonProperty("executionOrder")
  @Nullable
  public abstract Integer executionOrder();

  // executionTimeUtc

  /**
   * Specifies the importance of this location in understanding the code flow in which it occurs.
   * The order from most to least important is "essential", "important", "unimportant".
   */
  @JsonProperty("importance")
  @Nullable
  public abstract Importance importance();

  /** Key/value pairs that provide additional information about the threadflow location. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static ThreadFlowLocation.Builder builder() {
    return new AutoValue_ThreadFlowLocation.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract ThreadFlowLocation.Builder setIndex(Integer index);

    public abstract ThreadFlowLocation.Builder setLocation(Location location);

    public abstract ThreadFlowLocation.Builder setStack(Stack stack);

    public abstract ThreadFlowLocation.Builder setKinds(Set<String> kinds);

    public abstract ThreadFlowLocation.Builder setTaxa(Set<ReportingDescriptorReference> taxa);

    public abstract ThreadFlowLocation.Builder setModule(String module);

    public abstract ThreadFlowLocation.Builder setState(
        Map<String, MultiformatMessageString> state);

    public abstract ThreadFlowLocation.Builder setNestingLevel(Integer nestingLevel);

    public abstract ThreadFlowLocation.Builder setExecutionOrder(Integer executionOrder);

    public abstract ThreadFlowLocation.Builder setImportance(Importance importance);

    public abstract ThreadFlowLocation.Builder setProperties(PropertyBag properties);

    public abstract ThreadFlowLocation build();
  }
}
