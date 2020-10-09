package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Conversion {
    /**
     * A tool object that describes the converter.
     */
    private Tool tool;
    /**
     * An invocation object that describes the invocation of the converter.
     */
    private Invocation invocation;
    /**
     * The locations of the analysis tool's per-run log files.
     */
    private List<ArtifactLocation> analysisToolLogFiles;
    /**
     * Key/value pairs that provide additional information about the conversion.
     */
    private PropertyBag properties;
}
