rootProject.name = "movies-feature"
include(":movies-feature")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

includeBuild("includedBuilds/build-configuration")
includeBuild("includedBuilds/build-source")