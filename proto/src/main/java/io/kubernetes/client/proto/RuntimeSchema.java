// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: k8s.io/apimachinery/pkg/runtime/schema/generated.proto
// Protobuf Java Version: 4.26.1

package io.kubernetes.client.proto;

public final class RuntimeSchema {
  private RuntimeSchema() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      RuntimeSchema.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n6k8s.io/apimachinery/pkg/runtime/schema" +
      "/generated.proto\022&k8s.io.apimachinery.pk" +
      "g.runtime.schemaBS\n\032io.kubernetes.client" +
      ".protoB\rRuntimeSchemaZ&k8s.io/apimachine" +
      "ry/pkg/runtime/schema"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}