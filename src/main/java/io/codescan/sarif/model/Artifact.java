package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@AutoValue
public abstract class Artifact {
    /**
     * A short description of the artifact.
     */
    @JsonProperty("description")
    @Nullable
    public abstract Message description();
    /**
     * The location of the artifact.
     */
    @JsonProperty("location")
    @Nullable
    public abstract ArtifactLocation location();
    /**
     * Identifies the index of the immediate parent of the artifact, if this artifact is nested.
     */
    @JsonProperty("parentIndex")
    @Nullable
    public abstract Integer parentIndex();
    /**
     * The offset in bytes of the artifact within its containing artifact.
     */
    @JsonProperty("offset")
    @Nullable
    public abstract Integer offset();
    /**
     * The length of the artifact in bytes.
     */
    @JsonProperty("length")
    @Nullable
    public abstract Integer length();
    /**
     * Specifies the source language for any artifact object that refers to a text file that contains source code.
     */
    @JsonProperty("sourceLanguage")
    @Nullable
    public abstract String sourceLanguage();
    /**
     * A dictionary, each of whose keys is the name of a hash function and each of whose values is the hashed value of
     * the artifact produced by the specified hash function.
     */
    @JsonProperty("hashes")
    @Nullable
    public abstract Map<String, String> hashes();
    public static Artifact.Builder builder() {
        return new AutoValue_Artifact.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Artifact.Builder setDescription(Message description);
        public abstract Artifact.Builder setLocation(ArtifactLocation location);
        public abstract Artifact.Builder setParentIndex(Integer parentIndex);
        public abstract Artifact.Builder setOffset(Integer offset);
        public abstract Artifact.Builder setLength(Integer length);
        public abstract Artifact.Builder setSourceLanguage(String sourceLanguage);
        public abstract Artifact.Builder setHashes(Map<String, String> hashes);
        public abstract Artifact build();
    }
}
