package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Importance {
  @JsonProperty("essential")
  ESSENTIAL,
  @JsonProperty("important")
  IMPORTANT,
  @JsonProperty("unimportant")
  UNIMPORTANT
}
