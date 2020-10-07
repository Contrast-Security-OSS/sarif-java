package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
public class Artifact {
    /**
     * A short description of the artifact.
     */
    private Message description;
    /**
     * The location of the artifact.
     */
    private ArtifactLocation location;
    /**
     * Identifies the index of the immediate parent of the artifact, if this artifact is nested.
     */
    private Integer parentIndex;
    /**
     * The offset in bytes of the artifact within its containing artifact.
     */
    private Integer offset;
    /**
     * The length of the artifact in bytes.
     */
    private Integer length;
    /**
     * Specifies the source language for any artifact object that refers to a text file that contains source code.
     */
    private String sourceLanguage;
    /**
     * A dictionary, each of whose keys is the name of a hash function and each of whose values is the hashed value of
     * the artifact produced by the specified hash function.
     */
    private Map<String, String> hashes;
}
