package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * Describes a sequence of code locations that specify a path through a single thread of execution such as an operating
 * system or fiber.
 */
@Data
@Accessors(chain = true)
public class ThreadFlow {
    /**
     * An string that uniquely identifies the threadFlow within the codeFlow in which it occurs.
     */
    private String id;
    /**
     * A message relevant to the thread flow.
     */
    private Message message;
    /**
     * Values of relevant expressions at the start of the thread flow that may change during thread flow execution.
     */
    private Map<String, MultiformatMessageString> initialState;
    /**
     * Values of relevant expressions at the start of the thread flow that remain constant.
     */
    private Map<String, MultiformatMessageString> immutableState;
    /**
     * A temporally ordered array of 'threadFlowLocation' objects, each of which describes a location visited by the
     * tool while producing the result.
     */
    private List<ThreadFlowLocation> locations;
    /**
     * Key/value pairs that provide additional information about the thread flow.
     */
    private PropertyBag properties;
}
