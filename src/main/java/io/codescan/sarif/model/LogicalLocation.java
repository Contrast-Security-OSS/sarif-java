package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
/**
 * A logical location of a construct that produced a result.
 */
public class LogicalLocation {
    /**
     * Identifies the construct in which the result occurred. For example, this property might contain the name of a
     * class or a method.
     */
    private String name;
    /**
     * The index within the logical locations array.
     */
    private Integer index;
    /**
     * The human-readable fully qualified name of the logical location.
     */
    private String fullyQualifiedName;
    /**
     * The machine-readable name for the logical location, such as a mangled function name provided by a C++ compiler
     * that encodes calling convention, return type and other details along with the function name.
     */
    private String decoratedName;
    /**
     * Identifies the index of the immediate parent of the construct in which the result was detected. For example,
     * this property might point to a logical location that represents the namespace that holds a type.
     */
    private Integer parentIndex;
    /**
     * The type of construct this logical location component refers to. Should be one of 'function', 'member',
     * 'module', 'namespace', 'parameter', 'resource', 'returnType', 'type', 'variable', 'object', 'array', 'property',
     * 'value', 'element', 'text', 'attribute', 'comment', 'declaration', 'dtd' or 'processingInstruction', if any of
     * those accurately describe the construct.
     */
    private String kind;
    /**
     * Key/value pairs that provide additional information about the logical location.
     */
    private PropertyBag properties;
}
