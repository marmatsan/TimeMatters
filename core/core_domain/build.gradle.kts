plugins {
    alias(plugins.plugins.com.android.library)
    alias(plugins.plugins.com.google.protobuf)
    id("com.marmatsan.android")
}

dependencies {
    /* Libraries */
    implementation(libs.com.google.protobuf)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.24.3"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}