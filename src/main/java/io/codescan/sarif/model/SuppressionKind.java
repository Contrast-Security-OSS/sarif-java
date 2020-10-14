package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** A string that indicates where the suppression is persisted. */
public enum SuppressionKind {
  @JsonProperty("inSource")
  INSOURCE,
  @JsonProperty("external")
  EXTERNAL
}
