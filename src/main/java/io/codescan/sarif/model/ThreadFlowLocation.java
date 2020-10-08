package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;
import java.util.Set;

@Data
@Accessors(chain = true)
/**
 * A location visited by an analysis tool while simulating or monitoring the execution of a program.
 */
public class ThreadFlowLocation {
    /**
     * The index within the run threadFlowLocations array.
     */
    private Integer index;
    /**
     * The code location.
     */
    private Location location;
    /**
     * The call stack leading to this location.
     */
    private Stack stack;
    /**
     * A set of distinct strings that categorize the thread flow location. Well-known kinds include 'acquire',
     * 'release', 'enter', 'exit', 'call', 'return', 'branch', 'implicit', 'false', 'true', 'caution', 'danger',
     * 'unknown', 'unreachable', 'taint', 'function', 'handler', 'lock', 'memory', 'resource', 'scope' and 'value'.
     */
    private Set<String> kinds;
    /**
     * An array of references to rule or taxonomy reporting descriptors that are applicable to the thread flow location.
     */
    private Set<ReportingDescriptorReference> taxa;
    /**
     * The name of the module that contains the code that is executing.
     */
    private String module;
    /**
     * A dictionary, each of whose keys specifies a variable or expression, the associated value of which represents
     * the variable or expression value. For an annotation of kind 'continuation', for example, this dictionary might
     * hold the current assumed values of a set of global variables.
     */
    private Map<String, MultiformatMessageString> state;
    /**
     * An integer representing a containment hierarchy within the thread flow.
     */
    private Integer nestingLevel;
    /**
     * An integer representing the temporal order in which execution reached this location.
     */
    private Integer executionOrder;

    //executionTimeUtc

    /**
     * Specifies the importance of this location in understanding the code flow in which it occurs. The order from most
     * to least important is "essential", "important", "unimportant".
     */
    private Importance importance;

    /**
     * Key/value pairs that provide additional information about the threadflow location.
     */
    private PropertyBag properties;
}
