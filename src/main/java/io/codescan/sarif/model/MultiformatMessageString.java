package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/** A message string or message format string rendered in multiple formats. */
@AutoValue
public abstract class MultiformatMessageString {

  /** A plain text message string or format string. */
  @JsonProperty("text")
  public abstract String text();
  /** A Markdown message string or format string. */
  @JsonProperty("markdown")
  @Nullable
  public abstract String markdown();
  /** Key/value pairs that provide additional information about the message. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static MultiformatMessageString.Builder builder() {
    return new AutoValue_MultiformatMessageString.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract MultiformatMessageString.Builder setText(String text);

    public abstract MultiformatMessageString.Builder setMarkdown(String markdown);

    public abstract MultiformatMessageString.Builder setProperties(PropertyBag properties);

    public abstract MultiformatMessageString build();
  }
}
