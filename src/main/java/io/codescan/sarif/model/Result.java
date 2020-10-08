package io.codescan.sarif.model;

import java.util.List;
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

    private String guid;
    private String correlationGuid;
    private Integer occuranceCount;
    private Set<Stack> stacks;
    private List<CodeFlow> codeFlows;
    private List<Location> relatedLocations;
    private BaselineState baselineState;
    private Number rank;
    private String hostedViewerUri;

    private PropertyBag properties;
}
