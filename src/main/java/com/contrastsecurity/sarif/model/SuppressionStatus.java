package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** A string that indicates the review status of the suppression. */
public enum SuppressionStatus {
  @JsonProperty("accepted")
  ACCEPTED,
  @JsonProperty("underReview")
  UNDERREVIEW,
  @JsonProperty("rejected")
  REJECTED
}
