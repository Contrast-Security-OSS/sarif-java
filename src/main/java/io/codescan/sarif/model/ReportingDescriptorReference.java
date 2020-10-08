package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
/**
 * Information about how to locate a relevant reporting descriptor.
 */
public class ReportingDescriptorReference {
    /**
     * The id of the descriptor.
     */
    private String id;
    /**
     * The index into an array of descriptors in toolComponent.ruleDescriptors, toolComponent.notificationDescriptors,
     * or toolComponent.taxonomyDescriptors, depending on context.
     */
    private Integer index;
    /**
     * A guid that uniquely identifies the descriptor.
     */
    private String guid;
    /**
     * A reference used to locate the toolComponent associated with the descriptor.
     */
    private ToolComponentReference toolComponent;
    /**
     * Key/value pairs that provide additional information about the reporting descriptor reference.
     */
    private PropertyBag properties;
}
