package io.codescan.sarif.model;

import java.util.LinkedHashSet;
import java.util.Map;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Key/value pairs that provide additional information about the object.
 */
@Data
@Accessors(chain=true)
public class PropertyBag {

    Map<String, String> properties;
    /**
     * A set of distinct strings that provide additional information.
     *
     * The object is a LinkedHashSet implementation because lists in json are considered ordered.
     */
    private LinkedHashSet<String> tags;
}
