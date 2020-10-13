package io.codescan.sarif.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * A result produced by an analysis tool.
 */
@AutoValue
public abstract class Result {

    /**
     * The stable, unique identifier of the rule, if any, to which this result is relevant.
     */
    @JsonProperty("ruleId")
    @Nullable
    public abstract String ruleId();
    /**
     * A reference used to locate the rule descriptor relevant to this result.
     */
    @JsonProperty("rule")
    @Nullable
    public abstract Rule rule();
    /**
     * A value specifying the severity level of the result.
     */
    @JsonProperty("level")
    @Nullable
    public abstract Level level();
    /**
     * A message that describes the result. The first sentence of the message only will be displayed when visible
     * space is limited.
     */
    @JsonProperty("message")
    public abstract Message message();
    /**
     * The set of locations where the result was detected. Specify only one location unless the problem indicated by
     * the result can only be corrected by making a change at every specified location.
     */
    @JsonProperty("locations")
    @Nullable
    public abstract List<Location> locations();
    /**
     * A stable, unique identifer for the result in the form of a GUID.
     */
    @JsonProperty("guid")
    @Nullable
    public abstract String guid();
    /**
     * A stable, unique identifier for the equivalence class of logically identical results to which this result
     * belongs, in the form of a GUID.
     */
    @JsonProperty("correlationGuid")
    @Nullable
    public abstract String correlationGuid();
    /**
     * A positive integer specifying the number of times this logically unique result was observed in this run.
     */
    @JsonProperty("occurrenceCount")
    @Nullable
    public abstract Integer occurrenceCount();
    /**
     * A set of strings that contribute to the stable, unique identity of the result.
     */
    @JsonProperty("partialFingerprint")
    @Nullable
    public abstract Map<String, String> partialFingerprint();
    /**
     * A set of strings each of which individually defines a stable, unique identity for the result.
     */
    @JsonProperty("fingerprints")
    @Nullable
    public abstract Map<String, String> fingerprints();
    /**
     * An array of 'stack' objects relevant to the result.
     */
    @JsonProperty("stacks")
    @Nullable
    public abstract Set<Stack> stacks();
    /**
     * An array of 'codeFlow' objects relevant to the result.
     */
    @JsonProperty("codeFlows")
    @Nullable
    public abstract List<CodeFlow> codeFlows();
    /**
     * An array of zero or more unique graph objects associated with the result.
     */
    //@JsonProperty("graphs")
    //@Nullable
    //TODO: public abstract Set<Graph> graphs();
    /**
     * An array of one or more unique 'graphTraversal' objects.
     */
    //@JsonProperty("graphTraversals")
    //@Nullable
    //TODO: public abstract Set<GraphTraversal> graphTraversals();
    /**
     * A set of locations relevant to this result.
     */
    @JsonProperty("relatedLocations")
    @Nullable
    public abstract List<Location> relatedLocations();
    /**
     * A set of suppressions relevant to this result.
     */
    @JsonProperty("suppressions")
    @Nullable
    public abstract Set<Suppression> suppressions();
    /**
     * The state of a result relative to a baseline of a previous run.
     */
    @JsonProperty("baselineState")
    @Nullable
    public abstract BaselineState baselineState();
    /**
     * A number representing the priority or importance of the result.
     */
    @JsonProperty("rank")
    @Nullable
    public abstract Number rank();
    /**
     * A set of artifacts relevant to the result.
     */
    //@JsonProperty("attachments")
    //@Nullable
    //TODO: public abstract Set<Attachment> attachments();
    /**
     * An absolute URI at which the result can be viewed.
     */
    @JsonProperty("hostedViewerUri")
    @Nullable
    public abstract String hostedViewerUri();
    /**
     * The URIs of the work items associated with this result.
     */
    @JsonProperty("workItemUris")
    @Nullable
    public abstract List<String> workItemUris();
    /**
     * Information about how and when the result was detected.
     */
    //@JsonProperty("provenance")
    //@Nullable
    //TODO: public abstract ResultProvenance provenance();
    /**
     * An array of 'fix' objects, each of which represents a proposed fix to the problem indicated by the result.
     */
    //@JsonProperty("fixes")
    //@Nullable
    //TODO: public abstract List<Fix> fixes();
    /**
     * An array of references to taxonomy reporting descriptors that are applicable to the result.
     */
    @JsonProperty("taxa")
    @Nullable
    public abstract List<ReportingDescriptorReference> taxa();
    /**
     * A web request associated with this result.
     */
    //@JsonProperty("webRequest")
    //@Nullable
    //TODO: public abstract WebRequest webRequest();
    /**
     * A web response associated with this result
     */
    //@JsonProperty("webResponse")
    //@Nullable
    //TODO: public abstract WebResponse webResponse();
    /**
     * Key/value pairs that provide additional information about the result
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();

    public static Result.Builder builder() {
        return new AutoValue_Result.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Result.Builder setRuleId(String ruleId);
        public abstract Result.Builder setRule(Rule rule);
        public abstract Result.Builder setLevel(Level level);
        public abstract Result.Builder setMessage(Message message);
        public abstract Result.Builder setLocations(List<Location> locations);
        public abstract Result.Builder setGuid(String guid);
        public abstract Result.Builder setCorrelationGuid(String correlationGuid);
        public abstract Result.Builder setOccurrenceCount(Integer occurrenceCount);
        public abstract Result.Builder setPartialFingerprint(Map<String, String> partialFingerprint);
        public abstract Result.Builder setFingerprints(Map<String, String> fingerprints);
        public abstract Result.Builder setStacks(Set<Stack> stacks);
        public abstract Result.Builder setCodeFlows(List<CodeFlow> codeFlows);
        //public abstract Result.Builder setGraphs(Set<Graph> graphs);
        //public abstract Result.Builder setGraphTraversals(Set<GraphTraversal> graphTraversals);
        public abstract Result.Builder setRelatedLocations(List<Location> relatedLocations);
        public abstract Result.Builder setSuppressions(Set<Suppression> suppressions);
        public abstract Result.Builder setBaselineState(BaselineState baselineState);
        public abstract Result.Builder setRank(Number rank);
        //public abstract Result.Builder setAttachments(Set<Attachment> attachments);
        public abstract Result.Builder setHostedViewerUri(String hostedViewerUri);
        public abstract Result.Builder setWorkItemUris(List<String> workItemUris);
        //public abstract Result.Builder setProvenance(ResultProvenance provenance);
        //public abstract Result.Builder setFixes(List<Fix> fixes);
        public abstract Result.Builder setTaxa(List<ReportingDescriptorReference> taxa);
        //public abstract Result.Builder setWebRequest(WebRequest webRequest);
        //public abstract Result.Builder setWebResponse(WebResponse webResponse);
        public abstract Result.Builder setProperties(PropertyBag properties);
        public abstract Result build();
    }
}
