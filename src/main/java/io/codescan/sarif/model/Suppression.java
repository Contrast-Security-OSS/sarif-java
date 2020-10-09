package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A suppression that is relevant to a result.
 */
@Data
@Accessors(chain = true)
public class Suppression {
    /**
     * A stable, unique identifer for the suprression in the form of a GUID.
     */
    private String guid;
    /**
     * A string that indicates where the suppression is persisted.
     */
    //TODO: private Kind kind;
    /**
     * A string that indicates the review status of the suppression.
     */
    //TODO: private Status status;
    /**
     * A string representing the justification for the suppression.
     */
    private String justification;
    /**
     * Identifies the location associated with the suppression.
     */
    private Location location;
    /**
     * Key/value pairs that provide additional information about the suppression.
     */
    private PropertyBag properties;
}
