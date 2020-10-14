package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

@AutoValue
public abstract class Artifact {
  /** A short description of the artifact. */
  @JsonProperty("description")
  @Nullable
  public abstract Message description();
  /** The location of the artifact. */
  @JsonProperty("location")
  @Nullable
  public abstract ArtifactLocation location();
  /** Identifies the index of the immediate parent of the artifact, if this artifact is nested. */
  @JsonProperty("parentIndex")
  @Nullable
  public abstract Integer parentIndex();
  /** The offset in bytes of the artifact within its containing artifact. */
  @JsonProperty("offset")
  @Nullable
  public abstract Integer offset();
  /** The length of the artifact in bytes. */
  @JsonProperty("length")
  @Nullable
  public abstract Integer length();
  /** The role or roles played by the artifact in the analysis. */
  @JsonProperty("roles")
  @Nullable
  public abstract List<ArtifactRole> roles();
  /** The MIME type (RFC 2045) of the artifact. */
  @JsonProperty("mimeType")
  @Nullable
  public abstract String mimeType();
  /** Specifies the encoding for an artifact object that refers to a text file */
  @JsonProperty("encoding")
  @Nullable
  public abstract String encoding();
  /**
   * Specifies the source language for any artifact object that refers to a text file that contains
   * source code.
   */
  @JsonProperty("sourceLanguage")
  @Nullable
  public abstract String sourceLanguage();
  /**
   * A dictionary, each of whose keys is the name of a hash function and each of whose values is the
   * hashed value of the artifact produced by the specified hash function.
   */
  @JsonProperty("hashes")
  @Nullable
  public abstract Map<String, String> hashes();
  /**
   * The Coordinated Universal Time (UTC) date and time at which the artifact was most recently
   * modified. See \"Date/time properties\" in the SARIF spec for the required format.
   */
  @JsonProperty("lastModifiedTimeUtc")
  @Nullable
  public abstract Instant lastModifiedTimeUtc();
  /** Key/value pairs that provide additional information about the artifact. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static Artifact.Builder builder() {
    return new AutoValue_Artifact.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Artifact.Builder setDescription(Message description);

    public abstract Artifact.Builder setLocation(ArtifactLocation location);

    public abstract Artifact.Builder setParentIndex(Integer parentIndex);

    public abstract Artifact.Builder setOffset(Integer offset);

    public abstract Artifact.Builder setLength(Integer length);

    public abstract Artifact.Builder setRoles(List<ArtifactRole> roles);

    public abstract Artifact.Builder setMimeType(String mimeType);

    public abstract Artifact.Builder setEncoding(String encoding);

    public abstract Artifact.Builder setSourceLanguage(String sourceLanguage);

    public abstract Artifact.Builder setHashes(Map<String, String> hashes);

    public abstract Artifact.Builder setLastModifiedTimeUtc(Instant t);

    public abstract Artifact.Builder setProperties(PropertyBag bag);

    public abstract Artifact build();
  }
}
