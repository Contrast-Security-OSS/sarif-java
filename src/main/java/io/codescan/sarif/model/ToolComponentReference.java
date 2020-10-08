package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Identifies a particular toolComponent object, either the driver or an extension.
 */
@Data
@Accessors(chain = true)
public class ToolComponentReference {
    /**
     * The 'name' property of the referenced toolComponent.
     */
    private String name;
    /**
     * An index into the referenced toolComponent in tool.extensions.
     */
    private Integer index;
    /**
     * The 'guid' property of the referenced toolComponent.
     */
    private String guid;
    /**
     * Key/value pairs that provide additional information about the toolComponentReference.
     */
    private PropertyBag properties;
}
