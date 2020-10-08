package io.codescan.sarif.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

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
