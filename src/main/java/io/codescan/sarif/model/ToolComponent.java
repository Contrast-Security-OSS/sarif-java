package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/** A component, such as a plug-in or the driver, of the analysis tool that was run. */
@AutoValue
public abstract class ToolComponent {

  /**
   * A unique identifier for the tool component in the form of a GUID.
   *
   * <p>public static ToolComponent.Builder builder() { return new
   * AutoValue_ToolComponent.Builder(); } @AutoValue.Builder public abstract static class Builder {
   * public abstract ToolComponent build(); } Pattern:
   * ^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$
   */
  @JsonProperty("guid")
  @Nullable
  public abstract String guid();

  /** The name of the tool component. */
  @JsonProperty("name")
  public abstract String name();

  /** The organization or company that produced the tool component. */
  @JsonProperty("organization")
  @Nullable
  public abstract String organization();

  /** A product suite to which the tool component belongs. */
  @JsonProperty("product")
  @Nullable
  public abstract String product();

  /**
   * A localizable string containing the name of the suite of products to which the tool component
   * belongs.
   */
  @JsonProperty("productSuite")
  @Nullable
  public abstract String productSuite();

  /** A brief description of the tool component. */
  @JsonProperty("shortDescription")
  @Nullable
  public abstract MultiformatMessageString shortDescription();

  /** A comprehensive description of the tool component. */
  @JsonProperty("fullDescription")
  @Nullable
  public abstract MultiformatMessageString fullDescription();

  /**
   * The name of the tool component along with its version and any other useful identifying
   * information, such as its locale.
   */
  @JsonProperty("fullName")
  @Nullable
  public abstract String fullName();

  /** The tool component version, in whatever format the component natively provides. */
  @JsonProperty("version")
  @Nullable
  public abstract String version();

  /** The tool component version in the format specified by Semantic Versioning 2.0. */
  @JsonProperty("semanticVersion")
  @Nullable
  public abstract String semanticVersion();

  /**
   * The binary version of the tool component's primary executable file expressed as four
   * non-negative integers separated by a period (for operating systems that express file versions
   * in this way).
   */
  @JsonProperty("dottedQuadFileVersion")
  @Nullable
  public abstract String dottedQuadFileVersion();

  /** A string specifying the UTC date (and optionally, the time) of the component's release. */
  @JsonProperty("releaseDateUtc")
  @Nullable
  public abstract String releaseDateUtc();

  /** The absolute URI from which the tool component can be downloaded. */
  @JsonProperty("downloadUri")
  @Nullable
  public abstract String downloadUri();

  /**
   * The absolute URI at which information about this version of the tool component can be found.
   */
  @JsonProperty("informationUri")
  @Nullable
  public abstract String informationUri();

  /**
   * A dictionary, each of whose keys is a resource identifier and each of whose values is a
   * multiformatMessageString object, which holds message strings in plain text and (optionally)
   * Markdown format. The strings can include placeholders, which can be used to construct a message
   * in combination with an arbitrary number of additional string arguments.
   */
  @JsonProperty("globalMessageStrings")
  @Nullable
  public abstract Map<String, MultiformatMessageString> globalMessageStrings();

  /**
   * An array of reportingDescriptor objects relevant to the notifications related to the
   * configuration and runtime execution of the tool component.
   */
  @JsonProperty("notifications")
  @Nullable
  public abstract List<ReportingDescriptor> notifications();

  /**
   * An array of reportingDescriptor objects relevant to the analysis performed by the tool
   * component.
   */
  @JsonProperty("rules")
  @Nullable
  public abstract List<ReportingDescriptor> rules();

  /**
   * An array of reportingDescriptor objects relevant to the definitions of both standalone and
   * tool-defined taxonomies.
   */
  @JsonProperty("taxa")
  @Nullable
  public abstract List<ReportingDescriptor> taxa();

  /** An array of the artifactLocation objects associated with the tool component. */
  @JsonProperty("locations")
  @Nullable
  public abstract ArtifactLocation locations();

  /**
   * The language of the messages emitted into the log file during this run (expressed as an ISO
   * 639-1 two-letter lowercase language code) and an optional region (expressed as an ISO 3166-1
   * two-letter uppercase subculture code associated with a country or region). The casing is
   * recommended but not required (in order for this data to conform to RFC5646).
   */
  @JsonProperty("language")
  @Nullable
  public abstract String language();

  /** Key/value pairs that provide additional information about the tool component. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static ToolComponent.Builder builder() {
    return new AutoValue_ToolComponent.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract ToolComponent.Builder setGuid(String guid);

    public abstract ToolComponent.Builder setName(String name);

    public abstract ToolComponent.Builder setOrganization(String organization);

    public abstract ToolComponent.Builder setProduct(String product);

    public abstract ToolComponent.Builder setProductSuite(String productSuite);

    public abstract ToolComponent.Builder setShortDescription(
        MultiformatMessageString shortDescription);

    public abstract ToolComponent.Builder setFullDescription(
        MultiformatMessageString fullDescription);

    public abstract ToolComponent.Builder setFullName(String fullName);

    public abstract ToolComponent.Builder setVersion(String version);

    public abstract ToolComponent.Builder setSemanticVersion(String semanticVersion);

    public abstract ToolComponent.Builder setDottedQuadFileVersion(String dottedQuadFileVersion);

    public abstract ToolComponent.Builder setReleaseDateUtc(String releaseDateUtc);

    public abstract ToolComponent.Builder setDownloadUri(String downloadUri);

    public abstract ToolComponent.Builder setInformationUri(String informationUri);

    public abstract ToolComponent.Builder setGlobalMessageStrings(
        Map<String, MultiformatMessageString> globalMessageStrings);

    public abstract ToolComponent.Builder setNotifications(List<ReportingDescriptor> notifications);

    public abstract ToolComponent.Builder setRules(List<ReportingDescriptor> rules);

    public abstract ToolComponent.Builder setTaxa(List<ReportingDescriptor> taxa);

    public abstract ToolComponent.Builder setLocations(ArtifactLocation locations);

    public abstract ToolComponent.Builder setLanguage(String language);

    public abstract ToolComponent.Builder setProperties(PropertyBag properties);

    public abstract ToolComponent build();
  }
}
