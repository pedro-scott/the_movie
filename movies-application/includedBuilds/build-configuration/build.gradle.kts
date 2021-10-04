plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

group = "com.pedro.gradle"
version = "1.0.0"

gradlePlugin {
    plugins {
        register("my-build-configuration-plugin") {
            id = "my-build-configuration-plugin"
            implementationClass = "BuildConfigurationPlugin"
        }
    }
}