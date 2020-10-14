package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BaselineState {
  @JsonProperty("new")
  NEW,
  @JsonProperty("unchanged")
  UNCHANGED,
  @JsonProperty("updated")
  UPDATED,
  @JsonProperty("absent")
  ABSENT
}
