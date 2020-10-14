package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/** Describes a single run of an analysis tool, and contains the reported output of that run. */
@AutoValue
public abstract class Run {
  /**
   * Information about the tool or tool pipeline that generated the results in this run. A run can
   * only contain results produced by a single tool or tool pipeline. A run can aggregate results
   * from multiple log files, as long as context around the tool run (tool command-line arguments
   * and the like) is identical for all aggregated files.
   */
  @JsonProperty("tool")
  public abstract Tool tool();
  /** Describes the invocation of the analysis tool. */
  @JsonProperty("invocations")
  @Nullable
  public abstract List<Invocation> invocations();
  /**
   * A conversion object that describes how a converter transformed an analysis tool's native
   * reporting format into the SARIF format.
   */
  @JsonProperty("conversion")
  @Nullable
  public abstract Conversion conversion();
  /**
   * The language of the messages emitted into the log file during this run (expressed as an ISO
   * 639-1 two-letter lowercase culture code) and an optional region (expressed as an ISO 3166-1
   * two-letter uppercase subculture code associated with a country or region). The casing is
   * recommended but not required (in order for this data to conform to RFC5646).
   */
  @JsonProperty("language")
  @Nullable
  public abstract String language();
  /** Specifies the revision in version control of the artifacts that were scanned. */
  // @JsonProperty("versionControlsProvenance")
  // @Nullable
  // TODO: public abstract List<VersionControlDetails> versionControlsProvenance();
  /**
   * The artifact location specified by each uriBaseId symbol on the machine where the tool
   * originally ran.
   */
  @JsonProperty("originalUriBaseIds")
  @Nullable
  public abstract Map<String, ArtifactLocation> originalUriBaseIds();
  /** An array of artifact objects relevant to the run. */
  @JsonProperty("artifacts")
  @Nullable
  public abstract List<Artifact> artifacts();
  /** An array of logical locations such as namespaces, types or functions. */
  @JsonProperty("logicalLocations")
  @Nullable
  public abstract List<LogicalLocation> logicalLocations();
  /** An array of zero or more unique graph objects associated with the run. */
  // @JsonProperty("graphs")
  // @Nullable
  // TODO: public abstract List<Graph> graphs();
  /**
   * The set of results contained in an SARIF log. The results array can be omitted when a run is
   * solely exporting rules metadata. It must be present (but may be empty) if a log file represents
   * an actual scan.
   */
  @JsonProperty("results")
  @Nullable
  public abstract List<Result> results();
  /** Automation details that describe this run. */
  // @JsonProperty("automationDetails")
  // @Nullable
  // TODO: public abstract RunAutomationDetails automationDetails();
  /** Automation details that describe the aggregate of runs to which this run belongs. */
  // @JsonProperty("runAggregates")
  // @Nullable
  // TODO: public abstract List<RunAutomationDetails> runAggregates();
  /**
   * The 'guid' property of a previous SARIF 'run' that comprises the baseline that was used to
   * compute result 'baselineState' properties for the run.
   */
  @JsonProperty("baselineGuid")
  @Nullable
  public abstract String baselineGuid();
  /** An array of strings used to replace sensitive information in a redaction-aware property. */
  @JsonProperty("redactionTokens")
  @Nullable
  public abstract List<String> redactionTokens();
  /** Specifies the default encoding for any artifact object that refers to a text file. */
  @JsonProperty("defaultEncoding")
  @Nullable
  public abstract String defaultEncoding();
  /**
   * Specifies the default source language for any artifact object that refers to a text file that
   * contains source code
   */
  @JsonProperty("defaultSourceLanguage")
  @Nullable
  public abstract String defaultSourceLanguage();
  /**
   * An ordered list of character sequences that were treated as line breaks when computing region
   * information for the run.
   */
  @JsonProperty("newlineSequences")
  @Nullable
  public abstract List<String> newlineSequences();
  /** Specifies the unit in which the tool measures columns. */
  // @JsonProperty("columnKind")
  // @Nullable
  // TODO: public abstract ColumnKind columnKind();
  /**
   * References to external property files that should be inlined with the content of a root log
   * file.
   */
  // @JsonProperty("externalPropertyFileReference")
  // @Nullable
  // TODO: public abstract ExternalPropertyFileReference externalPropertyFileReference();
  /** An array of threadFlowLocation objects cached at run level. */
  @JsonProperty("threadFlowLocations")
  @Nullable
  public abstract List<ThreadFlowLocation> threadFlowLocations();
  /** An array of toolComponent objects relevant to a taxonomy in which results are categorized. */
  @JsonProperty("taxonomies")
  @Nullable
  public abstract List<ToolComponent> taxonomies();
  /** Addresses associated with this run instance, if any. */
  @JsonProperty("addresses")
  @Nullable
  public abstract List<Address> addresses();
  /** The set of available translations of the localized data provided by the tool. */
  @JsonProperty("translations")
  @Nullable
  public abstract List<ToolComponent> translations();
  /**
   * Contains configurations that may potentially override both
   * reportingDescriptor.defaultConfiguration (the tool's default severities) and
   * invocation.configurationOverrides (severities established at run-time from the command line).
   */
  @JsonProperty("policies")
  @Nullable
  public abstract List<ToolComponent> policies();
  /** An array of request objects cached at run level. */
  // @JsonProperty("webRequests")
  // @Nullable
  // TODO: public abstract List<WebRequest> webRequests();
  /** An array of response objects cached at run level. */
  // @JsonProperty("webResponses")
  // @Nullable
  // TODO: public abstract List<WebResponse> webResponses();

  public static Run.Builder builder() {
    return new AutoValue_Run.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Run.Builder setTool(Tool tool);

    public abstract Run.Builder setInvocations(List<Invocation> invocations);

    public abstract Run.Builder setConversion(Conversion conversion);

    public abstract Run.Builder setLanguage(String language);
    // public abstract Run.Builder setVersionControlsProvenance(List<VersionControlDetails>
    // versionControlsProvenance);
    public abstract Run.Builder setOriginalUriBaseIds(
        Map<String, ArtifactLocation> originalUriBaseIds);

    public abstract Run.Builder setArtifacts(List<Artifact> artifacts);

    public abstract Run.Builder setLogicalLocations(List<LogicalLocation> logicalLocations);
    // public abstract Run.Builder setGraphs(List<Graph> graphs);
    public abstract Run.Builder setResults(List<Result> results);
    // public abstract Run.Builder setAutomationDetails(RunAutomationDetails automationDetails);
    // public abstract Run.Builder setRunAggregates(List<RunAutomationDetails> runAggregates);
    public abstract Run.Builder setBaselineGuid(String baselineGuid);

    public abstract Run.Builder setRedactionTokens(List<String> redactionTokens);

    public abstract Run.Builder setDefaultEncoding(String defaultEncoding);

    public abstract Run.Builder setDefaultSourceLanguage(String defaultSourceLanguage);

    public abstract Run.Builder setNewlineSequences(List<String> newlineSequences);
    // public abstract Run.Builder setColumnKind(ColumnKind columnKind);
    // public abstract Run.Builder setExternalPropertyFileReference(ExternalPropertyFileReference
    // externalPropertyFileReference);
    public abstract Run.Builder setThreadFlowLocations(
        List<ThreadFlowLocation> threadFlowLocations);

    public abstract Run.Builder setTaxonomies(List<ToolComponent> taxonomies);

    public abstract Run.Builder setAddresses(List<Address> addresses);

    public abstract Run.Builder setTranslations(List<ToolComponent> translations);

    public abstract Run.Builder setPolicies(List<ToolComponent> policies);
    // public abstract Run.Builder setWebRequests(List<WebRequest> webRequests);
    // public abstract Run.Builder setWebResponses(List<WebResponse> webResponses);
    public abstract Run build();
  }
}
