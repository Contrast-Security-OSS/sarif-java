package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/** Encapsulates a message intended to be read by the end user. */
@AutoValue
public abstract class Message {

  /** A plain text message string. */
  @JsonProperty("text")
  @Nullable
  public abstract String text();

  /** A Markdown message string. */
  @JsonProperty("markdown")
  @Nullable
  public abstract String markdown();

  /** The identifier for this message. */
  @JsonProperty("id")
  @Nullable
  public abstract String id();

  public static Message.Builder builder() {
    return new AutoValue_Message.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Message.Builder setText(String text);

    public abstract Message.Builder setMarkdown(String markdown);

    public abstract Message.Builder setId(String id);

    public abstract Message build();
  }
}
