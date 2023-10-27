@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    // Custom Gradle plugins
    includeBuild("./plugins")
}

plugins {
    id("com.marmatsan.dependencies") apply true
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "time-matters"
include(
    ":app",
    ":core:core_data",
    ":core:core_domain",
    ":core:core_ui",
    ":onboarding:onboarding_ui"
)
 