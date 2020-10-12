package io.codescan.sarif.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * Metadata that describes a specific report produced by the tool, as part of the analysis it provides or its runtime
 * reporting.
 */
@AutoValue
public abstract class ReportingDescriptor {

    /**
     * A stable, opaque identifier for the report.
     */
    @JsonProperty("id")
    @Nullable
    public abstract String id();

    /**
     * An array of stable, opaque identifiers by which this report was known in some previous version of the analysis tool.
     */
    @JsonProperty("deprecatedIds")
    @Nullable
    public abstract List<String> deprecatedIds();

    /**
     * A report identifier that is understandable to an end user.
     */
    @JsonProperty("name")
    @Nullable
    public abstract String name();

    /**
     * An array of readable identifiers by which this report was known in some previous version of the analysis tool.
     */
    @JsonProperty("deprecatedNames")
    @Nullable
    public abstract List<String> deprecatedNames();

    /**
     * A unique identifier for the reporting descriptor in the form of a GUID.
     */
    @JsonProperty("guid")
    @Nullable
    public abstract String guid();

    /**
     * An array of unique identifies in the form of a GUID by which this report was known in some previous version of
     * the analysis tool.
     */
    @JsonProperty("deprecatedGuids")
    @Nullable
    public abstract List<String> deprecatedGuids();

    /**
     * A concise description of the report. Should be a single sentence that is understandable when visible space is
     * limited to a single line of text.
     */
    @JsonProperty("shortDescription")
    @Nullable
    public abstract MultiformatMessageString shortDescription();

    /**
     * A description of the report. Should, as far as possible, provide details sufficient to enable resolution of any
     * problem indicated by the result.
     */
    @JsonProperty("fullDescription")
    @Nullable
    public abstract MultiformatMessageString fullDescription();

    /**
     * A set of name/value pairs with arbitrary names. Each value is a multiformatMessageString object, which holds
     * message strings in plain text and (optionally) Markdown format. The strings can include placeholders, which can
     * be used to construct a message in combination with an arbitrary number of additional string arguments.
     */
    @JsonProperty("messageStrings")
    @Nullable
    public abstract Map<String, MultiformatMessageString> messageStrings();

    /**
     * Default reporting configuration information.
     */
    @JsonProperty("defaultConfiguration")
    @Nullable
    public abstract ReportingConfiguration defaultConfiguration();

    /**
     * A URI where the primary documentation for the report can be found.
     */
    @JsonProperty("helpUri")
    @Nullable
    public abstract String helpUri();

    /**
     * Provides the primary documentation for the report, useful when there is no online documentation.
     */
    @JsonProperty("help")
    @Nullable
    public abstract MultiformatMessageString help();

    /**
     * An array of objects that describe relationships between this reporting descriptor and others.
     */
    @JsonProperty("relationships")
    @Nullable
    public abstract List<ReportingDescriptorRelationship> relationships();

    /**
     * Key/value pairs that provide additional information about the report.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static ReportingDescriptor.Builder builder() {
        return new AutoValue_ReportingDescriptor.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract ReportingDescriptor.Builder setId(String id);
        public abstract ReportingDescriptor.Builder setDeprecatedIds(List<String> deprecatedIds);
        public abstract ReportingDescriptor.Builder setName(String name);
        public abstract ReportingDescriptor.Builder setDeprecatedNames(List<String> deprecatedNames);
        public abstract ReportingDescriptor.Builder setGuid(String guid);
        public abstract ReportingDescriptor.Builder setDeprecatedGuids(List<String> deprecatedGuids);
        public abstract ReportingDescriptor.Builder setShortDescription(MultiformatMessageString shortDescription);
        public abstract ReportingDescriptor.Builder setFullDescription(MultiformatMessageString fullDescription);
        public abstract ReportingDescriptor.Builder setMessageStrings(Map<String, MultiformatMessageString> messageStrings);
        public abstract ReportingDescriptor.Builder setDefaultConfiguration(ReportingConfiguration defaultConfiguration);
        public abstract ReportingDescriptor.Builder setHelpUri(String helpUri);
        public abstract ReportingDescriptor.Builder setHelp(MultiformatMessageString help);
        public abstract ReportingDescriptor.Builder setRelationships(List<ReportingDescriptorRelationship> relationships);
        public abstract ReportingDescriptor.Builder setProperties(PropertyBag properties);
        public abstract ReportingDescriptor build();
    }
}
