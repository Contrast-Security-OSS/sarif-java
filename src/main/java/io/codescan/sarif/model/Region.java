package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/** A region within an artifact where a result was detected. */
@AutoValue
public abstract class Region {

  /** The line number of the first character in the region. */
  @JsonProperty("startLine")
  @Nullable
  public abstract Integer startLine();

  /** The column number of the first character in the region. */
  @JsonProperty("startColumn")
  @Nullable
  public abstract Integer startColumn();

  /** The line number of the last character in the region. */
  @JsonProperty("endLine")
  @Nullable
  public abstract Integer endLine();

  /** The column number of the character following the end of the region. */
  @JsonProperty("endColumn")
  @Nullable
  public abstract Integer endColumn();

  /**
   * The zero-based offset from the beginning of the artifact of the first character in the region.
   */
  @JsonProperty("charOffset")
  @Nullable
  public abstract Integer charOffset();

  /** The length of the region in characters. */
  @JsonProperty("charLength")
  @Nullable
  public abstract Integer charLength();

  /** The zero-based offset from the beginning of the artifact of the first byte in the region. */
  @JsonProperty("byteOffset")
  @Nullable
  public abstract Integer byteOffset();

  /** A message relevant to the region. */
  @JsonProperty("message")
  @Nullable
  public abstract Message message();

  public static Region.Builder builder() {
    return new AutoValue_Region.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Region.Builder setStartLine(Integer startLine);

    public abstract Region.Builder setStartColumn(Integer startColumn);

    public abstract Region.Builder setEndLine(Integer endLine);

    public abstract Region.Builder setEndColumn(Integer endColumn);

    public abstract Region.Builder setCharOffset(Integer charOffset);

    public abstract Region.Builder setCharLength(Integer charLength);

    public abstract Region.Builder setByteOffset(Integer byteOffset);

    public abstract Region.Builder setMessage(Message message);

    public abstract Region build();
  }
}
