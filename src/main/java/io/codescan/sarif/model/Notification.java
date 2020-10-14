package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.time.Instant;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/**
 * Describes a condition relevant to the tool itself, as opposed to being relevant to a target being
 * analyzed by the tool.
 */
@AutoValue
public abstract class Notification {
  /** The locations relevant to this notification. */
  @JsonProperty("locations")
  @Nullable
  public abstract List<Location> locations();
  /** A message that describes the condition that was encountered. */
  @JsonProperty("message")
  @Nullable
  public abstract Message message();
  /** A value specifying the severity level of the notification. */
  @JsonProperty("level")
  @Nullable
  public abstract Level level();
  /** The thread identifier of the code that generated the notification. */
  @JsonProperty("threadId")
  @Nullable
  public abstract Integer threadId();
  /**
   * The Coordinated Universal Time (UTC) date and time at which the analysis tool generated the
   * notification.
   */
  @JsonProperty("timeUtc")
  @Nullable
  public abstract Instant timeUtc();
  /** The runtime exception, if any, relevant to this notification. */
  @JsonProperty("exception")
  @Nullable
  public abstract Exception exception();
  /** A reference used to locate the descriptor relevant to this notification. */
  @JsonProperty("descriptor")
  @Nullable
  public abstract ReportingDescriptorReference descriptor();
  /** A reference used to locate the rule descriptor associated with this notification. */
  @JsonProperty("associatedRule")
  @Nullable
  public abstract ReportingDescriptorReference associatedRule();
  /** Key/value pairs that provide additional information about the notification. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static Notification.Builder builder() {
    return new AutoValue_Notification.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Notification.Builder setLocations(List<Location> locations);

    public abstract Notification.Builder setMessage(Message message);

    public abstract Notification.Builder setLevel(Level level);

    public abstract Notification.Builder setThreadId(Integer threadId);

    public abstract Notification.Builder setTimeUtc(Instant timeUtc);

    public abstract Notification.Builder setException(Exception exception);

    public abstract Notification.Builder setDescriptor(ReportingDescriptorReference descriptor);

    public abstract Notification.Builder setAssociatedRule(
        ReportingDescriptorReference associatedRule);

    public abstract Notification.Builder setProperties(PropertyBag properties);

    public abstract Notification build();
  }
}
