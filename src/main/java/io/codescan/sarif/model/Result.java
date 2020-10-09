package io.codescan.sarif.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A result produced by an analysis tool.
 */
@Data
@Accessors(chain = true)
public class Result {

    /**
     * The stable, unique identifier of the rule, if any, to which this result is relevant.
     */
    private String ruleId;
    /**
     * A reference used to locate the rule descriptor relevant to this result.
     */
    private Rule rule;
    /**
     * A value specifying the severity level of the result.
     */
    private Level level;
    /**
     * A message that describes the result. The first sentence of the message only will be displayed when visible
     * space is limited.
     */
    private Message message;
    /**
     * The set of locations where the result was detected. Specify only one location unless the problem indicated by
     * the result can only be corrected by making a change at every specified location.
     */
    private List<Location> locations;
    /**
     * A stable, unique identifer for the result in the form of a GUID.
     */
    private String guid;
    /**
     * A stable, unique identifier for the equivalence class of logically identical results to which this result
     * belongs, in the form of a GUID.
     */
    private String correlationGuid;
    /**
     * A positive integer specifying the number of times this logically unique result was observed in this run.
     */
    private Integer occurrenceCount;
    /**
     * A set of strings that contribute to the stable, unique identity of the result.
     */
    private Map<String, String> partialFingerprint;
    /**
     * A set of strings each of which individually defines a stable, unique identity for the result.
     */
    private Map<String, String> fingerprints;
    /**
     * An array of 'stack' objects relevant to the result.
     */
    private Set<Stack> stacks;
    /**
     * An array of 'codeFlow' objects relevant to the result.
     */
    private List<CodeFlow> codeFlows;
    /**
     * An array of zero or more unique graph objects associated with the result.
     */
    //private Set<Graph> graphs;
    /**
     * An array of one or more unique 'graphTraversal' objects.
     */
    //private Set<GraphTraversal> graphTraversals;
    /**
     * A set of locations relevant to this result.
     */
    private List<Location> relatedLocations;
    /**
     * A set of suppressions relevant to this result.
     */
    private Set<Suppression> suppressions;
    /**
     * The state of a result relative to a baseline of a previous run.
     */
    private BaselineState baselineState;
    /**
     * A number representing the priority or importance of the result.
     */
    private Number rank;
    /**
     * A set of artifacts relevant to the result.
     */
    //private Set<Attachment> attachments;
    /**
     * An absolute URI at which the result can be viewed.
     */
    private String hostedViewerUri;
    /**
     * The URIs of the work items associated with this result.
     */
    private List<String> workItemUris;
    /**
     * Information about how and when the result was detected.
     */
    //private ResultProvenance provenance;
    /**
     * An array of 'fix' objects, each of which represents a proposed fix to the problem indicated by the result.
     */
    //private List<Fix> fixes;
    /**
     * An array of references to taxonomy reporting descriptors that are applicable to the result.
     */
    private List<ReportingDescriptorReference> taxa;
    /**
     * A web request associated with this result.
     */
    //private WebRequest webRequest;
    /**
     * A web response associated with this result
     */
    //private WebResponse webResponse;
    /**
     * Key/value pairs that provide additional information about the result
     */
    private PropertyBag properties;
}
