package io.codescan.sarif.model;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Describes a single run of an analysis tool, and contains the reported output of that run.
 */
@Data
@Accessors(chain = true)
public class Run {
    /**
     * Information about the tool or tool pipeline that generated the results in this run. A run can only contain
     * results produced by a single tool or tool pipeline. A run can aggregate results from multiple log files, as long
     * as context around the tool run (tool command-line arguments and the like) is identical for all aggregated files.
     */
    private Tool tool;
    /**
     * The language of the messages emitted into the log file during this run (expressed as an ISO 639-1 two-letter
     * lowercase culture code) and an optional region (expressed as an ISO 3166-1 two-letter uppercase subculture code
     * associated with a country or region). The casing is recommended but not required (in order for this data to
     * conform to RFC5646).
     */
    private String language;
    /**
     * An array of artifact objects relevant to the run.
     */
    private List<Artifact> artifacts;
    /**
     * An array of logical locations such as namespaces, types or functions.
     */
    private List<LogicalLocation> logicalLocations;
    /**
     * The set of results contained in an SARIF log. The results array can be omitted when a run is solely exporting
     * rules metadata. It must be present (but may be empty) if a log file represents an actual scan.
     */
    private List<Result> results;
    /**
     * The 'guid' property of a previous SARIF 'run' that comprises the baseline that was used to compute result
     * 'baselineState' properties for the run.
     */
    private String baselineGuid;

    /**
     * A call stack that is relevant to a result.
     */
    private Stack stack;
}
