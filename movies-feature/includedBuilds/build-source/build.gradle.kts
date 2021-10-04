plugins {
    `kotlin-dsl`
    id("my-build-configuration-plugin")
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("my-project-plugin") {
            id = "my-project-plugin"
            implementationClass = "ProjectPlugin"
        }

        register("my-library-plugin") {
            id = "my-library-plugin"
            implementationClass = "LibraryPlugin"
        }
    }
}

dependencies {
    implementation(Dependencies.Libs.BUILD_CONFIGURATION_PLUGIN_LIB)

    implementation(Dependencies.Libs.AGP_LIB)
    implementation(Dependencies.Libs.KOTLIN_LIB)
    implementation(Dependencies.Libs.SAFE_ARGS_GRADLE_PLUGIN_LIB)
}