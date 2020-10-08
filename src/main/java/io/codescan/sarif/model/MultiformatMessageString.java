package io.codescan.sarif.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A message string or message format string rendered in multiple formats.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MultiformatMessageString {

    /**
     * A plain text message string or format string.
     */
    private String text;
    /**
     * A Markdown message string or format string.
     */
    private String markdown;
    /**
     * Key/value pairs that provide additional information about the message.
     */
    private PropertyBag properties;

    public MultiformatMessageString(String text) {
        this.text = text;
    }
}
