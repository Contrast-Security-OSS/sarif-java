package io.codescan.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * The runtime environment of the analysis tool run.
 */
@AutoValue
public abstract class Invocation {
    /**
     * The command line used to invoke the tool.
     */
    @JsonProperty("commandLine")
    @Nullable
    public abstract String commandLine();
    /**
     * An array of strings, containing in order the command line arguments passed to the tool from the operating system.
     */
    @JsonProperty("arguments")
    @Nullable
    public abstract List<String> arguments();
    /**
     * The locations of any response files specified on the tool's command line.
     */
    @JsonProperty("responseFiles")
    @Nullable
    public abstract List<ArtifactLocation> responseFiles();
    /**
     * The Coordinated Universal Time (UTC) date and time at which the invocation started. See \"Date/time properties\"
     * in the SARIF spec for the required format.
     */
    @JsonProperty("startTimeUtc")
    @Nullable
    public abstract Instant startTimeUtc();
    /**
     * The Coordinated Universal Time (UTC) date and time at which the invocation ended. See \"Date/time properties\"
     * in the SARIF spec for the required format.
     */
    @JsonProperty("endTimeUtc")
    @Nullable
    public abstract Instant endTimeUtc();
    /**
     * The process exit code.
     */
    @JsonProperty("exitCode")
    @Nullable
    public abstract Integer exitCode();
    /**
     * An array of configurationOverride objects that describe rules related runtime overrides.
     */
    //@JsonProperty("ruleConfigurationOverrides")
    //@Nullable
    //TODO: public abstract List<ConfigurationOverride> ruleConfigurationOverrides();
    /**
     * An array of configurationOverride objects that describe notifications related runtime overrides.
     */
    //@JsonProperty("notificationConfigurationOverrides")
    //@Nullable
    //TODO: public abstract List<ConfigurationOverride> notificationConfigurationOverrides();
    /**
     * A list of runtime conditions detected by the tool during the analysis.
     */
    @JsonProperty("toolExecutionNotifications")
    @Nullable
    public abstract List<Notification> toolExecutionNotifications();
    /**
     * A list of conditions detected by the tool that are relevant to the tool's configuration.
     */
    @JsonProperty("toolConfigurationNotifications")
    @Nullable
    public abstract List<Notification> toolConfigurationNotifications();
    /**
     * The reason for the process exit.
     */
    @JsonProperty("exitCodeDescription")
    @Nullable
    public abstract String exitCodeDescription();
    /**
     * The name of the signal that caused the process to exit.
     */
    @JsonProperty("exitSignalName")
    @Nullable
    public abstract String exitSignalName();
    /**
     * The numeric value of the signal that caused the process to exit.
     */
    @JsonProperty("exitSignalNumber")
    @Nullable
    public abstract Integer exitSignalNumber();
    /**
     * The reason given by the operating system that the process failed to start.
     */
    @JsonProperty("processStartFailureMessage")
    @Nullable
    public abstract String processStartFailureMessage();
    /**
     * Specifies whether the tool's execution completed successfully.
     */
    @JsonProperty("executionSuccessful")
    @Nullable
    public abstract Boolean executionSuccessful();
    /**
     * The machine on which the invocation occurred.
     */
    @JsonProperty("machine")
    @Nullable
    public abstract String machine();
    /**
     * The account under which the invocation occurred.
     */
    @JsonProperty("account")
    @Nullable
    public abstract String account();
    /**
     * The id of the process in which the invocation occurred.
     */
    @JsonProperty("processId")
    @Nullable
    public abstract Integer processId();
    /**
     * An absolute URI specifying the location of the executable that was invoked.
     */
    @JsonProperty("executableLocation")
    @Nullable
    public abstract ArtifactLocation executableLocation();
    /**
     * The working directory for the invocation.
     */
    @JsonProperty("workingDirectory")
    @Nullable
    public abstract ArtifactLocation workingDirectory();
    /**
     * The environment variables associated with the analysis tool process, expressed as key/value pairs.
     */
    @JsonProperty("environmentVariables")
    @Nullable
    public abstract Map<String, String> environmentVariables();
    /**
     * A file containing the standard input stream to the process that was invoked.
     */
    @JsonProperty("stdin")
    @Nullable
    public abstract ArtifactLocation stdin();
    /**
     * A file containing the standard output stream from the process that was invoked.
     */
    @JsonProperty("stdout")
    @Nullable
    public abstract ArtifactLocation stdout();
    /**
     * A file containing the standard error stream from the process that was invoked.
     */
    @JsonProperty("stderr")
    @Nullable
    public abstract ArtifactLocation stderr();
    /**
     * A file containing the interleaved standard output and standard error stream from the process that was invoked.
     */
    @JsonProperty("stdoutStderr")
    @Nullable
    public abstract ArtifactLocation stdoutStderr();
    /**
     * Key/value pairs that provide additional information about the invocation.
     */
    @JsonProperty("properties")
    @Nullable
    public abstract PropertyBag properties();
    public static Invocation.Builder builder() {
        return new AutoValue_Invocation.Builder();
    }
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Invocation.Builder setCommandLine(String commandLine);
        public abstract Invocation.Builder setArguments(List<String> arguments);
        public abstract Invocation.Builder setResponseFiles(List<ArtifactLocation> responseFiles);
        public abstract Invocation.Builder setStartTimeUtc(Instant startTimeUtc);
        public abstract Invocation.Builder setEndTimeUtc(Instant endTimeUtc);
        public abstract Invocation.Builder setExitCode(Integer exitCode);
        //TODO: public abstract Invocation.Builder setRuleConfigurationOverrides(List<ConfigurationOverride> ruleConfigurationOverrides);
        //TODO: public abstract Invocation.Builder setNotificationConfigurationOverrides(List<ConfigurationOverride> notificationConfigurationOverrides);
        public abstract Invocation.Builder setToolExecutionNotifications(List<Notification> toolExecutionNotifications);
        public abstract Invocation.Builder setToolConfigurationNotifications(List<Notification> toolConfigurationNotifications);
        public abstract Invocation.Builder setExitCodeDescription(String exitCodeDescription);
        public abstract Invocation.Builder setExitSignalName(String exitSignalName);
        public abstract Invocation.Builder setExitSignalNumber(Integer exitSignalNumber);
        public abstract Invocation.Builder setProcessStartFailureMessage(String processStartFailureMessage);
        public abstract Invocation.Builder setExecutionSuccessful(Boolean executionSuccessful);
        public abstract Invocation.Builder setMachine(String machine);
        public abstract Invocation.Builder setAccount(String account);
        public abstract Invocation.Builder setProcessId(Integer processId);
        public abstract Invocation.Builder setExecutableLocation(ArtifactLocation executableLocation);
        public abstract Invocation.Builder setWorkingDirectory(ArtifactLocation workingDirectory);
        public abstract Invocation.Builder setEnvironmentVariables(Map<String, String> environmentVariables);
        public abstract Invocation.Builder setStdin(ArtifactLocation stdin);
        public abstract Invocation.Builder setStdout(ArtifactLocation stdout);
        public abstract Invocation.Builder setStderr(ArtifactLocation stderr);
        public abstract Invocation.Builder setStdoutStderr(ArtifactLocation stdoutStderr);
        public abstract Invocation.Builder setProperties(PropertyBag properties);
        public abstract Invocation build();
    }
}
