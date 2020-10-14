package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ArtifactRole {
  @JsonProperty("analysisTarget")
  ANALYSIS_TARGET,
  @JsonProperty("attachment")
  ATTACHMENT,
  @JsonProperty("responseFile")
  RESPONSE_FILE,
  @JsonProperty("resultFile")
  RESULT_FILE,
  @JsonProperty("standardStream")
  STANDARD_STREAM,
  @JsonProperty("tracedFile")
  TRACED_FILE,
  @JsonProperty("unmodified")
  UNMODIFIED,
  @JsonProperty("modified")
  MODIFIED,
  @JsonProperty("added")
  ADDED,
  @JsonProperty("deleted")
  DELETED,
  @JsonProperty("renamed")
  RENAMED,
  @JsonProperty("uncontrolled")
  UNCONTROLLED,
  @JsonProperty("driver")
  DRIVER,
  @JsonProperty("extension")
  EXTENSION,
  @JsonProperty("translation")
  TRANSLATION,
  @JsonProperty("taxonomy")
  TAXONOMY,
  @JsonProperty("policy")
  POLICY,
  @JsonProperty("referencedOnCommandLine")
  REFERENCED_ON_COMMAND_LINE,
  @JsonProperty("memoryContents")
  MEMORY_CONTENTS,
  @JsonProperty("directory")
  DIRECTORY,
  @JsonProperty("userSpecifiedConfiguration")
  USER_SPECIFIC_CONFIGURATION,
  @JsonProperty("toolSpecifiedConfiguration")
  TOOL_SPECIFIC_CONFIGURATION,
  @JsonProperty("debugOutputFile")
  DEBUG_OUTPUT_FILE
}
