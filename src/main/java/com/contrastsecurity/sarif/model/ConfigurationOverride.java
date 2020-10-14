package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/** Information about how a specific rule or notification was reconfigured at runtime. */
@AutoValue
public abstract class ConfigurationOverride {
  /** Specifies how the rule or notification was configured during the scan. */
  @JsonProperty("configuration")
  public abstract ReportingConfiguration configuration();
  /** A reference used to locate the descriptor whose configuration was overridden. */
  @JsonProperty("descriptor")
  public abstract ReportingDescriptorReference descriptor();
  /** Key/value pairs that provide additional information about the configuration override. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static ConfigurationOverride.Builder builder() {
    return new AutoValue_ConfigurationOverride.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract ConfigurationOverride.Builder setConfiguration(
        ReportingConfiguration configuration);

    public abstract ConfigurationOverride.Builder setDescriptor(
        ReportingDescriptorReference descriptor);

    public abstract ConfigurationOverride.Builder setProperties(PropertyBag bag);

    public abstract ConfigurationOverride build();
  }
}
