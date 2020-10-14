package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

/** Information about the relation of one reporting descriptor to another. */
@AutoValue
public abstract class ReportingDescriptorRelationship {
  /** A reference to the related reporting descriptor. */
  @JsonProperty("target")
  public abstract ReportingDescriptorReference target();
  /**
   * A set of distinct strings that categorize the relationship. Well-known kinds include
   * 'canPrecede', 'canFollow', 'willPrecede', 'willFollow', 'superset', 'subset', 'equal',
   * 'disjoint', 'relevant', and 'incomparable'.
   */
  @JsonProperty("kinds")
  @Nullable
  public abstract Set<String> kinds();
  /** A description of the reporting descriptor relationship. */
  @JsonProperty("description")
  @Nullable
  public abstract Message description();
  /**
   * "Key/value pairs that provide additional information about the reporting descriptor reference.
   */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static ReportingDescriptorRelationship.Builder builder() {
    return new AutoValue_ReportingDescriptorRelationship.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract ReportingDescriptorRelationship.Builder setTarget(
        ReportingDescriptorReference target);

    public abstract ReportingDescriptorRelationship.Builder setKinds(Set<String> kinds);

    public abstract ReportingDescriptorRelationship.Builder setDescription(Message description);

    public abstract ReportingDescriptorRelationship.Builder setProperties(PropertyBag properties);

    public abstract ReportingDescriptorRelationship build();
  }
}
