package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

@AutoValue
/** A logical location of a construct that produced a result. */
public abstract class LogicalLocation {
  /**
   * Identifies the construct in which the result occurred. For example, this property might contain
   * the name of a class or a method.
   */
  @JsonProperty("name")
  @Nullable
  public abstract String name();
  /** The index within the logical locations array. */
  @JsonProperty("index")
  @Nullable
  public abstract Integer index();
  /** The human-readable fully qualified name of the logical location. */
  @JsonProperty("fullyQualifiedName")
  @Nullable
  public abstract String fullyQualifiedName();
  /**
   * The machine-readable name for the logical location, such as a mangled function name provided by
   * a C++ compiler that encodes calling convention, return type and other details along with the
   * function name.
   */
  @JsonProperty("decoratedName")
  @Nullable
  public abstract String decoratedName();
  /**
   * Identifies the index of the immediate parent of the construct in which the result was detected.
   * For example, this property might point to a logical location that represents the namespace that
   * holds a type.
   */
  @JsonProperty("parentIndex")
  @Nullable
  public abstract Integer parentIndex();
  /**
   * The type of construct this logical location component refers to. Should be one of 'function',
   * 'member', 'module', 'namespace', 'parameter', 'resource', 'returnType', 'type', 'variable',
   * 'object', 'array', 'property', 'value', 'element', 'text', 'attribute', 'comment',
   * 'declaration', 'dtd' or 'processingInstruction', if any of those accurately describe the
   * construct.
   */
  @JsonProperty("kind")
  @Nullable
  public abstract String kind();
  /** Key/value pairs that provide additional information about the logical location. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag properties();

  public static LogicalLocation.Builder builder() {
    return new AutoValue_LogicalLocation.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract LogicalLocation.Builder setName(String name);

    public abstract LogicalLocation.Builder setIndex(Integer index);

    public abstract LogicalLocation.Builder setFullyQualifiedName(String fullyQualifiedName);

    public abstract LogicalLocation.Builder setDecoratedName(String decoratedName);

    public abstract LogicalLocation.Builder setParentIndex(Integer parentIndex);

    public abstract LogicalLocation.Builder setKind(String kind);

    public abstract LogicalLocation.Builder setProperties(PropertyBag properties);

    public abstract LogicalLocation build();
  }
}
