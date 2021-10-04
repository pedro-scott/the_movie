object Dependencies {
    object Version {
        // My Plugin
        const val BUILD_CONFIGURATION_PLUGIN_VERSION = "1.0.0"

        // Library Details
        const val COMPILE_SDK_VERSION = 31
        const val MIN_SDK_VERSION = 22
        const val TARGET_SDK_VERSION = 31

        // Classpath
        const val AGP_VERSION = "7.0.2"
        const val KOTLIN_VERSION = "1.5.30"

        // Implementation
        const val CORE_VERSION = "1.6.0"
        const val APPCOMPAT_VERSION = "1.3.1"
        const val MATERIAL_VERSION = "1.4.0"
        const val CONSTRAINT_LAYOUT_VERSION = "2.1.0"
        const val JUNIT_VERSION = "4.13.2"
        const val JUNIT_EXT_VERSION = "1.1.3"
        const val ESPRESSO_VERSION = "3.4.0"
    }

    object Libs {
        // My Plugin
        const val BUILD_CONFIGURATION_PLUGIN_LIB = "com.pedro.gradle:build-configuration:${Version.BUILD_CONFIGURATION_PLUGIN_VERSION}"

        // Classpath
        const val AGP_LIB = "com.android.tools.build:gradle:${Version.AGP_VERSION}"
        const val KOTLIN_LIB = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_VERSION}"

        // Implementation
        const val CORE_LIB = "androidx.core:core-ktx:${Version.CORE_VERSION}"
        const val APPCOMPAT_LIB = "androidx.appcompat:appcompat:${Version.APPCOMPAT_VERSION}"
        const val MATERIAL_LIB = "com.google.android.material:material:${Version.MATERIAL_VERSION}"
        const val CONSTRAINT_LAYOUT_LIB = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT_VERSION}"
        const val JUNIT_LIB = "junit:junit:${Version.JUNIT_VERSION}"
        const val JUNIT_EXT_LIB = "androidx.test.ext:junit:${Version.JUNIT_EXT_VERSION}"
        const val ESPRESSO_LIB = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_VERSION}"
    }
}