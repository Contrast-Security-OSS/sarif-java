package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * A physical location relevant to a result. Specifies a reference to a programming artifact
 * together with a range of bytes or characters within that artifact.
 */
@AutoValue
public abstract class PhysicalLocation {

  /** The address of the location. */
  @JsonProperty("address")
  @Nullable
  public abstract Address address();

  /** The location of the artifact. */
  @JsonProperty("artifactLocation")
  @Nullable
  public abstract ArtifactLocation artifactLocation();

  /** Specifies a portion of the artifact. */
  @JsonProperty("region")
  @Nullable
  public abstract Region region();

  /**
   * Specifies a portion of the artifact that encloses the region. Allows a viewer to display
   * additional context around the region.
   */
  @JsonProperty("contextRegion")
  @Nullable
  public abstract Region contextRegion();

  public static PhysicalLocation.Builder builder() {
    return new AutoValue_PhysicalLocation.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract PhysicalLocation.Builder setAddress(Address address);

    public abstract PhysicalLocation.Builder setArtifactLocation(ArtifactLocation artifactLocation);

    public abstract PhysicalLocation.Builder setRegion(Region region);

    public abstract PhysicalLocation.Builder setContextRegion(Region contextRegion);

    public abstract PhysicalLocation build();
  }
}
