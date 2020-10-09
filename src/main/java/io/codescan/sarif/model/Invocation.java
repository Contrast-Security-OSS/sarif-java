package io.codescan.sarif.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * The runtime environment of the analysis tool run.
 */
@Data
@Accessors(chain = true)
public class Invocation {
    /**
     * The command line used to invoke the tool.
     */
    private String commandLine;
    /**
     * An array of strings, containing in order the command line arguments passed to the tool from the operating system.
     */
    private List<String> arguments;
    /**
     * The locations of any response files specified on the tool's command line.
     */
    private List<ArtifactLocation> responseFiles;
    /**
     * The Coordinated Universal Time (UTC) date and time at which the invocation started. See \"Date/time properties\"
     * in the SARIF spec for the required format.
     */
    private Instant startTimeUtc;
    /**
     * The Coordinated Universal Time (UTC) date and time at which the invocation ended. See \"Date/time properties\"
     * in the SARIF spec for the required format.
     */
    private Instant endTimeUtc;
    /**
     * The process exit code.
     */
    private Integer exitCode;
    /**
     * An array of configurationOverride objects that describe rules related runtime overrides.
     */
    //TODO: private List<ConfigurationOverride> ruleConfigurationOverrides;
    /**
     * An array of configurationOverride objects that describe notifications related runtime overrides.
     */
    //TODO: private List<ConfigurationOverride> notificationConfigurationOverrides;
    /**
     * A list of runtime conditions detected by the tool during the analysis.
     */
    private List<Notification> toolExecutionNotifications;
    /**
     * A list of conditions detected by the tool that are relevant to the tool's configuration.
     */
    private List<Notification> toolConfigurationNotifications;
    /**
     * The reason for the process exit.
     */
    private String exitCodeDescription;
    /**
     * The name of the signal that caused the process to exit.
     */
    private String exitSignalName;
    /**
     * The numeric value of the signal that caused the process to exit.
     */
    private Integer exitSignalNumber;
    /**
     * The reason given by the operating system that the process failed to start.
     */
    private String processStartFailureMessage;
    /**
     * Specifies whether the tool's execution completed successfully.
     */
    private Boolean executionSuccessful;
    /**
     * The machine on which the invocation occurred.
     */
    private String machine;
    /**
     * The account under which the invocation occurred.
     */
    private String account;
    /**
     * The id of the process in which the invocation occurred.
     */
    private Integer processId;
    /**
     * An absolute URI specifying the location of the executable that was invoked.
     */
    private ArtifactLocation executableLocation;
    /**
     * The working directory for the invocation.
     */
    private ArtifactLocation workingDirectory;
    /**
     * The environment variables associated with the analysis tool process, expressed as key/value pairs.
     */
    private Map<String, String> environmentVariables;
    /**
     * A file containing the standard input stream to the process that was invoked.
     */
    private ArtifactLocation stdin;
    /**
     * A file containing the standard output stream from the process that was invoked.
     */
    private ArtifactLocation stdout;
    /**
     * A file containing the standard error stream from the process that was invoked.
     */
    private ArtifactLocation stderr;
    /**
     * A file containing the interleaved standard output and standard error stream from the process that was invoked.
     */
    private ArtifactLocation stdoutStderr;
    /**
     * Key/value pairs that provide additional information about the invocation.
     */
    private PropertyBag properties;
}
