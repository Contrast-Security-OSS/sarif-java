package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * Information about the relation of one reporting descriptor to another.
 */
@Data
@Accessors(chain = true)
public class ReportingDescriptorRelationship {
    /**
     * A reference to the related reporting descriptor.
     */
    private ReportingDescriptorReference target;
    /**
     * A set of distinct strings that categorize the relationship. Well-known kinds include 'canPrecede', 'canFollow',
     * 'willPrecede', 'willFollow', 'superset', 'subset', 'equal', 'disjoint', 'relevant', and 'incomparable'.
     */
    private Set<String> kinds;
    /**
     * A description of the reporting descriptor relationship.
     */
    private Message description;
    /**
     * "Key/value pairs that provide additional information about the reporting descriptor reference.
     */
    private PropertyBag properties;
}
