package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

@AutoValue
public abstract class Rule {

    @JsonProperty("id")
    @Nullable
    public abstract String id();

    @JsonProperty("name")
    @Nullable
    public abstract String name();

    @JsonProperty("help")
    @Nullable
    public abstract MultiformatMessageString help();
    public static Rule.Builder builder() {
        return new AutoValue_Rule.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Rule.Builder setId(String id);
        public abstract Rule.Builder setName(String name);
        public abstract Rule.Builder setHelp(MultiformatMessageString help);
        public abstract Rule build();
    }
}
