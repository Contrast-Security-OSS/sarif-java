package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StackFrame {
    /**
     * The location to which this stack frame refers.
     */
    private Location location;
    /**
     * The name of the module that contains the code of this stack frame.
     */
    private String module;
    /**
     * The thread identifier of the stack frame.
     */
    private Integer threadId;
    /**
     * The parameters of the call that is executing.
     */
    private List<String> parameters;
    /**
     * Key/value pairs that provide additional information about the stack frame.
     */
    private PropertyBag properties;
}
