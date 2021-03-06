// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msg.proto

package com.baidu.chunlei.exercise.protobuf;

public final class ProtoBufferPractice {
  private ProtoBufferPractice() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface msgInfoOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 ID = 1;
    /**
     * <code>required int32 ID = 1;</code>
     */
    boolean hasID();
    /**
     * <code>required int32 ID = 1;</code>
     */
    int getID();

    // required string Guid = 4;
    /**
     * <code>required string Guid = 4;</code>
     */
    boolean hasGuid();
    /**
     * <code>required string Guid = 4;</code>
     */
    java.lang.String getGuid();
    /**
     * <code>required string Guid = 4;</code>
     */
    com.google.protobuf.ByteString
        getGuidBytes();

    // required bytes image = 3;
    /**
     * <code>required bytes image = 3;</code>
     */
    boolean hasImage();
    /**
     * <code>required bytes image = 3;</code>
     */
    com.google.protobuf.ByteString getImage();

    // repeated int32 phoneNumber = 5;
    /**
     * <code>repeated int32 phoneNumber = 5;</code>
     */
    java.util.List<java.lang.Integer> getPhoneNumberList();
    /**
     * <code>repeated int32 phoneNumber = 5;</code>
     */
    int getPhoneNumberCount();
    /**
     * <code>repeated int32 phoneNumber = 5;</code>
     */
    int getPhoneNumber(int index);
  }
  /**
   * Protobuf type {@code com.baidu.chunlei.exercise.protobuf.msgInfo}
   */
  public static final class msgInfo extends
      com.google.protobuf.GeneratedMessage
      implements msgInfoOrBuilder {
    // Use msgInfo.newBuilder() to construct.
    private msgInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private msgInfo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final msgInfo defaultInstance;
    public static msgInfo getDefaultInstance() {
      return defaultInstance;
    }

    public msgInfo getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private msgInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              iD_ = input.readInt32();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              image_ = input.readBytes();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000002;
              guid_ = input.readBytes();
              break;
            }
            case 40: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                phoneNumber_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000008;
              }
              phoneNumber_.add(input.readInt32());
              break;
            }
            case 42: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008) && input.getBytesUntilLimit() > 0) {
                phoneNumber_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000008;
              }
              while (input.getBytesUntilLimit() > 0) {
                phoneNumber_.add(input.readInt32());
              }
              input.popLimit(limit);
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          phoneNumber_ = java.util.Collections.unmodifiableList(phoneNumber_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo.class, com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo.Builder.class);
    }

    public static com.google.protobuf.Parser<msgInfo> PARSER =
        new com.google.protobuf.AbstractParser<msgInfo>() {
      public msgInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new msgInfo(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<msgInfo> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 ID = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private int iD_;
    /**
     * <code>required int32 ID = 1;</code>
     */
    public boolean hasID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 ID = 1;</code>
     */
    public int getID() {
      return iD_;
    }

    // required string Guid = 4;
    public static final int GUID_FIELD_NUMBER = 4;
    private java.lang.Object guid_;
    /**
     * <code>required string Guid = 4;</code>
     */
    public boolean hasGuid() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string Guid = 4;</code>
     */
    public java.lang.String getGuid() {
      java.lang.Object ref = guid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          guid_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string Guid = 4;</code>
     */
    public com.google.protobuf.ByteString
        getGuidBytes() {
      java.lang.Object ref = guid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        guid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required bytes image = 3;
    public static final int IMAGE_FIELD_NUMBER = 3;
    private com.google.protobuf.ByteString image_;
    /**
     * <code>required bytes image = 3;</code>
     */
    public boolean hasImage() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required bytes image = 3;</code>
     */
    public com.google.protobuf.ByteString getImage() {
      return image_;
    }

    // repeated int32 phoneNumber = 5;
    public static final int PHONENUMBER_FIELD_NUMBER = 5;
    private java.util.List<java.lang.Integer> phoneNumber_;
    /**
     * <code>repeated int32 phoneNumber = 5;</code>
     */
    public java.util.List<java.lang.Integer>
        getPhoneNumberList() {
      return phoneNumber_;
    }
    /**
     * <code>repeated int32 phoneNumber = 5;</code>
     */
    public int getPhoneNumberCount() {
      return phoneNumber_.size();
    }
    /**
     * <code>repeated int32 phoneNumber = 5;</code>
     */
    public int getPhoneNumber(int index) {
      return phoneNumber_.get(index);
    }

    private void initFields() {
      iD_ = 0;
      guid_ = "";
      image_ = com.google.protobuf.ByteString.EMPTY;
      phoneNumber_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasGuid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasImage()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, iD_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, image_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(4, getGuidBytes());
      }
      for (int i = 0; i < phoneNumber_.size(); i++) {
        output.writeInt32(5, phoneNumber_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, iD_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, image_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getGuidBytes());
      }
      {
        int dataSize = 0;
        for (int i = 0; i < phoneNumber_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(phoneNumber_.get(i));
        }
        size += dataSize;
        size += 1 * getPhoneNumberList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.baidu.chunlei.exercise.protobuf.msgInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo.class, com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo.Builder.class);
      }

      // Construct using com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        iD_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        guid_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        image_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        phoneNumber_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_descriptor;
      }

      public com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo getDefaultInstanceForType() {
        return com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo.getDefaultInstance();
      }

      public com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo build() {
        com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo buildPartial() {
        com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo result = new com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.iD_ = iD_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.guid_ = guid_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.image_ = image_;
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          phoneNumber_ = java.util.Collections.unmodifiableList(phoneNumber_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.phoneNumber_ = phoneNumber_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo) {
          return mergeFrom((com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo other) {
        if (other == com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo.getDefaultInstance()) return this;
        if (other.hasID()) {
          setID(other.getID());
        }
        if (other.hasGuid()) {
          bitField0_ |= 0x00000002;
          guid_ = other.guid_;
          onChanged();
        }
        if (other.hasImage()) {
          setImage(other.getImage());
        }
        if (!other.phoneNumber_.isEmpty()) {
          if (phoneNumber_.isEmpty()) {
            phoneNumber_ = other.phoneNumber_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensurePhoneNumberIsMutable();
            phoneNumber_.addAll(other.phoneNumber_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasID()) {
          
          return false;
        }
        if (!hasGuid()) {
          
          return false;
        }
        if (!hasImage()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.chunlei.exercise.protobuf.ProtoBufferPractice.msgInfo) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 ID = 1;
      private int iD_ ;
      /**
       * <code>required int32 ID = 1;</code>
       */
      public boolean hasID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 ID = 1;</code>
       */
      public int getID() {
        return iD_;
      }
      /**
       * <code>required int32 ID = 1;</code>
       */
      public Builder setID(int value) {
        bitField0_ |= 0x00000001;
        iD_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 ID = 1;</code>
       */
      public Builder clearID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        iD_ = 0;
        onChanged();
        return this;
      }

      // required string Guid = 4;
      private java.lang.Object guid_ = "";
      /**
       * <code>required string Guid = 4;</code>
       */
      public boolean hasGuid() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string Guid = 4;</code>
       */
      public java.lang.String getGuid() {
        java.lang.Object ref = guid_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          guid_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string Guid = 4;</code>
       */
      public com.google.protobuf.ByteString
          getGuidBytes() {
        java.lang.Object ref = guid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          guid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string Guid = 4;</code>
       */
      public Builder setGuid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        guid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string Guid = 4;</code>
       */
      public Builder clearGuid() {
        bitField0_ = (bitField0_ & ~0x00000002);
        guid_ = getDefaultInstance().getGuid();
        onChanged();
        return this;
      }
      /**
       * <code>required string Guid = 4;</code>
       */
      public Builder setGuidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        guid_ = value;
        onChanged();
        return this;
      }

      // required bytes image = 3;
      private com.google.protobuf.ByteString image_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes image = 3;</code>
       */
      public boolean hasImage() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required bytes image = 3;</code>
       */
      public com.google.protobuf.ByteString getImage() {
        return image_;
      }
      /**
       * <code>required bytes image = 3;</code>
       */
      public Builder setImage(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        image_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes image = 3;</code>
       */
      public Builder clearImage() {
        bitField0_ = (bitField0_ & ~0x00000004);
        image_ = getDefaultInstance().getImage();
        onChanged();
        return this;
      }

      // repeated int32 phoneNumber = 5;
      private java.util.List<java.lang.Integer> phoneNumber_ = java.util.Collections.emptyList();
      private void ensurePhoneNumberIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          phoneNumber_ = new java.util.ArrayList<java.lang.Integer>(phoneNumber_);
          bitField0_ |= 0x00000008;
         }
      }
      /**
       * <code>repeated int32 phoneNumber = 5;</code>
       */
      public java.util.List<java.lang.Integer>
          getPhoneNumberList() {
        return java.util.Collections.unmodifiableList(phoneNumber_);
      }
      /**
       * <code>repeated int32 phoneNumber = 5;</code>
       */
      public int getPhoneNumberCount() {
        return phoneNumber_.size();
      }
      /**
       * <code>repeated int32 phoneNumber = 5;</code>
       */
      public int getPhoneNumber(int index) {
        return phoneNumber_.get(index);
      }
      /**
       * <code>repeated int32 phoneNumber = 5;</code>
       */
      public Builder setPhoneNumber(
          int index, int value) {
        ensurePhoneNumberIsMutable();
        phoneNumber_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 phoneNumber = 5;</code>
       */
      public Builder addPhoneNumber(int value) {
        ensurePhoneNumberIsMutable();
        phoneNumber_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 phoneNumber = 5;</code>
       */
      public Builder addAllPhoneNumber(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensurePhoneNumberIsMutable();
        super.addAll(values, phoneNumber_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 phoneNumber = 5;</code>
       */
      public Builder clearPhoneNumber() {
        phoneNumber_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.baidu.chunlei.exercise.protobuf.msgInfo)
    }

    static {
      defaultInstance = new msgInfo(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.baidu.chunlei.exercise.protobuf.msgInfo)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tmsg.proto\022#com.baidu.chunlei.exercise." +
      "protobuf\"G\n\007msgInfo\022\n\n\002ID\030\001 \002(\005\022\014\n\004Guid\030" +
      "\004 \002(\t\022\r\n\005image\030\003 \002(\014\022\023\n\013phoneNumber\030\005 \003(" +
      "\005B:\n#com.baidu.chunlei.exercise.protobuf" +
      "B\023ProtoBufferPractice"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_baidu_chunlei_exercise_protobuf_msgInfo_descriptor,
              new java.lang.String[] { "ID", "Guid", "Image", "PhoneNumber", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
