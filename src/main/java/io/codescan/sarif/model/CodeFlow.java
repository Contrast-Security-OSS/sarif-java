package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * A set of threadFlows which together describe a pattern of code execution relevant to detecting a result.
 */
@Data
@Accessors(chain = true)
public class CodeFlow {
    /**
     * A message relevant to the code flow.
     */
    private Message message;
    /**
     * An array of one or more unique threadFlow objects, each of which describes the progress of a program through a
     * thread of execution.
     */
    private List<ThreadFlow> threadFlows;

    /**
     * Key/value pairs that provide additional information about the code flow.
     */
    private PropertyBag properties;

}
