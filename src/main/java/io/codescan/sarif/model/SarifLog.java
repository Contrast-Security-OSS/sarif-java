package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.List;

/** Static Analysis Results. */
@AutoValue
public abstract class SarifLog {

  /** The URI of the JSON schema corresponding to the version. */
  @JsonProperty("$schema")
  public abstract String schema();
  /** The SARIF format version of this log file. */
  @JsonProperty("version")
  public abstract String version();
  /** The set of runs contained in this log file. */
  @JsonProperty("runs")
  public abstract List<Run> runs();

  public static SarifLog.Builder builder() {
    return new AutoValue_SarifLog.Builder()
        .setSchema(
            "https://raw.githubusercontent.com/oasis-tcs/sarif-spec/master/Schemata/sarif-schema-2.1.0.json")
        .setVersion("2.1.0");
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract SarifLog.Builder setSchema(String schema);

    public abstract SarifLog.Builder setVersion(String version);

    public abstract SarifLog.Builder setRuns(List<Run> runs);

    public abstract SarifLog build();
  }
}
