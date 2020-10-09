package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.List;

/**
 * Describes a condition relevant to the tool itself, as opposed to being relevant to a target being analyzed by the
 * tool.
 */
@Data
@Accessors(chain = true)
public class Notification {
    /**
     * The locations relevant to this notification.
     */
    private List<Location> locations;
    /**
     * A message that describes the condition that was encountered.
     */
    private Message message;
    /**
     * A value specifying the severity level of the notification.
     */
    private Level level;
    /**
     * The thread identifier of the code that generated the notification.
     */
    private Integer threadId;
    /**
     * The Coordinated Universal Time (UTC) date and time at which the analysis tool generated the notification.
     */
    private Instant timeUtc;
    /**
     * The runtime exception, if any, relevant to this notification.
     */
    //TODO: private Exception_ exception;
    /**
     * A reference used to locate the descriptor relevant to this notification.
     */
    private ReportingDescriptorReference descriptor;
    /**
     * A reference used to locate the rule descriptor associated with this notification.
     */
    private ReportingDescriptorReference associatedRule;
    /**
     * Key/value pairs that provide additional information about the notification.
     */
    private PropertyBag properties;
}
