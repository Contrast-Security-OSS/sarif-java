package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Level {
  @JsonProperty("none")
  NONE,
  @JsonProperty("note")
  NOTE,
  @JsonProperty("warning")
  WARNING,
  @JsonProperty("error")
  ERROR
}
