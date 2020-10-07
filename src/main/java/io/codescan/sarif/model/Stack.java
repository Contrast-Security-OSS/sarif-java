package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Stack {
    /**
     * A message relevant to this call stack.
     */
    private Message message;
    /**
     * An array of stack frames that represents a sequence of calls, rendered in reverse chronological order, that
     * comprise the call stack.
     */
    private List<StackFrame> frames;
    /**
     * Key/value pairs that provide additional information about the stack.
     */
    private PropertyBag properties;
}
