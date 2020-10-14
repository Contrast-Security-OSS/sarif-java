package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SeverityLevel {
  NONE,
  NOTE,
  WARNING,
  ERROR;

  @JsonValue
  public String getValue() {
    return name().toLowerCase();
  }
}
