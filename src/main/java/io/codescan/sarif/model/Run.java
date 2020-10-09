package io.codescan.sarif.model;

import java.util.List;
import java.util.Map;

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
     * Describes the invocation of the analysis tool.
     */
    private List<Invocation> invocations;
    /**
     * A conversion object that describes how a converter transformed an analysis tool's native reporting format into
     * the SARIF format.
     */
    private Conversion conversion;
    /**
     * The language of the messages emitted into the log file during this run (expressed as an ISO 639-1 two-letter
     * lowercase culture code) and an optional region (expressed as an ISO 3166-1 two-letter uppercase subculture code
     * associated with a country or region). The casing is recommended but not required (in order for this data to
     * conform to RFC5646).
     */
    private String language;
    /**
     * Specifies the revision in version control of the artifacts that were scanned.
     */
    //TODO: private List<VersionControlDetails> versionControlsProvenance;
    /**
     * The artifact location specified by each uriBaseId symbol on the machine where the tool originally ran.
     */
    private Map<String, ArtifactLocation> originalUriBaseIds;
    /**
     * An array of artifact objects relevant to the run.
     */
    private List<Artifact> artifacts;
    /**
     * An array of logical locations such as namespaces, types or functions.
     */
    private List<LogicalLocation> logicalLocations;
    /**
     * An array of zero or more unique graph objects associated with the run.
     */
    //TODO: private List<Graph> graphs;
    /**
     * The set of results contained in an SARIF log. The results array can be omitted when a run is solely exporting
     * rules metadata. It must be present (but may be empty) if a log file represents an actual scan.
     */
    private List<Result> results;
    /**
     * Automation details that describe this run.
     */
    //TODO: private RunAutomationDetails automationDetails;
    /**
     * Automation details that describe the aggregate of runs to which this run belongs.
     */
    //TODO: private List<RunAutomationDetails> runAggregates;
    /**
     * The 'guid' property of a previous SARIF 'run' that comprises the baseline that was used to compute result
     * 'baselineState' properties for the run.
     */
    private String baselineGuid;
    /**
     * An array of strings used to replace sensitive information in a redaction-aware property.
     */
    private List<String> redactionTokens;
    /**
     * Specifies the default encoding for any artifact object that refers to a text file.
     */
    private String defaultEncoding;
    /**
     * Specifies the default source language for any artifact object that refers to a text file that contains source
     * code
     */
    private String defaultSourceLanguage;
    /**
     * An ordered list of character sequences that were treated as line breaks when computing region information for
     * the run.
     */
    private List<String> newlineSequences;
    /**
     * Specifies the unit in which the tool measures columns.
     */
    //TODO: private ColumnKind columnKind;
    /**
     * References to external property files that should be inlined with the content of a root log file.
     */
    //TODO: private ExternalPropertyFileReference externalPropertyFileReference;
    /**
     * An array of threadFlowLocation objects cached at run level.
     */
    private List<ThreadFlowLocation> threadFlowLocations;
    /**
     * An array of toolComponent objects relevant to a taxonomy in which results are categorized.
     */
    private List<ToolComponent> taxonomies;
    /**
     * Addresses associated with this run instance, if any.
     */
    private List<Address> addresses;
    /**
     * The set of available translations of the localized data provided by the tool.
     */
    private List<ToolComponent> translations;
    /**
     * Contains configurations that may potentially override both reportingDescriptor.defaultConfiguration (the tool's
     * default severities) and invocation.configurationOverrides (severities established at run-time from the command
     * line).
     */
    private List<ToolComponent> policies;
    /**
     * An array of request objects cached at run level.
     */
    //TODO: private List<WebRequest> webRequests;
    /**
     * An array of response objects cached at run level.
     */
    //TODO: private List<WebResponse> webResponses;
}
