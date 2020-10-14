package com.contrastsecurity.sarif.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.Nullable;

/**
 * A physical or virtual address, or a range of addresses, in an 'addressable region' (memory or a
 * binary file).
 */
@AutoValue
public abstract class Address {

  /** The address expressed as a byte offset from the start of the addressable region. */
  @JsonProperty("absoluteAddress")
  @Nullable
  public abstract Integer absoluteAddress();

  /**
   * The address expressed as a byte offset from the absolute address of the top-most parent object.
   */
  @JsonProperty("relativeAddress")
  @Nullable
  public abstract Integer relativeAddress();

  /** The number of bytes in this range of addresses. */
  @JsonProperty("length")
  @Nullable
  public abstract Integer length();

  /**
   * An open-ended string that identifies the address kind. 'data', 'function',
   * 'header','instruction', 'module', 'page', 'section', 'segment', 'stack', 'stackFrame', 'table'
   * are well-known values.
   */
  @JsonProperty("kind")
  @Nullable
  public abstract String kind();

  /** A name that is associated with the address, e.g., '.text'. */
  @JsonProperty("name")
  @Nullable
  public abstract String name();

  /** A human-readable fully qualified name that is associated with the address. */
  @JsonProperty("fullyQualifiedName")
  @Nullable
  public abstract String fullyQualifiedName();

  /** The byte offset of this address from the absolute or relative address of the parent object. */
  @JsonProperty("offsetFromParent")
  @Nullable
  public abstract Integer offsetFromParent();

  /** The index within run.addresses of the cached object for this address. */
  @JsonProperty("index")
  @Nullable
  public abstract Integer index();

  /** The index within run.addresses of the parent object. */
  @JsonProperty("parentIndex")
  @Nullable
  public abstract Integer parentIndex();

  /** Key/value pairs that provide additional information about the address. */
  @JsonProperty("properties")
  @Nullable
  public abstract PropertyBag propertyBag();

  public static Address.Builder builder() {
    return new AutoValue_Address.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Address.Builder setAbsoluteAddress(Integer index);

    public abstract Address.Builder setRelativeAddress(Integer index);

    public abstract Address.Builder setLength(Integer index);

    public abstract Address.Builder setKind(String kind);

    public abstract Address.Builder setName(String name);

    public abstract Address.Builder setFullyQualifiedName(String name);

    public abstract Address.Builder setOffsetFromParent(Integer index);

    public abstract Address.Builder setIndex(Integer index);

    public abstract Address.Builder setParentIndex(Integer index);

    public abstract Address.Builder setPropertyBag(PropertyBag bag);

    public abstract Address build();
  }
}
