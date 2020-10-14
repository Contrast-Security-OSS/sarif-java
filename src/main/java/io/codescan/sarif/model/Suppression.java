package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/** A suppression that is relevant to a result. */
@AutoValue
public abstract class Suppression {
  /** A stable, unique identifer for the suprression in the form of a GUID. */
  @JsonProperty("guid")
  @Nullable
  public abstract String guid();
  /** A string that indicates where the suppression is persisted. */
  @JsonProperty("kind")
  @Nullable
  public abstract SuppressionKind kind();
  /** A string that indicates the review status of the suppression. */
  @JsonProperty("status")
  @Nullable
  public abstract SuppressionStatus status();
  /** A string representing the justification for the suppression. */
  @JsonProperty("justification")
  @Nullable
  public abstract String justification();
  /** Identifies the location associated with the suppression. */
  @JsonProperty("location")
  @Nullable
  public abstract Location location();
  /** Key/value pairs that provide additional information about the suppression. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static Suppression.Builder builder() {
    return new AutoValue_Suppression.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Suppression.Builder setGuid(String guid);

    public abstract Suppression.Builder setKind(SuppressionKind kind);

    public abstract Suppression.Builder setStatus(SuppressionStatus status);

    public abstract Suppression.Builder setJustification(String justification);

    public abstract Suppression.Builder setLocation(Location location);

    public abstract Suppression.Builder setProperties(PropertyBag properties);

    public abstract Suppression build();
  }
}
