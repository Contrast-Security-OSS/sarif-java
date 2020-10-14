package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/** Specifies the location of an artifact. */
@AutoValue
public abstract class ArtifactLocation {

  /** A string containing a valid relative or absolute URI. */
  @JsonProperty("uri")
  @Nullable
  public abstract String uri();

  /**
   * A string which indirectly specifies the absolute URI with respect to which a relative URI in
   * the "uri" property is interpreted.
   */
  @JsonProperty("uriBaseId")
  @Nullable
  public abstract String uriBaseId();

  /**
   * The index within the run artifacts array of the artifact object associated with the artifact
   * location.
   */
  @JsonProperty("index")
  @Nullable
  public abstract Integer index();

  /** A short description of the artifact location. */
  @JsonProperty("description")
  @Nullable
  public abstract Message description();

  /** Key/value pairs that provide additional information about the artifact location. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static ArtifactLocation.Builder builder() {
    return new AutoValue_ArtifactLocation.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract ArtifactLocation.Builder setUri(String uri);

    public abstract ArtifactLocation.Builder setUriBaseId(String uriBaseId);

    public abstract ArtifactLocation.Builder setIndex(Integer index);

    public abstract ArtifactLocation.Builder setDescription(Message description);

    public abstract ArtifactLocation.Builder setProperties(PropertyBag properties);

    public abstract ArtifactLocation build();
  }
}
