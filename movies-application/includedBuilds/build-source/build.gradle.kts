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

        register("my-application-plugin") {
            id = "my-application-plugin"
            implementationClass = "ApplicationPlugin"
        }
    }
}

dependencies {
    implementation(Dependencies.Libs.BUILD_CONFIGURATION_PLUGIN_LIB)

    implementation(Dependencies.Libs.AGP_LIB)
    implementation(Dependencies.Libs.KOTLIN_LIB)
}